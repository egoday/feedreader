package com.egoday.feedreader.feed.reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.egoday.feedreader.feed.builder.FeedBuilder;
import com.egoday.feedreader.feed.model.Feed;

public final class FeedReader {

	public static Feed read(String spec) throws XmlPullParserException, IOException, ParseException {
		URL url = new URL(spec);
		URLConnection conn = url.openConnection();
		InputStream inputStream = conn.getInputStream();

		return read(inputStream);
	}

	public static Feed read(InputStream inputStream) throws XmlPullParserException, IOException, ParseException {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser = factory.newPullParser();
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);

		parser.setInput(inputStream, null);
		parser.nextTag();

		return FeedBuilder.build(parser);
	}
}