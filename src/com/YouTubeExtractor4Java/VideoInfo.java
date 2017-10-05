// This file is part of YouTubeExtractor4Java.
//
// Copyright (c) 2015 Baidu, Inc. All Rights Reserved.
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

import java.util.*;

import com.YouTubeExtractor4Java.Resolution.ResolutionNote;

public class VideoInfo
{
	public static List<Resolution> playResolutions = new ArrayList<Resolution>();

    static {
        playResolutions.add(new Resolution("17", "176x144", "3gp", "normal", ResolutionNote.LHD));
        playResolutions.add(new Resolution("36", "320x240", "3gp", "normal", ResolutionNote.LHD));
        playResolutions.add(new Resolution("18", "640x360", "mp4", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("242", "360x240", "webm", "normal", ResolutionNote.LHD));
        playResolutions.add(new Resolution("242", "360x240", "webm", "normal", ResolutionNote.LHD));
        playResolutions.add(new Resolution("243", "480x360", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("243", "480x360", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("43", "640x360", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("244", "640x480", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("245", "640x480", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("167", "640x480", "webm", "video", ResolutionNote.MHD));
        playResolutions.add(new Resolution("246", "640x480", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("247", "720x480", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("44", "854x480", "webm", "normal", ResolutionNote.MHD));
        playResolutions.add(new Resolution("168", "854x480", "webm", "video", ResolutionNote.MHD));
    }

    public static HashMap<String, Resolution> Resolutions = new HashMap<String, Resolution>();

    static {
        Resolutions.put("5", new Resolution("5", "400x240", "flv", "normal", ResolutionNote.LHD));//
        Resolutions.put("6", new Resolution("6", "450x270", "flv", "normal", ResolutionNote.MHD));
        Resolutions.put("17", new Resolution("17", "176x144", "3gp", "normal", ResolutionNote.LHD));//
        Resolutions.put("18", new Resolution("18", "640x360", "mp4", "normal", ResolutionNote.MHD));
        Resolutions.put("22", new Resolution("22", "1280x720", "mp4", "normal", ResolutionNote.HD));
        Resolutions.put("34", new Resolution("34", "640x360", "flv", "normal", ResolutionNote.MHD));
        Resolutions.put("35", new Resolution("35", "854x480", "flv", "normal", ResolutionNote.MHD));
        Resolutions.put("36", new Resolution("36", "320x240", "3gp", "normal", ResolutionNote.LHD));//
        Resolutions.put("37", new Resolution("37", "1920x1080", "mp4", "normal", ResolutionNote.XLHD));
        Resolutions.put("38", new Resolution("38", "4096x3072", "mp4", "normal", ResolutionNote.XLHD));
        Resolutions.put("43", new Resolution("43", "640x360", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("44", new Resolution("44", "854x480", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("45", new Resolution("45", "1280x720", "webm", "normal", ResolutionNote.HD));
        Resolutions.put("46", new Resolution("46", "1920x1080", "webm", "normal", ResolutionNote.XLHD));
        Resolutions.put("167", new Resolution("167", "640x480", "webm", "video", ResolutionNote.MHD));
        Resolutions.put("168", new Resolution("168", "854x480", "webm", "video", ResolutionNote.MHD));
        Resolutions.put("169", new Resolution("169", "1280x720", "webm", "video", ResolutionNote.HD));
        Resolutions.put("170", new Resolution("170", "1920x1080", "webm", "video", ResolutionNote.XLHD));
        Resolutions.put("242", new Resolution("242", "360x240", "webm", "normal", ResolutionNote.LHD));//
        Resolutions.put("243", new Resolution("243", "480x360", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("244", new Resolution("244", "640x480", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("245", new Resolution("245", "640x480", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("246", new Resolution("246", "640x480", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("247", new Resolution("247", "720x480", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("82", new Resolution("82", "360p", "mp4", "normal", ResolutionNote.MHD));
        Resolutions.put("83", new Resolution("83", "480p", "mp4", "normal", ResolutionNote.MHD));
        Resolutions.put("84", new Resolution("84", "720p", "mp4", "normal", ResolutionNote.MHD));
        Resolutions.put("85", new Resolution("85", "1080p", "mp4", "normal", ResolutionNote.MHD));
        Resolutions.put("100", new Resolution("100", "360p", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("101", new Resolution("101", "480p", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("102", new Resolution("102", "720p", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("139", new Resolution("139", "Audio only", "m4a", "normal", ResolutionNote.MHD));
        Resolutions.put("140", new Resolution("140", "Audio only", "m4a", "normal", ResolutionNote.MHD));
        Resolutions.put("141", new Resolution("141", "Audio only", "m4a", "normal", ResolutionNote.MHD));
        Resolutions.put("171", new Resolution("313", "Audio only", "webm", "normal", ResolutionNote.MHD));
        Resolutions.put("172", new Resolution("313", "Audio only", "webm", "normal", ResolutionNote.MHD));
    }
}