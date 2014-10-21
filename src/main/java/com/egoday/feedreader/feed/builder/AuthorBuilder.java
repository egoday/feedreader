package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Author_;
import com.egoday.feedreader.feed.meta.GdImage_;
import com.egoday.feedreader.feed.model.Author;
import com.egoday.feedreader.feed.model.GdImage;

public final class AuthorBuilder {

	public static Author build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Author_.parseName);
		
		Author author = null;
		
		String parserText = null;
		String parserName = null;

		String name = null;
		String uri = null;
		String email = null;
		GdImage gdImage = null;
		
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT && author == null) {
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
					author = new Author(name, uri, email, gdImage);
				}

				parserText = null;

				break;
			default:
			}

			if (author == null)
				eventType = parser.next();
		}
		
		parser.require(XmlPullParser.END_TAG, null, Author_.parseName);

		return author;
	}
}