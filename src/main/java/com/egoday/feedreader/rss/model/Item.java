package com.egoday.feedreader.rss.model;

import java.util.Date;
import java.util.List;

public final class Item {
	
	private final String title;
	
	private final String link;
	
	private final String description;
	
	private final List<Category> categories;
	
	private final Date pubDate;
	
	private final String comments;
	
	private final Guid guid;
	
	public Item(
			final String title,
			final String link,
			final String description,
			final List<Category> categories,
			final Date pubDate,
			final String comments,
			final Guid guid) {
		
		this.title = title;
		this.link = link;
		this.description = description;
		this.categories = categories;
		this.pubDate = pubDate;
		this.comments = comments;
		this.guid = guid;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public String getComments() {
		return comments;
	}

	public Guid getGuid() {
		return guid;
	}
}