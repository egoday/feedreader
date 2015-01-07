package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Author_;
import com.egoday.feedreader.feed.meta.Logo_;
import com.egoday.feedreader.feed.model.Logo;

public class LogoBuilder {

	public static Logo build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Logo_.parseName);
		
		Logo logo = null;
		
		String parserText = null;
		String parserName = null;

		String uri = null;
		
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT && logo == null) {
			parserName = parser.getName();

			switch (eventType) {
			case XmlPullParser.START_TAG:
				break;
			case XmlPullParser.TEXT:
				parserText = parser.getText();

				break;
			case XmlPullParser.END_TAG:
				if (parserName.equals(Author_.uri)) {
					uri = parserText;
				} else if (parserName.equals(Logo_.parseName)) {
					logo = new Logo(uri);
				}

				parserText = null;

				break;
			default:
			}

			if (logo == null)
				eventType = parser.next();
		}
		
		parser.require(XmlPullParser.END_TAG, null, Logo_.parseName);

		return logo;
	}

}
