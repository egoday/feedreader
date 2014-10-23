package com.egoday.feedreader.feed.model;

/**
 *    atomGenerator =
 *    	element atom:generator {
 *        atomCommonAttributes,
 *        attribute uri { atomUri }?,
 *        attribute version { text }?,
 *        text
 *    	}
 */
public class Generator {

	private final String uri;
	
	private final String version;
	
	private final String text;
	
	public Generator(
			final String uri,
			final String version,
			final String text) {
		
		this.uri = uri;
		this.version = version;
		this.text = text;
	}
	
	public String getUri() {
		return uri;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String getText() {
		return text;
	}
}