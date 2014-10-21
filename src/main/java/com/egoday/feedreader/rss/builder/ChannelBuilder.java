package com.egoday.feedreader.rss.builder;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.rss.meta.Channel_;
import com.egoday.feedreader.rss.meta.Image_;
import com.egoday.feedreader.rss.meta.Item_;
import com.egoday.feedreader.rss.model.Channel;
import com.egoday.feedreader.rss.model.Image;
import com.egoday.feedreader.rss.model.Item;
import com.egoday.feedreader.rss.util.DateParser;
import com.egoday.feedreader.util.IntegerParser;

public class ChannelBuilder {

	public static Channel build(XmlPullParser parser)
			throws XmlPullParserException, IOException, ParseException {

		parser.require(XmlPullParser.START_TAG, null, Channel_.parseName);

		Channel channel = null;

		String parserText = null;
		String parserName = null;

		String title = null;
		String link = null;
		String description = null;
		String language = null;
		Date pubDate = null;
		Date lastBuildDate = null;
		Integer ttl = null;
		Image image = null;
		List<Item> items = new ArrayList<Item>();

		int eventType = parser.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT && channel == null) {
			parserName = parser.getName();

			switch (eventType) {
			case XmlPullParser.START_TAG:
				if (parserName.equals(Item_.parseName)) {
					Item item = ItemBuilder.build(parser);
					items.add(item);
				} else if (parserName.equals(Image_.parseName)) {
					image = ImageBuilder.build(parser);
				}

				break;
			case XmlPullParser.TEXT:
				parserText = parser.getText();

				break;
			case XmlPullParser.END_TAG:
				if (parserName.equals(Channel_.title)) {
					title = parserText;
				} else if (parserName.equals(Channel_.link)) {
					link = parserText;
				} else if (parserName.equals(Channel_.description)) {
					description = parserText;
				} else if (parserName.equals(Channel_.language)) {
					language = parserText;
				} else if (parserName.equals(Channel_.pubDate)) {
					pubDate = DateParser.parse(parserText);
				} else if (parserName.equals(Channel_.lastBuildDate)) {
					lastBuildDate = DateParser.parse(parserText);
				} else if (parserName.equals(Channel_.ttl)) {
					ttl = IntegerParser.parse(parserText);
				} else if (parserName.equals(Channel_.parseName)) {
					channel = new Channel(title, link, description, language,
							pubDate, lastBuildDate, ttl, image, items);
				}

				parserText = null;

				break;
			default:
			}

			if (channel == null)
				eventType = parser.next();
		}

		parser.require(XmlPullParser.END_TAG, null, Channel_.parseName);

		return channel;
	}
}
