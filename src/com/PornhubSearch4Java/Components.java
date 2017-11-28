// This file is part of PornhubSearch4Java.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
//
// PornhubSearch4Java is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// PornhubSearch4Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with PornhubSearch4Java. If not, see<http://www.gnu.org/licenses/>.

package com.PornhubSearch4Java;

public class Components
{
	private String Title;
	private String Duration;
	private String Url;
	private String Thumbnail;
	
	public Components (String Title, String Duration, String Url, String Thumbnail)
	{
		this.setTitle(Title);
		this.setDuration(Duration);
		this.setUrl(Url);
		this.setThumbnail(Thumbnail);
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}
	
	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getThumbnail() {
		return Thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		Thumbnail = thumbnail;
	}
}