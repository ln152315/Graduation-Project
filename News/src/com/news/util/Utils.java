package com.news.util;

public class Utils {
	
	public static String wordTypeToColor(String type){
		
		if(type.startsWith("n")){
			//return "#488fce";
			return "n";
		}
		else if (type.startsWith("v")){
		//	return "#ffcb99";
			return "v";
		}
		else if (type.startsWith("a")){
		//	return "#67ccaa";
			return "a";
		}
		else if (type.startsWith("ad")){
		//	return "#ffcccb";
			return "d";
		}
		else if (type.startsWith("m")){
			//	return "#ffcccb";
			return "m";
		}
		else if (type.startsWith("p")){
			//	return "#ffcccb";
			return "p";
		}
		else if (type.startsWith("f")){
			//	return "#ffcccb";
			return "f";
		}
		else if (type.startsWith("r")){
			//	return "#ffcccb";
			return "r";
		}
		else if (type.startsWith("w")){
			//	return "#ffcccb";
			return "y";
		}
		else {
		//	return "#ccc";
			return "w";
		}
		
		
	}
	
	public static String wordTypeToNerColor(String type){
		
		if(type.startsWith("zz")){
			//return "#488fce";
			return "n";
		}
		
		else {
		//	return "#ccc";
			return "w";
		}
		
		
	}
	
	
public static String wordTypeToSenColor(String type){
		
		if(type.startsWith("zsa")){
			//return "#488fce";
			return "n";
		}
		else if (type.startsWith("zsb")){
		//	return "#ffcb99";
			return "v";
		}
		else if (type.startsWith("zsc")){
		//	return "#67ccaa";
			return "a";
		}
		else if (type.startsWith("zsd")){
		//	return "#ffcccb";
			return "d";
		}
		else if (type.startsWith("zse")){
			//	return "#ffcccb";
			return "m";
		}
		else if (type.startsWith("zsf")){
			//	return "#ffcccb";
			return "p";
		}
		else if (type.startsWith("zsg")){
			//	return "#ffcccb";
			return "f";
		}
		else {
		//	return "#ccc";
			return "w";
		}
		
		
	}
}
