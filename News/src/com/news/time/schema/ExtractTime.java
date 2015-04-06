package com.news.time.schema;

import java.util.Date;

import com.news.time.util.Utils;

public class ExtractTime{
	public Date determine(String sentence,Date created){
		int SchemaNum = 8;
		Date date = null;
		for(int i=1;i<=SchemaNum;i++){
			String className= "com.news.time.schema.Schema"+i;
			try {
				SchemaModel sm =(SchemaModel)Class.forName(className).newInstance();
				Date temp =sm.process(sentence,created);
				if(temp!=null)
					date = temp;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		};
		return date;
	}

	

}
