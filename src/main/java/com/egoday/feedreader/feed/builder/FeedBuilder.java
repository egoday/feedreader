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
import com.egoday.feedreader.feed.meta.Contributor_;
import com.egoday.feedreader.feed.meta.Entry_;
import com.egoday.feedreader.feed.meta.Feed_;
import com.egoday.feedreader.feed.model.Author;
import com.egoday.feedreader.feed.model.Category;
import com.egoday.feedreader.feed.model.Contributor;
import com.egoday.feedreader.feed.model.Entry;
import com.egoday.feedreader.feed.model.Feed;
import com.egoday.feedreader.feed.util.DateConstruct;

public class FeedBuilder {

	public static Feed build(XmlPullParser parser)
			throws XmlPullParserException, IOException, ParseException {

		parser.require(XmlPullParser.START_TAG, null, Feed_.parseName);

		Feed feed = null;

		String parseName = null;
		String parseText = null;

		List<Author> authors = new ArrayList<>();
		List<Category> categories = new ArrayList<>();
		List<Contributor> contributors = new ArrayList<>();
		String id = null;
		Date updated = null;
		List<Entry> entries = new ArrayList<>();
		String title = null;
		String subtitle = null;

		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT && feed == null) {
			parseName = parser.getName();

			switch (eventType) {
				case XmlPullParser.START_TAG:
					if (parseName.equals(Author_.parseName)) {
						Author author = AuthorBuilder.build(parser);
						authors.add(author);
					} else if (parseName.equals(Category_.parseName)) {
						Category category = CategoryBuilder.build(parser);
						categories.add(category);
					} else if (parseName.equals(Entry_.parseName)) {
						Entry entry = EntryBuilder.build(parser);
						entries.add(entry);
					} else if (parseName.equals(Contributor_.parseName)) {
						Contributor contributor = ContributorBuilder.build(parser);
						contributors.add(contributor);
					}

					break;
				case XmlPullParser.TEXT:
					parseText = parser.getText();

					break;
				case XmlPullParser.END_TAG:
					if (parseName.equals(Feed_.id)) {
						id = parseText;
					} else if (parseName.equals(Feed_.updated)) {
						updated = DateConstruct.toDate(parseText);
					} else if (parseName.equals(Feed_.title)) {
						title = parseText;
					} else if (parseName.equals(Feed_.subtitle)) {
						subtitle = parseText;
					} else if (parseName.equals(Feed_.parseName)) {
						feed = new Feed(authors, categories, contributors, id, updated, title, subtitle,
								entries);
					}

					parseText = null;

					break;
				default:
			}

			if (feed == null)
				eventType = parser.next();
		}

		parser.require(XmlPullParser.END_TAG, null, Feed_.parseName);

		return feed;
	}
}
