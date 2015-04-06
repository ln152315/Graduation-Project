package com.news.time.schema;

import java.util.Date;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema3 extends SchemaModel {

	@SuppressWarnings("deprecation")
	@Override
	public Date solve(Date created, String raw) {
		Date date = null;
		date = new Utils().trans("yyyy年",new Utils().revese("yyyy年", created));
		if(raw.matches("上个?月")){
			date.setMonth(created.getMonth()-1);
		}else if(raw.matches("下个?月")){
			date.setMonth(created.getMonth()+1);
		}else if(raw.matches("本月")){
			date.setMonth(created.getMonth());
		}else if(raw.matches("去年")){
			date.setYear(created.getYear()-1);
		}else if(raw.matches("前年")){
			date.setYear(created.getYear()-2);
		}else if(raw.matches("明年")){
			date.setYear(created.getYear()+1);
		}else if(raw.matches("今年")){
			date.setYear(created.getYear());
		}
		return date;
		
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("((上个?月)|(下个?月)|(本月)|(去年)|(前年)|(明年)|(今年))+");
		return pattern;
	}

}
