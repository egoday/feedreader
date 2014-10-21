package com.egoday.feedreader.feed.builder;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.feed.meta.GdImage_;
import com.egoday.feedreader.feed.model.GdImage;

public class ImageBuider {

	public static GdImage build(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, null, GdImage_.parseName);
		
		String rel = parser.getAttributeValue(null, GdImage_.rel);
		Integer height = Integer.valueOf(parser.getAttributeValue(null, GdImage_.height));
		Integer width = Integer.valueOf(parser.getAttributeValue(null, GdImage_.width));
		String src = parser.getAttributeValue(null, GdImage_.src);
		
		parser.nextTag();
		
		parser.require(XmlPullParser.END_TAG, null, GdImage_.parseName);

		return new GdImage(rel, height, width, src);
	}
}