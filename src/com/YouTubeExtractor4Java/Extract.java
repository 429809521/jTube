// This file is part of YouTubeExtractor4Java.
//
// Copyright (c) 2015 Baidu, Inc. All Rights Reserved.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
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

package com.YouTubeExtractor4Java;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.*;

import com.ccMixterExtractor4Java.Log;

public class Extract
{	
	public static List<FmtStreamMap> Run (String Url) throws IOException
	{
		CharSequence pageContent = Html.getContentfromUrl(Url);
		
		String expr = "ytplayer\\.config\\s*=\\s*([^\\n]+);";
		
		Pattern js = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
		
		Matcher matcher = js.matcher(pageContent);
		
		if (matcher.find())
		{
			JSONObject ytpConf = new JSONObject(matcher.group(1));
			JSONObject args = ytpConf.getJSONObject("args");
			
			String html5playerJS = ytpConf.getJSONObject("assets").getString("js");
            
			if (html5playerJS.startsWith("//")) {
                html5playerJS = "http:" + html5playerJS;
            } else if (html5playerJS.startsWith("/")) {
                html5playerJS = "http://www.youtube.com/" + html5playerJS;
            }
			
			String fmtStream = args.getString("url_encoded_fmt_stream_map");

			String[] fmtArray = fmtStream.split(",");
			
			List<FmtStreamMap> streamMaps = new ArrayList<FmtStreamMap>();
			
			for (String f: fmtArray)
			{
				FmtStreamMap parseStreamMap = parse(f);
				
				parseStreamMap.html5playerJS = html5playerJS;                
				parseStreamMap.videoid = args.optString("video_id");
                parseStreamMap.title = args.optString("title");
                
                if (parseStreamMap.resolution != null) {
                    streamMaps.add(parseStreamMap);}
			}
			
			String adaptiveStream = args.getString("adaptive_fmts");
			
			String[] adaptiveStreamArray = adaptiveStream.split(",");
			
			for (String f: adaptiveStreamArray)
			{
				FmtStreamMap parseStreamMap = parse(f);
				
				parseStreamMap.html5playerJS = html5playerJS;                
				parseStreamMap.videoid = args.optString("video_id");
                parseStreamMap.title = args.optString("title");
                
                if (parseStreamMap.resolution != null) {
                    streamMaps.add(parseStreamMap);}
			}
			
			return streamMaps;
		}
		
		if (Log.getMode())
			Log.println("FmtStreamMap null. Can't find the next subsequence of the input sequence that matches the pattern.");
        
        if (Log.getMode())
			Log.println("********************************");

		return null;
	}
	
	private static FmtStreamMap parse(String f)
	{
		FmtStreamMap streamMap = new FmtStreamMap();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(f);
		
		sc.useDelimiter("&");
		
		while(sc.hasNext())
		{
			final String[] value = sc.next().split("=");
			
			final String name = decode(value[0], "utf-8");
			
			String v = null;
            
			if (value.length == 2) {
                v = decode(value[1], "utf-8"); }
			
			if (TextUtils.equals("fallback_host", name)) {
                streamMap.fallbackHost = v;
            }
            
			if (TextUtils.equals("s", name)) {
                streamMap.s = v;
            }
            
            if (TextUtils.equals("itag", name)) {
                streamMap.itag = v;
            }
            
            if (TextUtils.equals("type", name)) {
                streamMap.type = v;
            }
            
            if (TextUtils.equals("quality", name)) {
                streamMap.quality = v;
            }
            
            if (TextUtils.equals("url", name)) {
                streamMap.url = v;
            }
            
            if (TextUtils.equals("sig", name)) {
                streamMap.sig = v;
            }
            
            if (TextUtils.equals("signature", name)) {

            }
            
            if (!TextUtils.isEmpty(streamMap.itag)) {
                streamMap.resolution = VideoInfo.Resolutions.get(streamMap.itag);
            }
            
            if (streamMap.resolution != null) {
                streamMap.extension = streamMap.resolution.format;
            }
        }
		
		return streamMap;
	}
	
	private static String decode(final String content, final String encoding) {
        try {
            return URLDecoder.decode(content, encoding);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
	
	public static String parseUrl(FmtStreamMap fmtStreamMap) throws UnsupportedEncodingException, IOException
	{
		@SuppressWarnings("unused")
		String downloadUrl = null;
        
		if (!TextUtils.isEmpty(fmtStreamMap.sig)) {
            String sig = fmtStreamMap.sig;
            return downloadUrl = String.format("%s&signature=%s", fmtStreamMap.url, sig);
        } else {
            String jsContent = Html.getContentfromUrlasString(fmtStreamMap.html5playerJS);
            return downloadUrl = (Decipherer.decipher(jsContent, fmtStreamMap));
        }
	}
}