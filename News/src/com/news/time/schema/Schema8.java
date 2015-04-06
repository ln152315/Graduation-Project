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
		Matcher mat =Pattern.compile("([0-9]{1,2})([��:��ʱ]([0-9]{1,2})?([��:��])?([0-9]{1,2})?)").matcher(raw);
		if(mat.find()){
			flag = true;
			time = mat.group(0);
			if(raw.matches("[\\w\\W]*((����)|(����)|(���)|(����))+[\\w\\W]*")){
				String temp1 = mat.group(1);
				String temp2 = mat.group(2);
				int i = Integer.parseInt(temp1);
				if(i<13)
					i += 12;
				String temp = i+temp2;
				raw = raw.replace(mat.group(0), temp);
			}
		}
		mat= Pattern.compile("[������ǰ��][����]").matcher(raw);
		if(mat.find()){
			date = new Utils().trans("yyyy��MM��",new Utils().revese("yyyy��MM��", created));
			String key = mat.group(0);
			if(key.equals("����")||key.equals("����")){
				date.setDate(created.getDate());
			}else if(key.equals("����")||key.equals("����")){
				date.setDate(created.getDate()-1);
			}else if(key.equals("ǰ��")){
				date.setDate(created.getDate()-2);
			}else if(key.equals("����")||key.equals("����")){
				date.setDate(created.getDate()+1);
			}else if(key.equals("����")){
				date.setDate(created.getDate()+2);
			}
			raw = raw.replace(key,new Utils().revese("yyyy��MM��dd��",date));
		}else{
			if(raw.matches("[\\w\\W]*((����)|(����)|(���)|(����)|(����)|(�峿)|(����)|(ҹ��)|(�賿))+[\\w\\W]*")){
				raw = new Utils().revese("yyyy��MM��dd��", created)+ raw;
			}
		}
		if(flag){
			if(time.contains(":")||time.contains("��")){
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
		Pattern pattern = Pattern.compile("[\\w\\W]*(([������ǰ��][����])|((����)|(����)|(���)|(����)|(����)|(�峿)|(����)|(ҹ��)|(�賿)))+[\\w\\W]*");
		return pattern;
	}

}
