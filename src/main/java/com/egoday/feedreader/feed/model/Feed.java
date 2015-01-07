package com.egoday.feedreader.feed.model;

import java.util.Date;
import java.util.List;

/**
 *   # atom:feed
 *
 *  atomFeed =
 *     [
 *        s:rule [
 *           context = "atom:feed"
 *           s:assert [
 *              test = "atom:author or not(atom:entry[not(atom:author)])"
 *              "An atom:feed must have an atom:author unless all "
 *              ~ "of its atom:entry children have an atom:author."
 *           ]
 *        ]
 *     ]
 *     element atom:feed {
 *        atomCommonAttributes,
 *        (atomAuthor*
 *         & atomCategory*
 *         & atomContributor*
 *         & atomGenerator?
 *         & atomIcon?
 *         & atomId
 *         & atomLink*
 *         & atomLogo?
 *         & atomRights?
 *         & atomSubtitle?
 *         & atomTitle
 *         & atomUpdated
 *         & extensionElement*),
 *        atomEntry*
 *     }
 */
public final class Feed {
	
	private final List<Author> authors;

	private final List<Category> categories;
	
	private final List<Contributor> contributors;
	
	private final Generator generator;
	
	private final Icon icon;

	private final String id;
	
	private final List<Link> links;
	
	private final Logo logo;

	private final Date updated;

	private final String title;

	private final String subtitle;

	private final List<Entry> entries;
	
	public Feed(
			final List<Author> authors,
			final List<Category> categories,
			final List<Contributor> contributors,
			final Generator generator,
			final Icon icon,
			final String id,
			final List<Link> links,
			final Logo logo,
			final Date updated,
			final String title,
			final String subtitle,
			final List<Entry> entries) {
		
		this.authors = authors;
		this.categories = categories;
		this.contributors = contributors;
		this.generator = generator;
		this.icon = icon;
		this.id = id;
		this.links = links;
		this.logo = logo;
		this.updated = updated;
		this.title = title;
		this.subtitle = subtitle;
		this.entries = entries;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Contributor> getContributors() {
		return contributors;
	}
	
	public Generator getGenerator() {
		return generator;
	}
	
	public Icon getIcon() {
		return icon;
	}

	public String getId() {
		return id;
	}
	
	public List<Link> getLinks() {
		return links;
	}
	
	public Logo getLogo() {
		return logo;
	}

	public Date getUpdated() {
		return updated;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public List<Entry> getEntries() {
		return entries;
	}
}