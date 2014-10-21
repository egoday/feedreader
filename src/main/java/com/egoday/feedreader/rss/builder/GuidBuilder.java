package com.egoday.feedreader.rss.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.rss.meta.Guid_;
import com.egoday.feedreader.rss.model.Guid;

public class GuidBuilder {

	public static Guid build(XmlPullParser parser) throws XmlPullParserException, IOException {

		parser.require(XmlPullParser.START_TAG, null, Guid_.parseName);

		Boolean isPermaLink = Boolean.valueOf(parser.getAttributeValue(null, Guid_.isPermaLink));
		String text = parser.nextText();

		while(parser.getEventType() != XmlPullParser.END_TAG) parser.nextTag();
		
		parser.require(XmlPullParser.END_TAG, null, Guid_.parseName);

		return new Guid(isPermaLink, text);
	}

}
