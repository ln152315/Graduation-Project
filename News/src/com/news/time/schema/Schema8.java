package com.news.time.schema;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema8 extends SchemaModel {

	@SuppressWarnings("deprecation")
	@Override
	public Date solve(Date created, String raw) {
		Date date= null;
		Boolean flag = false;
		String time ="";
		Matcher mat =Pattern.compile("([0-9]{1,2})([：:点时]([0-9]{1,2})?([：:分])?([0-9]{1,2})?)").matcher(raw);
		if(mat.find()){
			flag = true;
			time = mat.group(0);
			if(raw.matches("[\\w\\W]*((下午)|(傍晚)|(晚间)|(晚上))+[\\w\\W]*")){
				String temp1 = mat.group(1);
				String temp2 = mat.group(2);
				int i = Integer.parseInt(temp1);
				if(i<13)
					i += 12;
				String temp = i+temp2;
				raw = raw.replace(mat.group(0), temp);
			}
		}
		mat= Pattern.compile("[今明后前昨][天日]").matcher(raw);
		if(mat.find()){
			date = new Utils().trans("yyyy年MM月",new Utils().revese("yyyy年MM月", created));
			String key = mat.group(0);
			if(key.equals("今天")||key.equals("今日")){
				date.setDate(created.getDate());
			}else if(key.equals("昨天")||key.equals("昨日")){
				date.setDate(created.getDate()-1);
			}else if(key.equals("前天")){
				date.setDate(created.getDate()-2);
			}else if(key.equals("明天")||key.equals("明日")){
				date.setDate(created.getDate()+1);
			}else if(key.equals("后天")){
				date.setDate(created.getDate()+2);
			}
			raw = raw.replace(key,new Utils().revese("yyyy年MM月dd日",date));
		}else{
			if(raw.matches("[\\w\\W]*((下午)|(傍晚)|(晚间)|(晚上)|(上午)|(清晨)|(晨间)|(夜间)|(凌晨))+[\\w\\W]*")){
				raw = new Utils().revese("yyyy年MM月dd日", created)+ raw;
			}
		}
		if(flag){
			if(time.contains(":")||time.contains("：")){
				SchemaModel sm = new Schema7();
				date = sm.process(raw,created);
			}else{
				SchemaModel sm = new Schema5();
				date = sm.process(raw,created);
			}
			
		}else{
			SchemaModel sm = new Schema4();
			date = sm.process(raw,created);
		}
		return date;
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("[\\w\\W]*(([今明后前昨][天日])|((下午)|(傍晚)|(晚间)|(晚上)|(上午)|(清晨)|(晨间)|(夜间)|(凌晨)))+[\\w\\W]*");
		return pattern;
	}

}
