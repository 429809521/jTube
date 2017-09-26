// This file is part of YouTubeExtractor4Java.
//
// Copyright (c) 2015 Baidu, Inc. All Rights Reserved.
//
// Copyright (c) 2017 Torsten Klinger.
// E-Mail: torsten.klinger@googlemail.com
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

package com.YouTubeExtractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Decipherer
{
	public static String decipher(String jsContent, FmtStreamMap fmtStreamMap) {
        
		String f1 =
            getRegexString(jsContent, "\\w+\\.sig\\|\\|([$a-zA-Z]+)\\([$a-zA-Z]+\\ .[$a-zA-Z]+\\)");
		
		if (TextUtils.isEmpty(f1)) {
            f1 = getRegexString(jsContent,
                    "\\w+\\.sig.*?\\?.*&&\\w+\\.set\\(\\\"signature\\\",([$a-zA-Z]+)\\([$a-zA-Z]+\\"
                        + ".[$a-zA-Z]+\\)\\)");
        }
		
		String finalF1 = f1;
        
        final String[] REGEX_PRE =
        	{"*", ".", "?", "+", "$", "^", "[", "]", "(", ")", "{", "}", "|", "\\", "/"};

        for (String aREGEX_PRE : REGEX_PRE) {

            if (f1.contains(aREGEX_PRE)) {
                finalF1 = "\\" + f1;
                break;
            }
        }
        
        String f1def =
            getRegexString(jsContent, String.format(
                "((function\\s+%s|[{;,]%s\\s*=\\s*function|var\\s+%s\\s*=\\s*function\\s*)\\([^)]*\\)"
                    + "\\s*\\{[^\\{]+\\})",
                finalF1, finalF1, finalF1));

        if (f1def.startsWith(",")) {
            f1def = f1def.replaceFirst(",", "");
        }

        StringBuilder functionSb = new StringBuilder();
        
        trJs(f1def, jsContent, functionSb);

        if (functionSb.length() > 0) {
            String jsStr = functionSb.toString() + "\n" + String.format("%s('%s')", f1, fmtStreamMap.s);
            
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            
            try {
                String sig = (String) engine.eval(jsStr);
                return String.format("%s&signature=%s", fmtStreamMap.url, sig);
                } catch (Exception e) {}
        }
        
        return null;
        
	}
	private static void trJs(String jsfunction, String jsContent, StringBuilder functionSb) {
        
		String[] split = jsfunction.split(";");
        Pattern funcPattern = Pattern.compile("([$\\w]+)=([$\\w]+)\\(((?:\\w+,?)+)\\)$");
        Pattern objPattern = Pattern.compile("([$\\w]+).([$\\w]+)\\(((?:\\w+,?)+)\\)$");
        Matcher matcher = null;
        
        for (String code : split) {
        	
        	String innerFuncCall = null;
            matcher = objPattern.matcher(code);
            
            if (matcher.matches()) {
                
            	@SuppressWarnings("unused")
				String strObj, strFuncName, strArgs;
                
            	strObj = matcher.group(1);
                strFuncName = matcher.group(2);
                strArgs = matcher.group(3);
                
                if (!TextUtils.isEmpty(strObj)) {
                    jsfunction = jsfunction.replace(strObj + ".", "");
                }
                
                String objFunction = "(" + strFuncName + "\\s*:\\s*function\\(.*?\\)\\{[^\\{]+\\})";
                String f1def = getRegexString(jsContent, objFunction);

                if (!TextUtils.isEmpty(f1def)) {
                    String objFuncMain = "function ";
                    f1def = f1def.replace(":function", "");
                    f1def = f1def.replace("}}", "}");
                    objFuncMain += f1def;
                    functionSb.append(objFuncMain);
                    functionSb.append("\n");
                }
            }

            matcher = funcPattern.matcher(code);
            
            if (matcher.matches()) {
                
            	String strFunName, strArgs;
                strFunName = matcher.group(2);
                
                if (!TextUtils.isEmpty(strFunName)) {
                    strFunName = Pattern.quote(strFunName);
                }
                
                strArgs = matcher.group(3);
                
                if (!TextUtils.isEmpty(strArgs)) {
                    String[] args = strArgs.split(",");
                    if (args.length == 1) {
                        innerFuncCall = String.format("(function %s\\(\\w+\\)\\{[^\\{]+\\})", strFunName);
                    } else {
                        innerFuncCall = String.format("(function %s\\(", strFunName);
                        for (int i = 0; i < args.length - 1; ++i) {
                            innerFuncCall += "\\w+,";
                        }
                        innerFuncCall += "\\w+\\)\\{[^\\{]+\\})";
                    }
                }
                
                if (!TextUtils.isEmpty(innerFuncCall)) {

                    String f1def = getRegexString(jsContent, innerFuncCall);
                    functionSb.append(f1def);
                    functionSb.append("\n");
                }
            }

        }
        
        functionSb.append(jsfunction);
    }
	
	public static String getRegexString(String content, String pattern) {
        
		Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(content);
        String group = null;
        
        if (matcher.find()) {
            group = matcher.group(1);
        }
        
        return group;
        
	}
}