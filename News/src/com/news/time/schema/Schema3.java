package com.news.time.schema;

import java.util.Date;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema3 extends SchemaModel {

	@SuppressWarnings("deprecation")
	@Override
	public Date solve(Date created, String raw) {
		Date date = null;
		date = new Utils().trans("yyyy��",new Utils().revese("yyyy��", created));
		if(raw.matches("�ϸ�?��")){
			date.setMonth(created.getMonth()-1);
		}else if(raw.matches("�¸�?��")){
			date.setMonth(created.getMonth()+1);
		}else if(raw.matches("����")){
			date.setMonth(created.getMonth());
		}else if(raw.matches("ȥ��")){
			date.setYear(created.getYear()-1);
		}else if(raw.matches("ǰ��")){
			date.setYear(created.getYear()-2);
		}else if(raw.matches("����")){
			date.setYear(created.getYear()+1);
		}else if(raw.matches("����")){
			date.setYear(created.getYear());
		}
		return date;
		
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("((�ϸ�?��)|(�¸�?��)|(����)|(ȥ��)|(ǰ��)|(����)|(����))+");
		return pattern;
	}

}
