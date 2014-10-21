package com.egoday.feedreader.rss.model;

import java.util.Date;
import java.util.List;

public final class Channel {
	
	private final String title;
	private final String link;
	private final String description;
	private final String language;
	private final Date pubDate;
	private final Date lastBuildDate;
	private final Integer ttl;
	private final Image image;
	private final List<Item> items;
	
	public Channel(
			final String title,
			final String link,
			final String description,
			final String language,
			final Date pubDate,
			final Date lastBuildDate,
			final Integer ttl,
			final Image image,
			final List<Item> items) {
		
		this.title = title;
		this.link = link;
		this.description = description;
		this.language = language;
		this.pubDate = pubDate;
		this.lastBuildDate = lastBuildDate;
		this.ttl = ttl;
		this.image = image;
		this.items = items;
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

	public String getLanguage() {
		return language;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	public Integer getTtl() {
		return ttl;
	}

	public Image getImage() {
		return image;
	}

	public List<Item> getItems() {
		return items;
	}
}