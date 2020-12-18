package com.downloader.multithreaddownloader.downloader.config;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.downloader.multithreaddownloader.utils.StringUtil;

public final class DownloaderConfig {

    public static final int WAIT_SECONDS = 60;

    private static final int URLS_TO_BE_DOWNLOADED_CAPACITY = 10_000;

    private static final boolean QUEUE_FAIRNESS = true;

    private final BlockingQueue<String> urlsToBeDownloaded = new ArrayBlockingQueue<>(URLS_TO_BE_DOWNLOADED_CAPACITY, QUEUE_FAIRNESS);

    private final Queue<String> urlsToBeParsed;

    private final boolean parseImages;

    private final boolean parseLinks;

    private final boolean parseScripts;

    private final Set<String> fileExtensions;

    private final File downloadLocation;

    private final int numberOfDownloaderThreads;

    private final int numberOfParsingThreads;

    private final CountDownLatch countDownLatch;

    public DownloaderConfig(CountDownLatch countDownLatch, Set<String> urlsToBeParsed, Set<String> fileExtensions, String location, int numberOfParsingThreads, int numberOfDownloaderThreads, boolean parseImages, boolean parseLinks, boolean parseScripts) {
	this.countDownLatch = Objects.requireNonNull(countDownLatch);
	if (urlsToBeParsed == null || urlsToBeParsed.isEmpty()) {
	    throw new IllegalArgumentException("Provide urls to be parsed.");
	}
	this.urlsToBeParsed = new ConcurrentLinkedQueue<>(urlsToBeParsed);

	if (fileExtensions == null || fileExtensions.isEmpty()) {
	    throw new IllegalArgumentException("Provide file extensions.");
	}
	this.fileExtensions = new HashSet<>(fileExtensions);

	if (StringUtil.isBlank(location)) {
	    throw new IllegalArgumentException("Provide a download location.");
	}
	this.downloadLocation = new File(location);
	if (!this.downloadLocation.exists() && !this.downloadLocation.isDirectory()) {
	    throw new IllegalArgumentException("Provide an existing directory.");
	}

	if (numberOfParsingThreads < 1 || numberOfDownloaderThreads < 1) {
	    throw new IllegalArgumentException("The number of threads must be bigger or equal with 1.");
	}
	this.numberOfDownloaderThreads = numberOfDownloaderThreads;
	this.numberOfParsingThreads = numberOfParsingThreads;

	validateParsingMode(parseImages, parseLinks, parseScripts);
	this.parseImages = parseImages;
	this.parseLinks = parseLinks;
	this.parseScripts = parseScripts;
    }

    private void validateParsingMode(boolean parseImages, boolean parseLinks, boolean parseScripts) {
	boolean result = false;
	if (parseImages) {
	    result = true;
	} else if (parseLinks) {
	    result = true;
	} else if (parseScripts) {
	    result = true;
	}
	if (!result) {
	    throw new IllegalArgumentException("You must parse at least one of the following: images, links or scripts.");
	}
    }

    public Queue<String> getUrlsToBeParsed() {
	return urlsToBeParsed;
    }

    public boolean isParseImages() {
	return parseImages;
    }

    public boolean isParseLinks() {
	return parseLinks;
    }

    public boolean isParseScripts() {
	return parseScripts;
    }

    public BlockingQueue<String> getUrlsToBeDownloaded() {
	return urlsToBeDownloaded;
    }

    public Set<String> getFileExtensions() {
	return fileExtensions;
    }

    public File getDownloadLocation() {
	return downloadLocation;
    }

    public int getNumberOfDownloaderThreads() {
	return numberOfDownloaderThreads;
    }

    public int getNumberOfParsingThreads() {
	return numberOfParsingThreads;
    }

    public void countDown() {
	countDownLatch.countDown();
    }

    public void offerDownloadUrl(String absoluteUrl) {
	for (String extension : getFileExtensions()) {
	    if (absoluteUrl.endsWith(extension)) {
		try {
		    urlsToBeDownloaded.offer(absoluteUrl, WAIT_SECONDS, TimeUnit.SECONDS);
		} catch (InterruptedException ignored) {
		    // Stay silent.
		}
	    }
	}
    }

    public String getUrlForParsing() {
	return urlsToBeParsed.poll();
    }

    public String getUrlForDownloading() throws InterruptedException {
	return urlsToBeDownloaded.poll(WAIT_SECONDS, TimeUnit.SECONDS);
    }
}
