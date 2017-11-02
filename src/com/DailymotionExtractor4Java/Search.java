// This file is part of DailymotionExtractor4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// DailymotionExtractor4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// DailymotionExtractor4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with DailymotionExtractor4Java. If not, see<http://www.gnu.org/licenses/>.

//
// Copyright (c) 2017 Shin Izawa
// E-Mail: shin@izwx.biz
//
// https://github.com/izwx
//

package com.DailymotionExtractor4Java;

import java.io.IOException;

import org.json.JSONObject;

import com.DailymotionSearch4Java.Html;
import com.ccMixterExtractor4Java.Log;

public class Search
{
	public static String Query(String url) throws IOException {
        StringBuilder sb = new StringBuilder(url);
        sb.insert(27, "json/");
        sb.append("?fields=title,stream_h264_url,stream_h264_ld_url,stream_h264_hq_url,stream_h264_hd_url,stream_h264_hd1080_url");
        String jsonUrl = new String(sb);

        String videoList = Html.getContentfromUrl(jsonUrl).toString();
        
        if((videoList == null)||(videoList.isEmpty())) {
            return null;
        }

        JSONObject info;
        String videoURL;
        try{
            info = new JSONObject(videoList);
            videoURL = info.getString("stream_h264_hq_url");
            if((videoURL == null)||(videoURL.isEmpty())||(videoURL.equals("null"))) {
                videoURL = info.getString("stream_h264_ld_url");
            }
            if((videoURL == null)||(videoURL.isEmpty())||(videoURL.equals("null"))) {
                videoURL = info.getString("stream_h264_url");
            }
            if((videoURL == null)||(videoURL.isEmpty())||(videoURL.equals("null"))) {
                videoURL = info.getString("stream_h264_hd1080_url");
            }
            if((videoURL == null)||(videoURL.isEmpty())||(videoURL.equals("null"))) {
                videoURL = info.getString("stream_h264_hd_url");
            }
            if((videoURL == null)||(videoURL.isEmpty())||(videoURL.equals("null"))) {
                videoURL = null;
            }
        }
        catch (Exception e) {
            return null;
        }
        
        if (Log.getMode())
			Log.println("Video url: " + videoURL);
        
        if (Log.getMode())
			Log.println("********************************");

        return videoURL;
    }
}