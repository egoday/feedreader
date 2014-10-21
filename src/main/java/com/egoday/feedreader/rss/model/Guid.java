package com.egoday.feedreader.rss.model;

public class Guid {

	private final Boolean isPermaLink;
	
	private final String text;
	
	public Guid(final Boolean isPermaLink, final String text) {
		this.isPermaLink = isPermaLink;
		this.text = text;
	}

	public Boolean getIsPermaLink() {
		return isPermaLink;
	}

	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
