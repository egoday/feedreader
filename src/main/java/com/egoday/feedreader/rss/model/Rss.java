package com.egoday.feedreader.rss.model;

import java.util.List;

public final class Rss {

	private final String version;
	
	private final List<Channel> channels;
	
	public Rss(final String version, final List<Channel> channels) {
		this.version = version;
		this.channels = channels;
	}

	public String getVersion() {
		return version;
	}

	public List<Channel> getChannels() {
		return channels;
	}
}