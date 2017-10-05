// This file is part of VimeoSearch4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// VimeoSearch4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// VimeoSearch4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with VimeoSearch4Java. If not, see<http://www.gnu.org/licenses/>.

package com.VimeoSearch4Java;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search
{
	static String title;
	static String author;
	static String duration;
	static String url;
	static String thumbnail;

	public static void Query (List<Components> Items, String QueryString, Integer QueryPages) throws IOException
	{
		for (int i = 1; i <= QueryPages; i++)
		{
			CharSequence sb = Html.getContentfromUrl("https://www.vimeo.com/search/page:" + i + "?q="+ QueryString.replace(" ", "+"));
			
			String expr = "\"uri\":.*?clip\",\"clip";
			
			Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
			
			Matcher match = patt.matcher(sb);
			
			while (match.find()) {				
				if (Log.getMode())
					Log.println("Match: " + match.group());
				
				title = Helper.ExtractValue(match.group(), "\"name\":\"", "\",\"link\"");
				
				if (Log.getMode())
					Log.println("Title : " + title);
				
				author = Helper.ExtractValue(match.group(), "\"user\":{\"name\":\"", "\",\"link\":");
				
				if (Log.getMode())
					Log.println("Author : " + author);
				
				duration = Helper.formatDuration(Helper.ExtractValue(match.group(), "duration\":", ",\"c"));
				
				if (Log.getMode())
					Log.println("Duration : " + duration);
				
				url = Helper.Concat("https://vimeo.com", Helper.ExtractValue(match.group(), "videos", "\",\"").replace("\\",""));
				
				if (Log.getMode())
					Log.println("Url : " + url);
				
				thumbnail = Helper.ExtractValue(Helper.ExtractValue(match.group(), "pictures\":{\"sizes\":", "r=pad"),"\"link\":\"","?").replace("\\", "");
				
				if (Log.getMode())
					Log.println("Thumbnail : " + thumbnail);
				
				if (Log.getMode())
					Log.println("********************************");
				
	            if (title != "__title__")
	            {
	            	if (duration != "")
	            	{
	            		Components comp = new Components(title, author, duration, url, thumbnail);
	            		
	            		Items.add(comp);
	            	}
	            }
	        }
		}		
	}
}