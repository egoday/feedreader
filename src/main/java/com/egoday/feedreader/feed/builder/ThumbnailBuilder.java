package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.Thumbnail_;
import com.egoday.feedreader.feed.model.Thumbnail;

public final class ThumbnailBuilder {

	public static Thumbnail build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, Thumbnail_.parseName);
		
		String url = parser.getAttributeValue(null, Thumbnail_.url);
		String height = parser.getAttributeValue(null, Thumbnail_.height);
		String width = parser.getAttributeValue(null, Thumbnail_.width);
		
		parser.nextTag();
		
		parser.require(XmlPullParser.END_TAG, null, Thumbnail_.parseName);

		return new Thumbnail(url, height, width);
	}
}
