package com.downloader.multithreaddownloader.utils;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class IOUtils {

    private static final String DEFAULT_FILE_NAME = "index.html";

    public static File getWebSiteDownloadFolder(URL website, File dowloadLocation) {
	String fileName = getFileName(website);
	File webSiteFolder = new File(dowloadLocation, website.getHost());
	if (!webSiteFolder.exists() && !webSiteFolder.isDirectory()) {
	    webSiteFolder.mkdir();
	}
	return new File(webSiteFolder, fileName);
    }

    protected static String getFileName(URL url) {
	String fileName = url.getFile();
	if (StringUtil.isBlank(fileName)) {
	    fileName = DEFAULT_FILE_NAME;
	} else {
	    fileName = Paths.get(url.getPath()).getFileName().toString();
	}

	return fileName;
    }

    private IOUtils() {
    }
}
