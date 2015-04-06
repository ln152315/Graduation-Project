package com.news.time.schema;

import java.util.Date;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema2 extends SchemaModel {

	@Override
	public Date solve(Date created, String raw) {
		Date date = new Date();
		if(raw.matches("[\\w\\W]*近日[\\w\\W]*")){
			date = new Utils().trans("yyyy年MM月",new Utils().revese("yyyy年MM月", created));
		}else if(raw.matches("[\\w\\W]*近几个月[\\w\\W]*")){
			date = new Utils().trans("yyyy年",new Utils().revese("yyyy年", created));
		}
		return date;
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("(近日|近几个月)+");
		return pattern;
	}

}
