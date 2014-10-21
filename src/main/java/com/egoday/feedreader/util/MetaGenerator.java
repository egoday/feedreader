package com.egoday.feedreader.util;

import static java.lang.String.format;
import static java.lang.System.out;

import java.lang.reflect.Field;

import com.egoday.feedreader.feed.model.Feed;
import com.egoday.feedreader.rss.model.Guid;

@SuppressWarnings("unused")
public class MetaGenerator {

	public static final String PATTERN = "public static final String %s = \"%s\";";

	public static final String PARSE_NAME = "parseName";

	public static void main(String... args) {
		Class<?> objectClass = Feed.class;
		
		String simpleName = objectClass.getSimpleName();
		String head = "" + simpleName.charAt(0);
		String tail = simpleName.substring(1);
		String camelCase = head.toLowerCase() + tail;
		
		String parseName = format(PATTERN, PARSE_NAME, camelCase);
		
		out.println(parseName);
		out.println();

		for (Field field : objectClass.getDeclaredFields()) {
			String name = field.getName();
			String line = format(PATTERN, name, name);
			out.println(line);
		}
	}
}