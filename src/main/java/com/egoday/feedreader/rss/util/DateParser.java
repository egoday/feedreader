package com.egoday.feedreader.rss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    public static final String DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss Z";

    public static final Locale LOCALE = Locale.ENGLISH;

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(
	    DATE_PATTERN, LOCALE);

    public static Date parse(String value) throws ParseException {
	return dateFormat.parse(value);
    }
}
