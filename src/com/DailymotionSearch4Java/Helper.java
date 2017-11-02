// This file is part of DailymotionSearch4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// DailymotionSearch4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// DailymotionSearch4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with DailymotionSearch4Java. If not, see<http://www.gnu.org/licenses/>.

package com.DailymotionSearch4Java;

import com.VimeoSearch4Java.Log;

public class Helper
{
	public static String printZero()
	{
		return " ";
	}
	
	public static String ExtractValue(String Source, String Start, String End)
	{
		int start, end;
				
		try
		{
			if (Source.contains(Start) && Source.contains(End))
			{
				start = Source.indexOf(Start, 0) + Start.length();
				end = Source.indexOf(End, start);
				
				return Source.substring(start, end);
			}
			else
				return printZero();
		}
		catch (Exception e)
		{
			if (Log.getMode())
				Log.println(e.toString());
			
			return printZero();
		}
	}
}