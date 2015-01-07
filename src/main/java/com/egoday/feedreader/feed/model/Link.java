package com.egoday.feedreader.feed.model;

/**
 *    atomLink =
 *      element atom:link {
 *        atomCommonAttributes,
 *        attribute href { atomUri },
 *        attribute rel { atomNCName | atomUri }?,
 *        attribute type { atomMediaType }?,
 *        attribute hreflang { atomLanguageTag }?,
 *        attribute title { text }?,
 *        attribute length { text }?,
 *        undefinedContent
 *     }
 */
public final class Link {

	private final String href;

	private final String rel;

	private final String type;

	private final String hreflang;

	private final String title;

	private final String length;

	public Link(
			final String href,
			final String rel,
			final String type,
			final String hreflang,
			final String title,
			final String length) {
		this.href = href;
		this.rel = rel;
		this.type = type;
		this.hreflang = hreflang;
		this.title = title;
		this.length = length;
	}

	public String getHref() {
		return href;
	}

	public String getRel() {
		return rel;
	}

	public String getType() {
		return type;
	}

	public String getHrefLang() {
		return hreflang;
	}

	public String getTitle() {
		return title;
	}

	public String getLenght() {
		return length;
	}
}