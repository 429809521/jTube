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
import java.net.*;

public class Html
{
	public static CharSequence getContentfromUrl(String Url) throws IOException
	{		
		URL url = new URL(Url);
		
		URLConnection conn = url.openConnection();
		
		// User-Agent, otherwise eroprofile redirect to mobile site
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		
		String encoding = conn.getContentEncoding();
        
		if (encoding == null) {
            encoding = "ISO-8859-1";
        }
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
		
		StringBuilder sb = new StringBuilder(16384);
	        
		try {
			String line;
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
				}
			} finally {
				br.close();
			}
		
		return sb;
	}
}