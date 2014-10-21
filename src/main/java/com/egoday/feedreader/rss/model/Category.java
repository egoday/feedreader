package com.egoday.feedreader.rss.model;

public class Category {

	private final String domain;
	
	private final String text;
	
	public Category(final String domain, final String text) {
		this.domain = domain;
		this.text = text;
	}

	public String getDomain() {
		return domain;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return text;
	}
}