package com.news.loss.data;

public class Loss {
	private int dead =0;
	private int injury = 0;
	
	public Loss(){
		
	}
	
	public int getDead(){
		return this.dead;
	}
	
	public int getInjury(){
		return this.injury;
	}
	
	public void setDead(int dead){
		this.dead = dead;
	}
	
	public void setInjury(int injury){
		this.injury = injury;
	}
}
