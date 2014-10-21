package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Link_;
import com.egoday.feedreader.feed.model.Link;

public final class LinkBuilder {

	public static Link build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Link_.parseName);
		
		String rel = parser.getAttributeValue(null, Link_.rel);
		String type = parser.getAttributeValue(null, Link_.type);
		String href = parser.getAttributeValue(null, Link_.href);
		String title = parser.getAttributeValue(null, Link_.title);
		
		parser.nextTag();
		
		parser.require(XmlPullParser.END_TAG, null, Link_.parseName);

		return new Link(rel, type, href, title);
	}
}
