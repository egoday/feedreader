package com.egoday.feedreader.feed.model;

/**
 * atomContributor = element atom:contributor { atomPersonConstruct }
 * 
 *   atomPersonConstruct =
 *     atomCommonAttributes,
 *     (element atom:name { text }
 *      & element atom:uri { atomUri }?
 *      & element atom:email { atomEmailAddress }?
 *      & extensionElement*)
 */
public final class Contributor {

	public final String name;
	
	public final String uri;
	
	public final String email;
	
	public final GdImage image;
	
	public Contributor(final String name, final String uri, final String email, final GdImage image) {
		this.name = name;
		this.uri = uri;
		this.email = email;
		this.image = image;
	}
}