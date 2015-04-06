package com.news.lexicon;

public class StopWordsHandler {
	private static String stopWordsList[]={"的", "了", "在", "是", "我", "有", "和", "就",  
        "不", "人", "都", "一", "一个", "上", "也", "很", "到", "说", "要", "去", "你",  
        "会", "着", "没有", "看", "好", "自己", "这"};
	public static boolean isStopWord(String word){
		for(int i=0;i<stopWordsList.length;i++){
			if(word.equalsIgnoreCase(stopWordsList[i]))
				return true;
		}
		return false;
	}
	
}
