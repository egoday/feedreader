package com.egoday.feedreader.feed.model;

import java.util.Date;
import java.util.List;

public final class Entry {
	
	private final String id;

	private final Date updated;

	private final Date published;

	private final List<Category> categories;

	private final String title;

	private final String content;

	private final String origLink;

	private final List<Link> links;

	private final Thumbnail thumbnail;
	
	private final Author author;
	
	public Entry(
			final String id,
			final Date updated,
			final Date published,
			final List<Category> categories,
			final String title,
			final String content,
			final String origLink,
			final List<Link> links,
			final Thumbnail thumbnail,
			final Author author) {
		
		this.id = id;
		this.updated = updated;
		this.published = published;
		this.categories = categories;
		this.title = title;
		this.content = content;
		this.origLink = origLink;
		this.links = links;
		this.thumbnail = thumbnail;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public Date getUpdated() {
		return updated;
	}

	public Date getPublished() {
		return published;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getOrigLink() {
		return origLink;
	}

	public List<Link> getLinks() {
		return links;
	}

	public Thumbnail getThumbnail() {
		return thumbnail;
	}
	
	public Author getAuthor() {
		return author;
	}
}