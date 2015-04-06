package com.news.loss.schema;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.loss.data.Loss;
import com.news.loss.data.Node;
import com.news.loss.util.Calculate;
import com.news.loss.util.LossRegex;

public abstract class SchemaModel {
	private ArrayList<Node> nodes;
	private Loss loss;
	
	//模式初始化
	public abstract Pattern init();
	//信息抽取
	public abstract Node extractInfo(String raw,int start, int end);
	//信息匹配
	public Loss matchInfo(String sentence){
		nodes = new ArrayList<Node>();
		Pattern pattern = init();
		Matcher matcher = pattern.matcher(sentence);
		while(matcher.find()){
			String raw = matcher.group(0);
			
			nodes.add(extractInfo(raw,matcher.start(),matcher.end())) ;
		}
		System.out.println(sentence);
		LossRegex.nodesLevelHandler(nodes, sentence);
		
		for(int i=0;i<nodes.size();i++){
			System.out.println(nodes.get(i).getQuantity()+"    "+nodes.get(i).getLevel());
		}
		
		loss=Calculate.calculate(nodes);
		
		return this.loss;
	}
	
	
}
