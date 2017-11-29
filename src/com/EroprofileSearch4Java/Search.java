// This file is part of EroprofileSearch4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// EroprofileSearch4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// EroprofileSearch4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with EroprofileSearch4Java. If not, see<http://www.gnu.org/licenses/>.

package com.EroprofileSearch4Java;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search
{
	static String title;
	static String duration;
	static String url;
	static String thumbnail;

	public static void Query (List<Components> Items, String QueryString, Integer QueryPages) throws IOException
	{
		for (int i = 1; i <= QueryPages; i++)
		{
			CharSequence sb = Html.getContentfromUrl("http://www.eroprofile.com/m/videos/search?text=" + QueryString.replace(" ", "+") + "&pnum=" + i);
			
			if (Debug.getMode())
			{
				System.out.println(sb);
			}
			
			String expr = "<div class=\"video\">.*?</span> <a href=.*?</a></div></div>";
			
			Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
			
			Matcher match = patt.matcher(sb);
			
			while (match.find()) {				
				if (Log.getMode())
					Log.println("Match: " + match.group());
				
				title = Helper.ExtractValue(match.group(), "videoTtl", "</div><div class");
				title = Helper.Concat(title, "\"");
				title = Helper.ExtractValue(title, "\">", "\"");
				
				if (Log.getMode())
					Log.println("Title : " + title);
				
				duration = Helper.ExtractValue(match.group(), "\"videoDur\">", "</div></a> <");
				
				if (Log.getMode())
					Log.println("Duration : " + duration);
				
				url = Helper.Concat("http://www.eroprofile.com", Helper.ExtractValue(match.group(), "><div><a href=\"", "\" class=\"cbox\""));
				
				if (Log.getMode())
					Log.println("Url : " + url);
				
				thumbnail = Helper.Concat("http://", Helper.ExtractValue(match.group(), "src=\"//", "\" class=\"vi").replace("amp;", ""));
				
				if (Log.getMode())
					Log.println("Thumbnail : " + thumbnail);
				
				if (Log.getMode())
					Log.println("********************************");
				
				Components comp = new Components(title, duration, url, thumbnail);
        		
        		Items.add(comp);
	        }
		}		
	}
}