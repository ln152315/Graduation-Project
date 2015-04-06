package com.news.loss.lexicon;

public class StopWordsHandler {
	private static String stopWordsList[]={"的","我们","要","自己","之","将","后",
		"应","到","某","后","个","是","位","新","一","两","在","中","或","有","楷体","隶书","更","好","宋体"};
	public static boolean isStopWord(String word){
		for(int i=0;i<stopWordsList.length;i++){
			if(word.equalsIgnoreCase(stopWordsList[i]))
				return true;
		}
		return false;
	}
	
}
