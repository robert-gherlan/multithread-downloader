package com.downloader.multithreaddownloader.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ParserUtils {

    /**
     * Parse providing text by splitting by provided separator.
     *
     * @param text      The text which will be spliced by provided separator.
     * @param separator The separator.
     * @return The result after split operation, or null.
     */
    public static Set<String> parse(String text, String separator) {
	if (text != null && !text.trim().isEmpty() && separator != null && !separator.trim().isEmpty()) {
	    String[] splitResult = text.trim().split(separator);
	    if (splitResult != null && splitResult.length > 0) {
		Set<String> result = new HashSet<>();
		for (String split : splitResult) {
		    if (!StringUtil.isBlank(split)) {
			result.add(split.trim());
		    }
		}

		return result;
	    }
	}

	return Collections.emptySet();
    }

    private ParserUtils() {
    }
}
