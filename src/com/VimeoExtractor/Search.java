// This file is part of VimeoExtractor4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// VimeoExtractor4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// VimeoExtractor4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with VimeoExtractor4Java. If not, see<http://www.gnu.org/licenses/>.

package com.VimeoExtractor;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search
{
	static String url;
	static String url_;

	public static String Query (String Url) throws IOException
	{
		url = "";
		url_ = "";
		
		if (!Url.contains("vimeo"))
			return null;
		
		CharSequence sb = Html.getContentfromUrl(Url);
		
		String expr = "config_url.*?player_url";
		Pattern patt = Pattern.compile(expr, Pattern.DOTALL | Pattern.UNIX_LINES);
		
		Matcher match = patt.matcher(sb);
		
		while (match.find() && url == "") {
			if (Log.getMode())
				Log.println("Match: " + match.group());
				
			url = match.group();
				
			url = url.replace("config_url\":\"","");
			url = url.replace("\",\"player_url","");
			url = url.replace("\\","");
			
			if (Log.getMode())
				Log.println("ConfigUrl : " + url);
				
			CharSequence sb_ = Html.getContentfromUrl(url);
				
			String expr_ = "fps.*?level3";
			Pattern patt_ = Pattern.compile(expr_, Pattern.DOTALL | Pattern.UNIX_LINES);
				
			Matcher match_ = patt_.matcher(sb_);
			
			while (match_.find() && url_ == "") {
				if (Log.getMode())
					Log.println("Match: " + match_.group());
					
				url_ = Helper.ExtractValue(match_.group(), "fps\":24,\"url\":\"", "\",\"cdn\":\"level3");
			}
				
			if (Log.getMode())
				Log.println("Mp4Url : " + url_);
				
			if (Log.getMode())
				Log.println("********************************");
		}
		
		return url_;
	}
}