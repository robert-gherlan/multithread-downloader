package com.downloader.multithreaddownloader.parser;

import com.downloader.multithreaddownloader.downloader.config.DownloaderConfig;
import com.downloader.multithreaddownloader.utils.StringUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserThread extends Thread {

    private final DownloaderConfig downloaderConfig;

    public ParserThread(DownloaderConfig downloaderConfig) {
	this.downloaderConfig = downloaderConfig;
    }

    @Override
    public void run() {
	String url;
	while ((url = downloaderConfig.getUrlForParsing()) != null) {
	    try {
		System.out.println(getId() + " started to parse: " + url);
		Document htmlDocument = Jsoup.connect(url).get();
		if (downloaderConfig.isParseLinks()) {
		    addUrlToBeDownloaded(htmlDocument, "a", "href");
		}
		if (downloaderConfig.isParseImages()) {
		    addUrlToBeDownloaded(htmlDocument, "img", "src");
		}
		if (downloaderConfig.isParseScripts()) {
		    addUrlToBeDownloaded(htmlDocument, "script", "src");
		}
		System.out.println(getId() + " finished to parse: " + url);
	    } catch (Exception e) {
		System.err.println("Failed to parse: " + url + " : " + e.getMessage());
	    }
	}
    }

    private void addUrlToBeDownloaded(Document htmlDocument, String tagName, String attributeName) {
	Elements foundLinksElements = htmlDocument.select(tagName);
	for (Element htmlTag : foundLinksElements) {
	    String absoluteUrl = htmlTag.absUrl(attributeName);
	    if (!StringUtil.isBlank(absoluteUrl)) {
		downloaderConfig.offerDownloadUrl(absoluteUrl);
	    }
	}
    }
}
