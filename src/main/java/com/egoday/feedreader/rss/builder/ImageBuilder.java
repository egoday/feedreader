package com.egoday.feedreader.rss.builder;

import java.io.IOException;
import java.text.ParseException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.rss.meta.Image_;
import com.egoday.feedreader.rss.model.Image;

public class ImageBuilder {

	public static Image build(XmlPullParser parser)
			throws XmlPullParserException, IOException, ParseException {

		parser.require(XmlPullParser.START_TAG, null, Image_.parseName);

		Image image = null;

		String parserName = null;
		String parserText = null;

		String title = null;
		String url = null;
		String link = null;

		int eventType = parser.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT && image == null) {
			parserName = parser.getName();

			switch (eventType) {
			case XmlPullParser.TEXT:
				parserText = parser.getText();
				break;
			case XmlPullParser.END_TAG:
				if (parserName.equals(Image_.title)) {
					title = parserText;
				} else if (parserName.equals(Image_.url)) {
					url = parserText;
				} else if (parserName.equals(Image_.link)) {
					link = parserText;
				} else if (parserName.equals(Image_.parseName)) {
					image = new Image(title, url, link);
				}

				parserText = null;

				break;
			default:
			}

			if (image == null)
				eventType = parser.next();
		}

		parser.require(XmlPullParser.END_TAG, null, Image_.parseName);

		return image;
	}
}
