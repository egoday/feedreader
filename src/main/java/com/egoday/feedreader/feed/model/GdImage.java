package com.egoday.feedreader.feed.model;

public final class GdImage {

	private final String rel;
	
	private final Integer height;

	private final Integer width;
	
	private final String src;
	
	public GdImage(final String rel, final Integer height, final Integer width, final String src) {
		this.rel = rel;
		this.height = height;
		this.width = width;
		this.src = src;
	}

	public String getRel() {
		return rel;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getWidth() {
		return width;
	}

	public String getSrc() {
		return src;
	}
}