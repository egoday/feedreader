package com.egoday.feedreader.rss.builder;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.rss.meta.Category_;
import com.egoday.feedreader.rss.meta.Guid_;
import com.egoday.feedreader.rss.meta.Item_;
import com.egoday.feedreader.rss.model.Category;
import com.egoday.feedreader.rss.model.Guid;
import com.egoday.feedreader.rss.model.Item;
import com.egoday.feedreader.rss.util.DateParser;

public class ItemBuilder {

	public static Item build(XmlPullParser parser) throws ParseException, XmlPullParserException, IOException {

		parser.require(XmlPullParser.START_TAG, null, Item_.parseName);

		Item item = null;

		String parserText = null;
		String parserName = null;

		String title = null;
		String link = null;
		String description = null;
		List<Category> categories = new ArrayList<Category>();
		Date pubDate = null;
		String comments = null;
		Guid guid = null;

		int eventType = parser.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT && item == null) {
			parserName = parser.getName();

			switch (eventType) {
				case XmlPullParser.START_TAG:
					if (parserName.equals(Category_.parseName)) {
						Category category = CategoryBuilder.build(parser);
						categories.add(category);
					} else if (parserName.equals(Guid_.parseName)) {
						guid = GuidBuilder.build(parser);
					}

					break;
				case XmlPullParser.TEXT:
					parserText = parser.getText();

					break;
				case XmlPullParser.END_TAG:
					if (parserName.equals(Item_.title)) {
						title = parserText;
					} else if (parserName.equals(Item_.link)) {
						link = parserText;
					} else if (parserName.equals(Item_.description)) {
						description = parserText;
					} else if (parserName.equals(Item_.pubDate)) {
						pubDate = DateParser.parse(parserText);
					} else if (parserName.equals(Item_.comments)) {
						comments = parserText;
					} else if (parserName.equals(Item_.parseName)) {
						item = new Item(title, link, description, categories, pubDate, comments, guid);
					}

					parserText = null;

					break;
				default:
			}

			if (item == null)
				eventType = parser.next();
		}

		parser.require(XmlPullParser.END_TAG, null, Item_.parseName);

		return item;
	}
}