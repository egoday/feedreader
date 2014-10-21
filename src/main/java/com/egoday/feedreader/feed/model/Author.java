package com.egoday.feedreader.feed.model;

/**
 * atomAuthor = element atom:author { atomPersonConstruct }
 *
 *   atomPersonConstruct =
 *     atomCommonAttributes,
 *     (element atom:name { text }
 *      & element atom:uri { atomUri }?
 *      & element atom:email { atomEmailAddress }?
 *      & extensionElement*)
 */
public final class Author {

	public final String name;
	
	public final String uri;
	
	public final String email;
	
	public final GdImage image;
	
	public Author(final String name, final String uri, final String email, final GdImage image) {
		this.name = name;
		this.uri = uri;
		this.email = email;
		this.image = image;
	}
}