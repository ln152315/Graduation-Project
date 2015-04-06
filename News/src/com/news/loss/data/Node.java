package com.news.loss.data;

import java.util.logging.Level;

public class Node {
	private int quantity =0;//��ʧ����
	private String text = "";//��ȡ�ı�
	private int property = 0;//��ʧ����  1����or2����
	private boolean isIncrease = false;//�Ƿ�����
	private boolean isDecrease = false;//�Ƿ����
	private int level=0;//����
	private int startPos = 0;//��ʼλ��
	private int endPos = 0;//����λ��
	
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
