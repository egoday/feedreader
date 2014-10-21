package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Category_;
import com.egoday.feedreader.feed.model.Category;

public final class CategoryBuilder {

	public static Category build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Category_.parseName);
		
		String term = parser.getAttributeValue(null, Category_.term);
		String scheme = parser.getAttributeValue(null, Category_.scheme);
		String label = parser.getAttributeValue(null, Category_.label);
		
		parser.nextTag();

		parser.require(XmlPullParser.END_TAG, null, Category_.parseName);

		return new Category(term, scheme, label);
	}
}