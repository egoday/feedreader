package com.egoday.feedreader.feed.model;

/**
 *    atomLogo = element atom:logo {
 *      atomCommonAttributes,
 *     (atomUri)
 *  }
 */
public final class Logo {
	
	private final String uri;
	
	public Logo(final String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}

}
