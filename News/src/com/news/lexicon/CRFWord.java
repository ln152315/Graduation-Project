package com.news.lexicon;

//切词处理后，单词类
public class CRFWord {
	private String word = "";
	private String word_type = "";
	private String word_tag = "";
	
	public CRFWord(){		
	}
	
	public CRFWord(String word, String word_type, String word_tag){		
		this.word = word;
		this.word_type = word_type;
		this.word_tag = word_tag;
	}
	
	public String getCRFWord(){
		return word;
	}
	
	public String getCRFWord_type(){
		return word_type;
	}
	
	public String getCRFWord_tag(){
		return word_tag;
	}
	
	public void setCRFWord(String word){
		this.word=word;
	}
	
	public void setCRFWord_type(String word_type){
		this.word_type=word_type;
	}
	
	public void setCRFWord_tag(String word_tag){
		this.word_tag=word_tag;
	}
	
}
