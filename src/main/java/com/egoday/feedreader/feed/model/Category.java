package com.egoday.feedreader.feed.model;

/**
 *    atomCategory =
 *     element atom:category {
 *        atomCommonAttributes,
 *        attribute term { text },
 *        attribute scheme { atomUri }?,
 *        attribute label { text }?,
 *        undefinedContent
 *     }
 */
public final class Category {
	
	private final String term;
	
	private final String scheme;
	
	private final String label;
	
	public Category(
			final String term,
			final String scheme,
			final String label) {

		this.term = term;
		this.scheme = scheme;
		this.label = label;
	}
	
	public String getTerm() {
		return term;
	}
	
	public String getScheme() {
		return scheme;
	}
	
	public String getLabel() {
		return label;
	}
}