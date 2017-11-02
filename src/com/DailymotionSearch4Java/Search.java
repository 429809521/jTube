// This file is part of DailymotionSearch4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// DailymotionSearch4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// DailymotionSearch4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with DailymotionSearch4Java. If not, see<http://www.gnu.org/licenses/>.

package com.DailymotionSearch4Java;

import java.io.*;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Search
{
	static String title;
	static String author;
	static String url;

	public static void Query (List<Components> Items, String QueryString, Integer QueryPages) throws IOException
	{
		CharSequence sb = Html.getContentfromUrl("https://api.dailymotion.com/videos?search=" + QueryString.replace(" ", "+") + "&limit=" + QueryPages * 15);
		
		try
		{
			if (Log.getMode())
				Log.println("Source : " + sb);
			
			JSONObject obj = new JSONObject(sb.toString());

			JSONArray arr = obj.getJSONArray("list");
			
			for (int i = 0; i < arr.length(); i++)
			{
			    title = arr.getJSONObject(i).getString("title");
			    
			    if (Log.getMode())
					Log.println("Title : " + title);
				
				if (Log.getMode())
					Log.println("********************************");
			    
			    author = arr.getJSONObject(i).getString("owner");
			    
			    if (Log.getMode())
					Log.println("Author : " + author);
				
				if (Log.getMode())
					Log.println("********************************");
			    
			    url = "http://www.dailymotion.com/video/" + arr.getJSONObject(i).getString("id");
			    
			    if (Log.getMode())
					Log.println("Url : " + url);
				
				if (Log.getMode())
					Log.println("********************************");
				
				Components comp = new Components(title, author, url);
        		
        		Items.add(comp);
			}
		}
		catch (Exception e) {
			if (Log.getMode())
				Log.println(e.toString());
        }	
	}
}