package com.news.lexicon;

//切词处理后，单词类
public class Word {
	private String word = "";
	private String word_type = "";
	
	public Word(){		
	}
	
	public Word(String word, String word_type){		
		this.word = word;
		this.word_type = word_type;
	}
	
	public String getWord(){
		return word;
	}
	
	public String getWord_type(){
		return word_type;
	}
	
	public void setWord(String word){
		this.word=word;
	}
	
	public void setWord_type(String word_type){
		this.word_type=word_type;
	}
	
}
