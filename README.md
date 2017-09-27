# jTube

Search and download videos from YouTube, Vimeo, xHamster and many more.

# Introduction

**What is jTube?**

**jTube is a simple terminal application to search and download videos from YouTube, xHamster, Vimeo and many more.** jTube is written in Java.

# Example usage

```
Search videos containing „Test“ at Vimeo and show first 2 result pages on Windows.

###########################################
##                                       ##
##   java -jar jTube.jar -s -vi Test 2   ##
##                                       ##
###########################################

Execute jTube: java -jar jTube.jar

Command: -s = Search

Tube: -vi = Vimeo

Querystring: Test

Result pages: 2
```

# Features

* Search videos
* Extract video infos from url
* Download video / audio from url

# Dependencies

org.json (https://github.com/stleary/JSON-java)

# Build

Requirements:

* eclipse
* Java SDK 8

# Developer channel

#jtube:matrix.org (https://about.riot.im/)

# Description

**Supported Tubes:**

* ccMixter (-cc)
* Vimeo (-vi)
* xHamster (-xh)
* YouTube (-yt)

**Search:**

* args[0] -s
* args[1] Tube
* args[2] Querystring
* args[3] Querypages

**Extract:**

* args[0] -e
* args[1] Tube
* args[2] Url

**Download:**

* args[0] -d
* args[1] Url
* args[2] Path
* args[3] Filename

**Help:**

* args[0] -h
