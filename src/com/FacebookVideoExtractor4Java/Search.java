// This file is part of FacebookVideoExtractor4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// FacebookVideoExtractor4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// FacebookVideoExtractor4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with FacebookVideoExtractor4Java. If not, see<http://www.gnu.org/licenses/>.

package com.FacebookVideoExtractor4Java;

import java.io.*;

public class Search
{
	public static String Query (String Url) throws IOException
	{
		if (!Url.contains("facebook"))
			return null;
		
		CharSequence sb = Html.getContentfromUrl(Url);
		
		String html = sb.toString();
		
		String title = Helper.ExtractValue(html, "\"pageTitle\">", "</title><link");
		String URL = Helper.ExtractValue(html.replace("\r\n", ""), "sd_src_no_ratelimit:\"", "\",hd_src_no_ratelimit:");
        
        if (Log.getMode())
			Log.println("Title : " + title);
        
        if (Log.getMode())
			Log.println("Url : " + URL);
		
		if (Log.getMode())
			Log.println("********************************");
		
		return title + ";" + URL;
	}
}