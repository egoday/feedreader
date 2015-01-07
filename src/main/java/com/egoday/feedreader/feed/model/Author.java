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

	private final String name;
	
	private final String uri;
	
	private final String email;
	
	private final GdImage image;
	
	public Author(final String name, final String uri, final String email, final GdImage image) {
		this.name = name;
		this.uri = uri;
		this.email = email;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public String getUri() {
		return uri;
	}

	public String getEmail() {
		return email;
	}

	public GdImage getImage() {
		return image;
	}
}