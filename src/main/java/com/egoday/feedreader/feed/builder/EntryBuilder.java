package com.egoday.feedreader.feed.builder;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Author_;
import com.egoday.feedreader.feed.meta.Category_;
import com.egoday.feedreader.feed.meta.Entry_;
import com.egoday.feedreader.feed.meta.Link_;
import com.egoday.feedreader.feed.meta.Thumbnail_;
import com.egoday.feedreader.feed.model.Author;
import com.egoday.feedreader.feed.model.Category;
import com.egoday.feedreader.feed.model.Entry;
import com.egoday.feedreader.feed.model.Link;
import com.egoday.feedreader.feed.model.Thumbnail;
import com.egoday.feedreader.feed.util.DateConstruct;

public final class EntryBuilder {

	public static Entry build(XmlPullParser parser) throws XmlPullParserException, IOException, ParseException {
		parser.require(XmlPullParser.START_TAG, null, Entry_.parseName);

		Entry entry = null;

		String parseText = null;
		String parseName = null;

		List<Category> categories = new ArrayList<Category>();
		List<Link> links = new ArrayList<Link>();
		Thumbnail thumbnail = null;
		Author author = null;
		String id = null;
		Date published = null;
		Date updated = null;
		String title = null;
		String content = null;
		String origLink = null;

		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT && entry == null) {
			parseName = parser.getName();

			switch (eventType) {
			case XmlPullParser.START_TAG:
				if (parseName.equals(Category_.parseName)) {
					Category category = CategoryBuilder.build(parser);
					categories.add(category);
				} else if (parseName.equals(Link_.parseName)) {
					Link link = LinkBuilder.build(parser);
					links.add(link);
				} else if (parseName.equals(Thumbnail_.parseName)) {
					thumbnail = ThumbnailBuilder.build(parser);
				} else if (parseName.equals(Author_.parseName)) {
					author = AuthorBuilder.build(parser);
				}

				break;
			case XmlPullParser.TEXT:
				parseText = parser.getText();

				break;
			case XmlPullParser.END_TAG:
				if (parseName.equals(Entry_.id)) {
					id = parseText;
				} else if (parseName.equals(Entry_.published)) {
					published = DateConstruct.toDate(parseText);
				} else if (parseName.equals(Entry_.updated)) {
					updated = DateConstruct.toDate(parseText);
				} else if (parseName.equals(Entry_.title)) {
					title = parseText;
				} else if (parseName.equals(Entry_.content)) {
					content = parseText;
				} else if (parseName.equals(Entry_.origLink)) {
					origLink = parseText;
				} else if (parseName.equals(Entry_.parseName)) {
					entry = new Entry(
							id,
							updated,
							published,
							categories,
							title,
							content,
							origLink,
							links,
							thumbnail,
							author);
				}

				parseText = null;

				break;
			default:
			}

			if (entry == null)
				eventType = parser.next();
		}

		parser.require(XmlPullParser.END_TAG, null, Entry_.parseName);

		return entry;
	}
}