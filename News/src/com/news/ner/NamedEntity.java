package com.news.ner;

import java.util.Map;

import bupt.sse.ner.NERTagger;

public class NamedEntity {
//	private static String model = "C:\\xinhua\\apache-tomcat-6.0.43\\webapps\\News\\model\\crfmodel";
	private static String model = "F:\\Myeclipse\\workspace\\News\\WebRoot\\model\\crfmodel";
	private static NERTagger nerTagger ;
	private static boolean isInit=false;
	public NamedEntity(){
		if(!isInit){
			nerTagger = new NERTagger(model);
		}
	}
	
	public static Map<String, String> NamedEntityExtract(String text){
		return nerTagger.tag(text);
	}
	
}
