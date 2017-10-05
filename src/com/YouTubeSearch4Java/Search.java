// This file is part of YoutubeSearch4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// YoutubeSearch4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// YoutubeSearch4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with YoutubeSearch4Java. If not, see<http://www.gnu.org/licenses/>.

package com.YouTubeSearch4Java;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search
{
	static String title;
	static String author;
	static String description;
	static String duration;
	static String url;
	static String thumbnail;

	public static void Query (List<Components> Items, String QueryString, Integer QueryPages) throws IOException
	{
		for (int i = 1; i <= QueryPages; i++)
		{
			CharSequence sb = Html.getContentfromUrl("https://www.youtube.com/results?search_query=" + QueryString.replace(" ", "+") + "&page=" + i);
			
			String expr = "<div class=\"yt-lockup-content\">.*?title=\"(?<NAME>.*?)\".*?</div></div></div></li>";
			Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
			
			Matcher match = patt.matcher(sb);
			
			while (match.find()) {				
				if (Log.getMode())
					Log.println("Match: " + match.group());
				
				title = match.group(1);
				
				if (Log.getMode())
					Log.println("Title : " + title);
				
				author = Helper.ExtractValue(match.group(), "/user/", "class").replace('"', ' ').trim();
				
				if (Log.getMode())
					Log.println("Author : " + author);
				
				description = Helper.ExtractValue(match.group(), "<div class=\"yt-lockup-description yt-ui-ellipsis yt-ui-ellipsis-2\" dir=\"ltr\">", "</div>");
				
				if (Log.getMode())
					Log.println("Description : " + description);
				
				duration = Helper.ExtractValue(Helper.ExtractValue(match.group(), "id=\"description-id-", "span"), ": ", "<").replace(".","");
				
				if (Log.getMode())
					Log.println("Duration : " + duration);
				
				url = Helper.Concat("http://www.youtube.com/watch?v=", Helper.ExtractValue(match.group(), "watch?v=", "\""));
				
				if (Log.getMode())
					Log.println("Url : " + url);
				
				thumbnail = Helper.Concat("https://i.ytimg.com/vi/", Helper.ExtractValue(match.group(), "watch?v=", "\""), "/mqdefault.jpg");
				
				if (Log.getMode())
					Log.println("Thumbnail : " + thumbnail);
				
				if (Log.getMode())
					Log.println("********************************");
				
	            if (title != "__title__")
	            {
	            	if (duration != "")
	            	{
	            		Components comp = new Components(title, author, description, duration, url, thumbnail);
	            		
	            		Items.add(comp);
	            	}
	            }
	        }
		}		
	}
}