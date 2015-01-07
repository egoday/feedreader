package com.egoday.feedreader.feed.model;

/**
 *    atomIcon = element atom:icon {
 *     atomCommonAttributes,
 *     (atomUri)
 */
public class Icon {

	private final String uri;
	
	public Icon(final String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}
}