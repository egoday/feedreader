package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Generator_;
import com.egoday.feedreader.feed.model.Generator;

public class GeneratorBuilder {

	public static Generator build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Generator_.parseName);
		
		String uri = parser.getAttributeValue(null, Generator_.uri);
		String version = parser.getAttributeValue(null, Generator_.version);
		String text = parser.nextText();
		
		while (parser.getEventType() != XmlPullParser.END_TAG) parser.nextTag();

		parser.require(XmlPullParser.END_TAG, null, Generator_.parseName);

		return new Generator(uri, version, text);
	}
}