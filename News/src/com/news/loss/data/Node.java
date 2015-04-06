package com.news.loss.data;

import java.util.logging.Level;

public class Node {
	private int quantity =0;//损失数量
	private String text = "";//抽取文本
	private int property = 0;//损失类型  1死亡or2受伤
	private boolean isIncrease = false;//是否增加
	private boolean isDecrease = false;//是否减少
	private int level=0;//级别
	private int startPos = 0;//开始位置
	private int endPos = 0;//结束位置
	
	public Node(){
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public int getProperty(){
		return this.property;
	}
	
	public String getText(){
		return this.text;
	}
	
	public boolean getIsIncrease(){
		return this.isIncrease;
	}
	
	public boolean getIsDecrease(){
		return this.isDecrease;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public int getStartPos(){
		return this.startPos;
	}
	
	public int getEndPos(){
		return this.endPos;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public void setStartPos(int startPos){
		this.startPos=startPos;
	}
	
	public void setEndPos(int endPos){
		this.endPos=endPos;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public void setProperty(int property){
		this.property = property;
	}
	
	public void setIsIncrease(boolean isIncrease){
		this.isIncrease = isIncrease;
	}
	
	public void setIsDecrease(boolean isDecrease){
		this.isDecrease = isDecrease;
	}
}
