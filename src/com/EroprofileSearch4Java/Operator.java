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

/* JAR
import java.io.IOException;
import java.util.*;
import java.util.ArrayList; */

public class Operator
{
	/* JAR
	public static void main (String [] args) throws IOException
	{
		Debug.setMode(true);
		
		if (Debug.getMode())
		{
			Log.setMode(true);
			
			args = new String[2];
			
			args[0] = "Test";
			args[1] = "2";
		}
		
		if (args.length == 2)
		{
			List<Components> Items = new ArrayList<Components>();
			
			Search.Query(Items, args[0], Integer.parseInt(args[1]));
			
			int i = 0;
			
			for (Components c:Items)
			{
				i++;
				
				System.out.println("ID: " + i + Helper.printZero() +
						"Title: " + c.getTitle() + Helper.printZero() +
						"Duration: " + c.getDuration() + Helper.printZero() +
						"Url: " + c.getUrl() + Helper.printZero() + 
						"Thumbnail: " + c.getThumbnail());
			}
		}
		else
			return;
	} */
}