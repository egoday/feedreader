package com.egoday.feedreader;

import java.io.InputStream;

import com.egoday.feedreader.rss.model.Rss;
import com.egoday.feedreader.rss.reader.RssReader;

public class RssApp {

	public static final String RSS_SPEC = "/rss.xml";

	public static void main(String... args) throws Exception {
		InputStream inputStream = RssApp.class.getResourceAsStream(RSS_SPEC);

		Rss rss = RssReader.read(inputStream);
		System.out.println(rss);
	}
}