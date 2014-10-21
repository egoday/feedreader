package com.egoday.feedreader.feed.util;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;

/**
 *   Example Date constructs:
 *
 *  <updated>2003-12-13T18:30:02Z</updated>
 *  <updated>2003-12-13T18:30:02.25Z</updated>
 *  <updated>2003-12-13T18:30:02+01:00</updated>
 *  <updated>2003-12-13T18:30:02.25+01:00</updated>
 *
 *  Date values SHOULD be as accurate as possible.  For example, it would
 *  be generally inappropriate for a publishing system to apply the same
 *  timestamp to several entries that were published during the course of
 *  a single day.
 *
 */
public class DateConstruct {

    public static Date toDate(String value) throws ParseException {
    	return new DateTime(value).toDate();
    }
}
