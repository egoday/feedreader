package com.egoday.feedreader.feed.model;

public final class Thumbnail {
	
	public final String url;

	public final String height;

	public final String width;
	
	public Thumbnail(final String url, final String height, final String width) {
		this.url = url;
		this.height = height;
		this.width = width;
	}

	public String getUrl() {
		return url;
	}

	public String getHeight() {
		return height;
	}

	public String getWidth() {
		return width;
	}
}