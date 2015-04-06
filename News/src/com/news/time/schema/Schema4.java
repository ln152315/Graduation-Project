package com.news.time.schema;

import java.util.Date;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema4 extends SchemaModel{
	
	@Override
	public Pattern init(){
		Pattern pattern = Pattern.compile("(([0-9]{4}年)|([0-9]{1,2}月)|([0-9]{1,2}[日号]))+");
		return pattern;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Date solve(Date created,String raw) {
		Date date = null;
		//replace the word with same meaning
		raw = raw.replace("号", "日");
		Boolean[] tags= {false,false,false};
		if(raw.contains("年"))tags[0]=true;
		if(raw.contains("月"))tags[1]=true;
		if(raw.contains("日"))tags[2]=true;
		
		//Classified discussion
		if(tags[0]&&tags[1]&&tags[2]){
			if((raw.indexOf("年")<raw.indexOf("月"))&&(raw.indexOf("月")<raw.indexOf("日")))
			date = new Utils().trans("y年M月d日", raw);
		}else if((!tags[0])&&tags[1]&&tags[2]){
			if(raw.indexOf("月")<raw.indexOf("日")){
			date = new Utils().trans("M月d日", raw);
			date.setYear(created.getYear());
			}
		}else if((!tags[0])&&(!tags[1])&&tags[2]){
			date = new Utils().trans("d日", raw);
			date.setYear(created.getYear());
			date.setMonth(created.getMonth());
		}else if(tags[0]&&(!tags[1])&&(!tags[2])){
			date = new Utils().trans("y年", raw);
		}else if(tags[0]&&tags[1]&&(!tags[2])){
			if(raw.indexOf("年")<raw.indexOf("月")){
			date = new Utils().trans("y年M月", raw);
			}
		}else if((!tags[0])&&tags[1]&&(!tags[2])){
			date = new Utils().trans("M月", raw);
			date.setYear(created.getYear());
		}
		return date;
	}


	
}
