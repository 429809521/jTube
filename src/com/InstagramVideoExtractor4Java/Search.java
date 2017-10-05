// This file is part of InstagramVideoExtractor4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// InstagramVideoExtractor4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// InstagramVideoExtractor4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with InstagramVideoExtractor4Java. If not, see<http://www.gnu.org/licenses/>.

package com.InstagramVideoExtractor4Java;

import java.io.*;

public class Search
{
	static String url;

	public static String Query (String Url) throws IOException
	{
		url = "";
		
		if (!Url.contains("instagram"))
			return null;
		
		CharSequence sb = Html.getContentfromUrl(Url);
		
		String sourceCode = sb.toString();
		
		int startIndex = sourceCode.indexOf("og:video") + 19;
        
		sourceCode = sourceCode.substring(startIndex, sourceCode.length() - startIndex);
        
        int startIndexFile = sourceCode.indexOf(".ak.instagram.com/") + 18;
        int endIndex = sourceCode.indexOf(".mp4");
        
        String title = sourceCode.substring(startIndexFile, endIndex - startIndexFile);
        String url = sourceCode.substring(0, endIndex + 4);
        
        if (Log.getMode())
			Log.println("Title : " + title);
        
        if (Log.getMode())
			Log.println("Url : " + url);
		
		if (Log.getMode())
			Log.println("********************************");
		
		return title + ";" + url;
	}
}