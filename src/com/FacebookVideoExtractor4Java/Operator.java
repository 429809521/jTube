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

/* JAR
import java.io.IOException; */

public class Operator
{
	/* JAR
	public static void main (String [] args) throws IOException
	{
		Debug.setMode(true);
		
		if (Debug.getMode())
		{
			Log.setMode(true);
			
			args = new String[1];
			
			args[0] = "https://de-de.facebook.com/BestTrendVideos/videos/2448439258715260/";
		}
		
		if (args.length == 1)
		{
			String retValue = Search.Query(args[0]);
			
			String[] value = retValue.split(";");
			
			System.out.println("Title: " + value[0]);
			System.out.println("Url: " + value[1]);
		}
		else
			return;
	} */
}