package com.downloader.multithreaddownloader;

import java.io.IOException;

import com.downloader.multithreaddownloader.view.MainViewFrame;

public class MultiThreadDownloader {

    public static void main(String[] args) throws IOException, InterruptedException {
	MainViewFrame mainViewFrame = new MainViewFrame();
	mainViewFrame.setName("MultiThreadDownloader");
	mainViewFrame.setAlwaysOnTop(true);
	mainViewFrame.setVisible(true);
    }
}
