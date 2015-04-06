package com.news.time.schema;

import java.util.Date;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema2 extends SchemaModel {

	@Override
	public Date solve(Date created, String raw) {
		Date date = new Date();
		if(raw.matches("[\\w\\W]*����[\\w\\W]*")){
			date = new Utils().trans("yyyy��MM��",new Utils().revese("yyyy��MM��", created));
		}else if(raw.matches("[\\w\\W]*��������[\\w\\W]*")){
			date = new Utils().trans("yyyy��",new Utils().revese("yyyy��", created));
		}
		return date;
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("(����|��������)+");
		return pattern;
	}

}
