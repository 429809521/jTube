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

public class Components
{
	private String Title;
	private String Author;
	private String Url;
	
	public Components (String Title, String Author, String Url)
	{
		this.setTitle(Title);
		this.setAuthor(Author);
		this.setUrl(Url);
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}
	
	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}