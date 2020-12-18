package com.downloader.multithreaddownloader.downloader;

import com.downloader.multithreaddownloader.downloader.config.DownloaderConfig;
import com.downloader.multithreaddownloader.parser.DownloaderThread;
import com.downloader.multithreaddownloader.parser.ParserThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Downloader {

    private final DownloaderConfig downloaderConfig;

    public Downloader(DownloaderConfig downloaderConfig) {
	this.downloaderConfig = downloaderConfig;
    }

    public void start() throws InterruptedException {
	ExecutorService parseExecutor = Executors.newFixedThreadPool(downloaderConfig.getNumberOfParsingThreads());
	for (int i = 0; i < downloaderConfig.getNumberOfParsingThreads(); i++) {
	    parseExecutor.execute(new ParserThread(downloaderConfig));
	}
	parseExecutor.shutdown();

	ExecutorService downloadExecutor = Executors.newFixedThreadPool(downloaderConfig.getNumberOfDownloaderThreads());
	for (int i = 0; i < downloaderConfig.getNumberOfDownloaderThreads(); i++) {
	    downloadExecutor.execute(new DownloaderThread(downloaderConfig));
	}
	downloadExecutor.shutdown();
    }
}
