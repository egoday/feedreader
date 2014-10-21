package com.egoday.feedreader.rss.model;

public final class Image {

	private final String title;
	
	private final String url;

	private final String link;
	
	public Image(final String title, final String url, final String link) {
		this.title = title;
		this.url = url;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getLink() {
		return link;
	}
}