// This file is part of jTube.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// jTube is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jTube is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with jTube. If not, see<http://www.gnu.org/licenses/>.

package com.jTube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main (String [] args) throws NumberFormatException, IOException
	{
		/* Supported Tubes: 
		 * 
		 * ccMixter (-cc)
		 * Vimeo (-vi)
		 * xHamster (-xh)
		 * YouTube (-yt)
		 * 
		 */
		
		/*
		 * *** Search ***
		 * 
		 * args[0] -s
		 * args[1] Tube
		 * args[2] Querystring
		 * args[3] Querypages
		 * 
		 * ***********************
		 * 
		 * *** Extract ***
		 * 
		 * args[0] -e
		 * args[1] Tube
		 * args[2] Url
		 * 
		 * ***********************
		 * 
		 * *** Download ***
		 * 
		 * args[0] -d
		 * args[1] Url
		 * args[2] Path
		 * args[3] Filename
		 * 
		 * ***********************
		 * 
		 * *** Help ***
		 * 
		 * args[0] -h
		 * 
		 */
		
		/* Debug */
		Debug.setMode(false);
		
		if (Debug.getMode())
		{
			Log.setMode(true);
			
			args = new String[4];
			
			args[0] = "-s";
			args[1] = "-cc";
			args[2] = "Test";
			args[3] = "2";
		}
		
		if (args.length <= 0)
			return;
		
		switch(args[0])
		{
		case "-s":
			switch (args[1])
			{
			case "-cc":
				List<com.ccMixterSearch.Components> Items_cc = 
					new ArrayList<com.ccMixterSearch.Components>();
				
				com.ccMixterSearch.Search.Query(Items_cc, args[2], Integer.parseInt(args[3]));
				
				int i_cc = 0;
				
				for (com.ccMixterSearch.Components c:Items_cc)
				{
					i_cc++;
					
					System.out.println("ID: " + i_cc + Helper.printZero() +
							"Title: " + c.getTitle() + Helper.printZero() +
							"Author: " + c.getAuthor() + Helper.printZero() +
							"Url: " + c.getUrl());
				}
				break;
			case "-vi":
				List<com.VimeoSearch.Components> Items_vi =
					new ArrayList<com.VimeoSearch.Components>();
				
				com.VimeoSearch.Search.Query(Items_vi, args[2], Integer.parseInt(args[3]));
				
				int i_vi = 0;
				
				for (com.VimeoSearch.Components c:Items_vi)
				{
					i_vi++;
					
					System.out.println("ID: " + i_vi + Helper.printZero() +
							"Title: " + c.getTitle() + Helper.printZero() +
							"Author: " + c.getAuthor() + Helper.printZero() +
							"Duration: " + c.getDuration() + Helper.printZero() +
							"Url: " + c.getUrl() + Helper.printZero() + 
							"Thumbnail: " + c.getThumbnail());
				}
				break;
			case "-yt":
				List<com.YouTubeSearch.Components> Items_yt =
					new ArrayList<com.YouTubeSearch.Components>();
				
				com.YouTubeSearch.Search.Query(Items_yt, args[2], Integer.parseInt(args[3]));
				
				int i_yt = 0;
				
				for (com.YouTubeSearch.Components c:Items_yt)
				{
					i_yt++;
					
					System.out.println("ID: " + i_yt + Helper.printZero() +
							"Title: " + c.getTitle() + Helper.printZero() +
							"Author: " + c.getAuthor() + Helper.printZero() +
							"Description: " + c.getDescription() + Helper.printZero() +
							"Duration: " + c.getDuration() + Helper.printZero() +
							"Url: " + c.getUrl() + Helper.printZero() + 
							"Thumbnail: " + c.getThumbnail());
				}
				break;
			case "-xh":
				List<com.xHamsterSearch.Components> Items_xh =
					new ArrayList<com.xHamsterSearch.Components>();
				
				com.xHamsterSearch.Search.Query(Items_xh, args[2], Integer.parseInt(args[3]));
				
				int i_xh = 0;
				
				for (com.xHamsterSearch.Components c:Items_xh)
				{
					i_xh++;
					
					System.out.println("ID: " + i_xh + Helper.printZero() +
							"Title: " + c.getTitle() + Helper.printZero() +
							"Duration: " + c.getDuration() + Helper.printZero() +
							"Url: " + c.getUrl() + Helper.printZero() + 
							"Thumbnail: " + c.getThumbnail());
				}
				break;
			}
			break;
		case "-e":
			switch (args[1])
			{
			case "-cc":
				String url_cc = com.ccMixterExtractor.Search.Query(args[2]);
				
				System.out.println(url_cc);
				break;
			case "-vi":
				String url_vi = com.VimeoExtractor.Search.Query(args[2]);
				
				System.out.println(url_vi);
				break;
			case "-yt":
				List<com.YouTubeExtractor.FmtStreamMap> streamMaps = 
						com.YouTubeExtractor.Extract.Run(args[2]);
				
				for (com.YouTubeExtractor.FmtStreamMap s: streamMaps)
				{
					System.out.println(
							s.title + Helper.printZero() +
							s.resolution.format + Helper.printZero() +
							s.resolution.resolution + Helper.printZero() +
							com.YouTubeExtractor.Extract.parseUrl(s));
				}
				break;
			case "-xh":
				List<com.xHamsterExtractor.Components> Items =
					new ArrayList<com.xHamsterExtractor.Components>();
				
				com.xHamsterExtractor.Search.Query(Items, args[2]);
				
				int i_xh = 0;
				
				for (com.xHamsterExtractor.Components c:Items)
				{
					i_xh++;
					
					System.out.println("ID: " + i_xh + Helper.printZero() +
							"Title: " + c.getTitle() + Helper.printZero() +
							"Format: " + c.getFormat() + Helper.printZero() +
							"Resolution: " + c.getResolution() + Helper.printZero() + 
							"Url: " + c.getUrl());
				}
				break;
			}
			break;
		case "-d":
			com.DownloadManager.Download.downloadFileAsync(
					args[1],
					args[2],
					args[3]);
			break;
		case "-h":
			System.out.println("/*");
			System.out.println("*");
			System.out.println("* Supported Tubes:");
			System.out.println("*");
			System.out.println("* ccMixter (-cc), Vimeo (-vi), xHamster (-xh), YouTube (-yt)");
			System.out.println("*");
			System.out.println("* ***********************");
			System.out.println("*");
			System.out.println("* *** Search ***");
			System.out.println("*");
			System.out.println("* args[0] -s");
			System.out.println("* args[1] Tube");
			System.out.println("* args[2] Querystring");
			System.out.println("* args[3] Querypages");
			System.out.println("*");
			System.out.println("* ***********************");
			System.out.println("*");
			System.out.println("* *** Extract ***");
			System.out.println("*");
			System.out.println("* args[0] -e");
			System.out.println("* args[1] Tube");
			System.out.println("* args[2] Url");
			System.out.println("*");
			System.out.println("* ***********************");
			System.out.println("*");
			System.out.println("* *** Download ***");
			System.out.println("*");
			System.out.println("* args[0] -d");
			System.out.println("* args[1] Url");
			System.out.println("* args[2] Path");
			System.out.println("* args[3] Filename");
			System.out.println("*");
			System.out.println("*/");
			break;
		}
	}
}