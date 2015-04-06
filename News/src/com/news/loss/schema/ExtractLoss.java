package com.news.loss.schema;

import com.news.loss.data.Loss;

public class ExtractLoss {

	
	public static Loss determine(String sentence){
		int SchemaNum = 2;
		Loss loss = null;
		for(int i=2;i<=SchemaNum;i++){
			String className= "com.news.loss.schema.Schema"+i;
			try {
				SchemaModel sm =(SchemaModel)Class.forName(className).newInstance();
				Loss temp =sm.matchInfo(sentence);
				if(temp!=null)
					loss = temp;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		};
		return loss;
	}

}
