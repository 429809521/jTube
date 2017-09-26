// This file is part of xHamsterExtractor.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// xHamsterExtractor is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// xHamsterExtractor is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with xHamsterExtractor. If not, see<http://www.gnu.org/licenses/>.

package com.xHamsterExtractor;

import java.time.Instant;

public class Log
{
	static boolean isEnabled;
	
	public static boolean getMode() {
		return isEnabled;
	}

	public static boolean setMode(boolean Mode) {
		return isEnabled = Mode;
	}
	
	public static void println (String value)
	{
		System.out.println("[" + Instant.now() + "]" + " " + value);
	}
}