// This file is part of ccMixterExtractor4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// ccMixterExtractor4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ccMixterExtractor4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ccMixterExtractor4Java. If not, see<http://www.gnu.org/licenses/>.

package com.ccMixterExtractor;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search
{
	static String url;

	public static String Query (String Url) throws IOException
	{
		url = "";
		
		if (!Url.contains("ccmixter"))
			return null;
		
		CharSequence sb = Html.getContentfromUrl(Url);
		
		String expr = "http://ccmixter.org/content/.*?.mp3";
		Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
		
		Matcher match = patt.matcher(sb);
		
		while (match.find()) {				
			if (!match.group().contains("</script>"))
			{
				if (Log.getMode())
					Log.println("Match: " + match.group());
				
				url = match.group();
				
				if (Log.getMode())
					Log.println("Url : " + url);
				
				if (Log.getMode())
					Log.println("********************************");
			}
		}
		
		return url;
	}
}