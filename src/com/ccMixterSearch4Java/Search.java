// This file is part of ccMixterSearch4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// ccMixterSearch4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ccMixterSearch4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ccMixterSearch4Java. If not, see<http://www.gnu.org/licenses/>.

package com.ccMixterSearch4Java;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search
{
	static String title;
	static String author;
	static String url;

	public static void Query (List<Components> Items, String QueryString, Integer QueryPages) throws IOException
	{
		for (int i = 0; i <= QueryPages; i++)
		{
			int ii = i * 15;
			
			CharSequence sb = Html.getContentfromUrl("http://ccmixter.org/search?search_text=" + QueryString.replace(" ", "+") + "&search_type=any&search_in=uploads&offset=" + ii);
			
			String expr = "<div class=\"search_results_link\">.*?</div>";
			Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
			
			Matcher match = patt.matcher(sb);
			
			while (match.find()) {				
				if (Log.getMode())
					Log.println("Match: " + match.group());
				
				title = Helper.ExtractValue(match.group(), "class=\"cc_file_link\">", "</a>");
				
				if (Log.getMode())
					Log.println("Title : " + title);
				
				author = Helper.ExtractValue(
						Helper.ExtractValue(match.group(), "<a class=\"cc_user_link\" href=\"", "/a"), ">", "<");
				
				if (Log.getMode())
					Log.println("Author : " + author);
				
				url = Helper.ExtractValue(match.group(), "<a href=\"", "\" class=");
				
				if (Log.getMode())
					Log.println("Url : " + url);
				
				if (Log.getMode())
					Log.println("********************************");
				
	            if (title != "__title__")
	            {
	            	Components comp = new Components(title, author, url);
            		
            		Items.add(comp);
	            }
	        }
		}		
	}
}