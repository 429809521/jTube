// This file is part of PornhubExtractor.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// PornhubExtractor is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// PornhubExtractor is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with PornhubExtractor. If not, see<http://www.gnu.org/licenses/>.

package com.PornhubExtractor4Java;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.InstagramPictureExtractor4Java.Log;

public class Search
{
	static String title;
	static String format;
	static String resolution;
	static String url;

	public static String Query (String Url) throws IOException
	{
		url = "";
		
		if (!Url.contains("pornhub"))
			return Helper.printZero();
		
		CharSequence sb = Html.getContentfromUrl(Url);
		
		String expr = "720\",\"videoUrl\":\".*?\"";
		
		Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
		
		Matcher match = patt.matcher(sb);
		
		while (match.find()) {
			
			String TITLE = Helper.ExtractValue(sb.toString(), "<title>", "</title>")
					.replace(" - Pornhub.com", "");
			
			String URL = match.group().replace("\\", "").replace("720\",\"videoUrl\":\"", "")
					.replace("\"", "");
			
			if (Log.getMode())
				Log.println("Title : " + TITLE);
			
			if (Log.getMode())
				Log.println("********************************");
			
			if (Log.getMode())
				Log.println("Url : " + URL);
			
			if (Log.getMode())
				Log.println("********************************");
			
			return TITLE + ";" + URL;
		}
		
		return Helper.printZero();
	}
}