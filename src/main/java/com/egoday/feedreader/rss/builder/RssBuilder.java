package com.egoday.feedreader.rss.builder;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.egoday.feedreader.rss.meta.Channel_;
import com.egoday.feedreader.rss.meta.Rss_;
import com.egoday.feedreader.rss.model.Channel;
import com.egoday.feedreader.rss.model.Rss;

public class RssBuilder {

    public static Rss build(XmlPullParser parser)
	    throws XmlPullParserException, IOException, ParseException {

	parser.require(XmlPullParser.START_TAG, null, Rss_.parseName);

	Rss rss = null;

	String parserName = null;

	String version = null;
	List<Channel> channels = new ArrayList<Channel>();

	int eventType = parser.getEventType();

	while (eventType != XmlPullParser.END_DOCUMENT && rss == null) {
	    parserName = parser.getName();

	    switch (eventType) {
		case XmlPullParser.START_TAG:
		    if (parserName.equals(Channel_.parseName)) {
			Channel channel = ChannelBuilder.build(parser);
			channels.add(channel);
		    } else if (parserName.equals(Rss_.parseName)) {
			version = parser.getAttributeValue(null, Rss_.version);
		    }

		    break;
		case XmlPullParser.END_TAG:
		    if (parserName.equals(Rss_.parseName)) {
			rss = new Rss(version, channels);
		    }

		    break;
		default:
	    }

	    if (rss == null)
		eventType = parser.next();
	}

	parser.require(XmlPullParser.END_TAG, null, Rss_.parseName);

	return rss;
    }
}