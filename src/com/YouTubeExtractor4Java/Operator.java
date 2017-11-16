// This file is part of YouTubeExtractor4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// YouTubeExtractor4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// YouTubeExtractor4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with YouTubeExtractor4Java. If not, see<http://www.gnu.org/licenses/>.

package com.YouTubeExtractor4Java;

/* JAR
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List; */

public class Operator
{
	/* JAR
	public static void main (String [] args) throws IOException, URISyntaxException
	{
		Debug.setMode(true);
		
		if (Debug.getMode())
		{
			Log.setMode(true);
			
			args = new String[1];
			
			args[0] = "https://www.youtube.com/watch?v=wYIcRYXG9us";
		}
		
		if (args.length == 1)
		{
			List<FmtStreamMap> streamMaps = Extract.Run(args[0]);
			
			for (FmtStreamMap s: streamMaps)
			{
				System.out.println(
						s.title + Helper.printZero() +
						s.resolution.format + Helper.printZero() +
						s.resolution.resolution + Helper.printZero() +
						Extract.parseUrl(s));
			}
		}
		else
			return;
	} */
	
	/* JAR
	public static void RunCompleteProcedure() throws IOException
	{
		List<FmtStreamMap> streamMaps = new ArrayList<FmtStreamMap>();
		
		streamMaps = Extract.Run("https://www.youtube.com/watch?v=wYIcRYXG9us");
		
		if (streamMaps == null)
		{
			System.out.println("FmtStreamMap is null.");
			
			return;
		}
		
		if (streamMaps.isEmpty() == false)
		{
			for (FmtStreamMap s: streamMaps)
			{
				System.out.println(
						s.title + Helper.printZero() +
						s.resolution.format + Helper.printZero() +
						s.resolution.resolution + Helper.printZero() +
						Extract.parseUrl(s));
			}
		}
		else
			System.out.println("FmtStreamMap is empty.");
	} */
}