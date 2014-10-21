package com.egoday.feedreader.feed.model;

public final class Link {

	private final String rel;

	private final String type;

	private final String href;

	private final String title;

	public Link(final String rel, final String type, final String href, final String title) {
		this.rel = rel;
		this.type = type;
		this.href = href;
		this.title = title;
	}

	public String getRel() {
		return rel;
	}

	public String getType() {
		return type;
	}

	public String getHref() {
		return href;
	}

	public String getTitle() {
		return title;
	}
}