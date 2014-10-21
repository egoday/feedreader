package com.egoday.feedreader.rss.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.rss.meta.Category_;
import com.egoday.feedreader.rss.model.Category;

public class CategoryBuilder {

	public static Category build(XmlPullParser parser) throws XmlPullParserException, IOException {

		parser.require(XmlPullParser.START_TAG, null, Category_.parseName);

		String domain = parser.getAttributeValue(null, Category_.domain);
		String text = parser.nextText();
		
		while (parser.getEventType() != XmlPullParser.END_TAG) parser.nextTag();

		parser.require(XmlPullParser.END_TAG, null, Category_.parseName);

		return new Category(domain, text);
	}
}