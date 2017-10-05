// This file is part of xHamsterExtractor.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// xHamsterExtractor is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// xHamsterExtractor is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with xHamsterExtractor. If not, see<http://www.gnu.org/licenses/>.

package com.xHamsterExtractor4Java;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search
{
	static String title;
	static String format;
	static String resolution;
	static String url;

	public static void Query (List<Components> Items, String Url) throws IOException
	{
		url = "";
		
		if (!Url.contains("xhamster"))
			return;
		
		CharSequence sb = Html.getContentfromUrl(Url);
		
		String expr = "players:.*?}\"}},";
		Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
		
		Matcher match = patt.matcher(sb);
		
		while (match.find()) {				
			if (!match.group().contains("</script>"))
			{
				if (Log.getMode())
					Log.println("Match: " + match.group());
				
				title = Helper.ExtractValue(match.group(), "\"title\":\"", "\",\"");
				
				/* FLV */
				
				if (Log.getMode())
					Log.println("Title: " + title);
				
				format = "flv";
				
				if (Log.getMode())
					Log.println("Format: " + format);
				
				resolution = "";
				
				if (Log.getMode())
					Log.println("Resolution: " + resolution);
				
				url = Helper.ExtractValue(match.group(), "\"file\":\"", "\",\"").replace("\\","");
				
				if (Log.getMode())
					Log.println("Url: " + url);
				
				Components comp = new Components(title, format, resolution, url);
        		
        		Items.add(comp);
        		
        		/* MP4 */
        		
        		String expr_ = "sources:.*?},";
        		Pattern patt_ = Pattern.compile(expr_, Pattern.DOTALL | Pattern.UNIX_LINES);
        		
        		Matcher match_ = patt_.matcher(sb);
        		
        		while (match_.find()) {
        			if (Log.getMode())
    					Log.println("Match: " + match_.group());
        			
        			/* 240p */
        			
        			if (Log.getMode())
    					Log.println("Title: " + title);
        			
        			format = "mp4";
    				
    				if (Log.getMode())
    					Log.println("Format: " + format);
    				
    				resolution = "240p";
    				
    				if (Log.getMode())
    					Log.println("Resolution: " + resolution);
    				
    				url = Helper.ExtractValue(match_.group(), "\"240p\":\"", "\",").replace("\\","");
    				
    				if (Log.getMode())
    					Log.println("Url: " + url);
    				
    				comp = new Components(title, format, resolution, url);
            		
            		Items.add(comp);
        			
        			/* 480p */
            		
            		if (Log.getMode())
    					Log.println("Title: " + title);
        			
        			format = "mp4";
    				
    				if (Log.getMode())
    					Log.println("Format: " + format);
    				
    				resolution = "480p";
    				
    				if (Log.getMode())
    					Log.println("Resolution: " + resolution);
    				
    				url = Helper.ExtractValue(match_.group(), "\"480p\":\"", "\"").replace("\\","");
    				
    				if (Log.getMode())
    					Log.println("Url: " + url);
    				
    				comp = new Components(title, format, resolution, url);
            		
            		Items.add(comp);
        			
        			/* 720p */
            		
            		if (Log.getMode())
    					Log.println("Title: " + title);
        			
        			format = "mp4";
    				
    				if (Log.getMode())
    					Log.println("Format: " + format);
    				
    				resolution = "720p";
    				
    				if (Log.getMode())
    					Log.println("Resolution: " + resolution);
    				
    				url = Helper.ExtractValue(match_.group(), "\"720p\":\"", "\"}").replace("\\","");
    				
    				if (Log.getMode())
    					Log.println("Url: " + url);
    				
    				comp = new Components(title, format, resolution, url);
            		
            		Items.add(comp);
        		}
			}
		}
	}
}