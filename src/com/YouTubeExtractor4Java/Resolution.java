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

public class Resolution {
    
	public Resolution(String _id, String _resolution, String _format, String _type, ResolutionNote _notes) {
        id = _id;
        resolution = _resolution;
        format = _format;
        type = _type;
        notes = _notes;
    }

    public String id;
    public String resolution;
    public String format;
    public String type;
    public ResolutionNote notes;
    
    public enum ResolutionNote {
        HD, MHD, LHD, XLHD }
}