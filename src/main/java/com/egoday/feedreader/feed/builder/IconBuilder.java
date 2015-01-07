package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Icon_;
import com.egoday.feedreader.feed.model.Icon;

public class IconBuilder {

	public static Icon build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Icon_.parseName);
		
		String uri = parser.getAttributeValue(null, Icon_.uri);

		parser.require(XmlPullParser.END_TAG, null, Icon_.parseName);

		return new Icon(uri);
	}
}