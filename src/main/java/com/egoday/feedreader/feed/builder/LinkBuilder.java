package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Link_;
import com.egoday.feedreader.feed.model.Link;

public final class LinkBuilder {

	public static Link build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Link_.parseName);
		
		String href = parser.getAttributeValue(null, Link_.href);
		String rel = parser.getAttributeValue(null, Link_.rel);
		String type = parser.getAttributeValue(null, Link_.type);
		String hreflang = parser.getAttributeValue(null, Link_.hreflang);
		String title = parser.getAttributeValue(null, Link_.title);
		String length = parser.getAttributeValue(null, Link_.length);
		
		parser.nextTag();
		
		parser.require(XmlPullParser.END_TAG, null, Link_.parseName);

		return new Link(href, rel, type, hreflang, title, length);
	}
}
