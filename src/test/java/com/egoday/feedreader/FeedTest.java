package com.egoday.feedreader;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.model.Feed;
import com.egoday.feedreader.feed.reader.FeedReader;

public class FeedTest {
	
	private static final String FEED1 = "/atom/atom1.xml";

	private static final String FEED2 = "/atom/atom2.xml";

	private static final String FEED3 = "/atom/atom3.xml";

	@Test
	public void testFeed1() throws XmlPullParserException, IOException, ParseException {
		InputStream inputStream = FeedTest.class.getResourceAsStream(FEED1);
		Feed feed = FeedReader.read(inputStream);
		
		assertNotNull(feed);
	}

	@Test
	public void testFeed2() throws XmlPullParserException, IOException, ParseException {
		InputStream inputStream = FeedTest.class.getResourceAsStream(FEED2);
		Feed feed = FeedReader.read(inputStream);
		
		assertNotNull(feed);
	}

	@Test
	public void testFeed3() throws XmlPullParserException, IOException, ParseException {
		InputStream inputStream = FeedTest.class.getResourceAsStream(FEED3);
		Feed feed = FeedReader.read(inputStream);
		
		assertNotNull(feed);
	}
}
