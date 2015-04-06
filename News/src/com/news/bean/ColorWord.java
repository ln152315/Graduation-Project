package com.news.bean;

public class ColorWord {
	private String word;
	private String color ;
	
	public ColorWord(){
		
	}
	
	public ColorWord(String word,String color){
		this.word=word;
		this.color = color;
	}
	
	public String getWord(){
		return this.word;
	}
	
	public void setWord(String word){
		this.word = word;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
}
