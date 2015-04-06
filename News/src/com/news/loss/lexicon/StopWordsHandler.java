package com.news.loss.lexicon;

public class StopWordsHandler {
	private static String stopWordsList[]={"��","����","Ҫ","�Լ�","֮","��","��",
		"Ӧ","��","ĳ","��","��","��","λ","��","һ","��","��","��","��","��","����","����","��","��","����"};
	public static boolean isStopWord(String word){
		for(int i=0;i<stopWordsList.length;i++){
			if(word.equalsIgnoreCase(stopWordsList[i]))
				return true;
		}
		return false;
	}
	
}
