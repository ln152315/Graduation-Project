package com.news.lexicon;

public class StopWordsHandler {
	private static String stopWordsList[]={"��", "��", "��", "��", "��", "��", "��", "��",  
        "��", "��", "��", "һ", "һ��", "��", "Ҳ", "��", "��", "˵", "Ҫ", "ȥ", "��",  
        "��", "��", "û��", "��", "��", "�Լ�", "��"};
	public static boolean isStopWord(String word){
		for(int i=0;i<stopWordsList.length;i++){
			if(word.equalsIgnoreCase(stopWordsList[i]))
				return true;
		}
		return false;
	}
	
}
