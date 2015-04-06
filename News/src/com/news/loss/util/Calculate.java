package com.news.loss.util;

import java.util.ArrayList;

import com.news.loss.data.Loss;
import com.news.loss.data.Node;

public class Calculate {
	
	//计算抽取结果
	public static Loss calculate(ArrayList<Node> nodes){
		Loss loss = new Loss();
		loss.setDead(calculateDead(nodes));
		loss.setInjury(calculateInjury(nodes));
		return loss;
		
	}
	
	//计算死亡数字
	private static int calculateDead(ArrayList<Node> nodes){
		int levelTmp=0;
		int quantityTmp=0;
		for(int i=0;i<nodes.size();i++){
			if(nodes.get(i).getProperty()==1){
				if(nodes.get(i).getLevel()>levelTmp){
					levelTmp=nodes.get(i).getLevel();
					quantityTmp = nodes.get(i).getQuantity();
				}
				else if(nodes.get(i).getLevel()==levelTmp){
					quantityTmp += nodes.get(i).getQuantity();
				}
				else {
					continue;
				}
			}
		}
		return quantityTmp;
		
	}
	
	//计算受伤数字
	private static int calculateInjury(ArrayList<Node> nodes){
		int levelTmp=0;
		int quantityTmp=0;
		for(int i=0;i<nodes.size();i++){
			if(nodes.get(i).getProperty()==2){
				if(nodes.get(i).getLevel()>levelTmp){
					levelTmp=nodes.get(i).getLevel();
					quantityTmp = nodes.get(i).getQuantity();
				}
				else if(nodes.get(i).getLevel()==levelTmp){
					quantityTmp += nodes.get(i).getQuantity();
				}
				else {
					continue;
				}
			}
		}
		return quantityTmp;
		
	}	
}
