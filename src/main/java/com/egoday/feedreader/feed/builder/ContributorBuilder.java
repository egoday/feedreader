package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Author_;
import com.egoday.feedreader.feed.meta.Contributor_;
import com.egoday.feedreader.feed.meta.GdImage_;
import com.egoday.feedreader.feed.model.Contributor;
import com.egoday.feedreader.feed.model.GdImage;

public class ContributorBuilder {

	public static Contributor build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Contributor_.parseName);
		
		Contributor contributor = null;
		
		String parserText = null;
		String parserName = null;

		String name = null;
		String uri = null;
		String email = null;
		GdImage gdImage = null;
		
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT && contributor == null) {
			parserName = parser.getName();

			switch (eventType) {
			case XmlPullParser.START_TAG:
				if (parserName.equals(GdImage_.parseName)) {
					gdImage = ImageBuider.build(parser);
				}

				break;
			case XmlPullParser.TEXT:
				parserText = parser.getText();

				break;
			case XmlPullParser.END_TAG:
				if (parserName.equals(Author_.name)) {
					name = parserText;
				} else if (parserName.equals(Author_.uri)) {
					uri = parserText;
				} else if (parserName.equals(Author_.email)) {
					email = parserText;
				} else if (parserName.equals(Author_.parseName)) {
					contributor = new Contributor(name, uri, email, gdImage);
				}

				parserText = null;

				break;
			default:
			}

			if (contributor == null)
				eventType = parser.next();
		}
		
		parser.require(XmlPullParser.END_TAG, null, Contributor_.parseName);

		return contributor;
	}
}