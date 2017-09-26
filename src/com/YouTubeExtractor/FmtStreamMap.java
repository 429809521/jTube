// This file is part of YouTubeExtractor4Java.
//
// Copyright (c) 2015 Baidu, Inc. All Rights Reserved.
//
// YouTubeExtractor4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// YouTubeExtractor4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with YouTubeExtractor4Java. If not, see<http://www.gnu.org/licenses/>.

package com.YouTubeExtractor;


public class FmtStreamMap {
	public String fallbackHost;

	public String s;
	public String itag;
	public String type;
	/**
	 * 
	 */
	public String quality;

	public String url;

	public String sig;

	public String title;

	public String mediatype;

	public boolean encrypted;

	public String extension;

	public Resolution resolution;

	public String html5playerJS;

	public CharSequence videoid;

	public String realUrl;

	@Override
	public String toString() {
		return "FmtStreamMap [fallbackHost=" + fallbackHost + ", s=" + s + ", itag=" + itag + ", type=" + type + ", quality=" + quality
				+ ", url=" + url + ", sig=" + sig + ", title=" + title + ", mediatype=" + mediatype + ", encrypted=" + encrypted
				+ ", extension=" + extension + ", resolution=" + resolution + ", html5playerJS=" + html5playerJS + ", videoid=" + videoid
				+ "]";
	}

	public String getStreamString() {
		if (resolution != null) {
			return String.format("%s (%s)", extension, resolution.resolution);
		} else {
			return null;
		}
	}
}