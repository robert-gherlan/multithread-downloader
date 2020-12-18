package com.downloader.multithreaddownloader.parser;

import com.downloader.multithreaddownloader.downloader.config.DownloaderConfig;

import static com.downloader.multithreaddownloader.utils.IOUtils.getWebSiteDownloadFolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloaderThread extends Thread {

    private final DownloaderConfig downloaderConfig;

    public DownloaderThread(DownloaderConfig downloaderConfig) {
	this.downloaderConfig = downloaderConfig;
    }

    @Override
    public void run() {
	try {
	    String url = null;
	    while ((url = downloaderConfig.getUrlForDownloading()) != null) {
		try {
		    System.out.println(getId() + " start downloading file from " + url);
		    URL website = new URL(url);
		    File file = getWebSiteDownloadFolder(website, downloaderConfig.getDownloadLocation());
		    if (!file.exists()) {
			download(url, website, file);
		    }
		} catch (IOException e) {
		    System.err.println(getId() + " an error was occured when tried to download file from " + url + ": " + e.getMessage());
		}
	    }
	} catch (InterruptedException e) {
	    System.err.println(getId() + " failed to take urls from queue: " + e.getMessage());
	} finally {
	    downloaderConfig.countDown();
	}
    }

    private void download(String url, URL website, File file) {
	try (ReadableByteChannel readableByteChannel = Channels.newChannel(website.openStream()); FileOutputStream fileOutputStream = new FileOutputStream(file)) {
	    fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
	    System.out.println(getId() + " finished downloading file from " + url);
	} catch (IOException e) {
	    System.err.println("Failed to download file from " + url + ": " + e.getMessage());
	}
    }
}
