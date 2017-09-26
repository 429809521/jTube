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

package com.DownloadManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Download extends Thread
{
	String Url;
	String DestinationFile;
	String Directory;
	
	// Public constructor
	public static void downloadFileAsync (String Url, String Directory, String DestinationFile) throws IOException
	{
		// Async download
		new Download(Url, Directory, Helper.VerifyFileName(DestinationFile)).start();
	}
	
	// Store parameters
	private Download(String Url, String Directory, String DestinationFile){
        this.Url = Url;
        this.DestinationFile = DestinationFile;
        this.Directory = Directory;
    }
	
	// Start download as a thread
    @Override
    public void run() {
    	try
    	{
    		URL url = new URL(Url);
    		File file = new File(Directory + DestinationFile);
    		
    		long downloadedLength = 0;

    	    BufferedInputStream inputStream = null;
    	    BufferedOutputStream outputStream = null;

    	    URLConnection connection = url.openConnection();

    	    if(file.exists()){
    	        downloadedLength = file.length();
    	        connection.setRequestProperty("Range", "bytes=" + downloadedLength + "-");
    	        outputStream = new BufferedOutputStream(new FileOutputStream(file, true));

    	    }else{
    	        outputStream = new BufferedOutputStream(new FileOutputStream(file));
    	    }

    	    connection.connect();

    	    inputStream = new BufferedInputStream(connection.getInputStream());

    	    byte[] buffer = new byte[1024*8];
    	    int byteCount;

    	    int cLength = connection.getContentLength();
    	    
    	    while ((byteCount = inputStream.read(buffer)) != -1){
    	        outputStream.write(buffer, 0, byteCount);
    	        
    	        downloadedLength += byteCount;
    	        
    	        downloadFileAsyncEventargs(cLength, downloadedLength);
    	    }

    	    inputStream.close();
    	    outputStream.flush();
    	    outputStream.close();
    	    
    	    downloadFileAsyncFinished();
    	}
    	catch (Exception e)
    	{
    		System.out.println("Download failed - " + e);
    	}
    }
    
    // Download file event args
    private void downloadFileAsyncEventargs(int FileSize, long FileSizeDownloaded)
    {
    	System.out.println(FileSizeDownloaded + " of " + FileSize + " " + 
    				(FileSizeDownloaded*100)/FileSize + " %");
    }
    
    // Download file finished
    private void downloadFileAsyncFinished()
    {
    	System.out.println("Download finished");
    }
}