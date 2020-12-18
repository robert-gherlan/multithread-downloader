package com.downloader.multithreaddownloader.utils;

public class StringUtil {

    public static boolean isBlank(String string) {
	if (string == null || string.isEmpty()) {
	    return true;
	}

	int l = string.length();
	for (int i = 0; i < l; i++) {
	    if (!Character.isWhitespace(string.codePointAt(i)))
		return false;
	}
	return true;
    }

    private StringUtil() {
    }
}
