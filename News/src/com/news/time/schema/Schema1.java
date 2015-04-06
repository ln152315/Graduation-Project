package com.news.time.schema;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema1 extends SchemaModel {
 
	@SuppressWarnings("deprecation")
	public Date accurateTime(Date date,int num,Boolean after,String raw,Date created){
		if(raw.contains("��")){
			if(after){
				date.setMonth(created.getMonth()+num);
			}else{
				date.setMonth(created.getMonth()-num);
			}
		}else if(raw.contains("��")||raw.contains("��")){
			if(after){
				date.setDate(created.getDate()+num);
			}else{
				date.setDate(created.getDate()-num);
			}
		}else if(raw.contains("Сʱ")){
			if(after){
				date.setHours(created.getHours()+num);
			}else{
				date.setHours(created.getHours()-num);
			}
		}else if(raw.contains("����")){
			if(after){
				date.setMinutes(created.getMinutes()+num);
			}else{
				date.setMinutes(created.getMinutes()-num);
			}
		}else if(raw.contains("��")){
			if(after){
				date.setSeconds(created.getSeconds()+num);
			}else{
				date.setSeconds(created.getSeconds()-num);
			}
		}
		return date;
	}
	@Override
	public Date solve(Date created, String raw) {
		Date date = null;
		Boolean after = false;
		if(raw.contains("��")){
			after = true; 
		}
		if(raw.contains("��")){
			date = new Utils().trans("yyyy��",new Utils().revese("yyyy��", created));
		}else if(raw.contains("��")||raw.contains("��")){
			date = new Utils().trans("yyyy��MM��",new Utils().revese("yyyy��MM��", created));
		}else if(raw.contains("Сʱ")){
			date = new Utils().trans("yyyy��MM��dd��",new Utils().revese("yyyy��MM��dd��", created));
		}else if(raw.contains("����")){
			date = new Utils().trans("yyyy��MM��dd�� HH",new Utils().revese("yyyy��MM��dd�� HH", created));
		}else if(raw.contains("��")){
			date = new Utils().trans("yyyy��MM��dd�� HH::mm",new Utils().revese("yyyy��MM��dd�� HH::mm", created));
		}
		
		if(!raw.contains("��")){
			Matcher mat= Pattern.compile("([0-9]+)��?(��|��|��|Сʱ|����|��|����)֮?[ǰ��]").matcher(raw);
			if(mat.find()){
				String str = mat.group(1);
				int num = Integer.parseInt(str);
				date = accurateTime(date,num,after,raw,created);
			}
			mat= Pattern.compile("([һ�����������߰˾�ʮ�٩���]+)��?(��|��|��|Сʱ|����|��|����)֮?[ǰ��]").matcher(raw);
			if(mat.find()){
				String str = mat.group(1);
				int num = new Utils().parseCN(str);
				date = accurateTime(date,num,after,raw,created);
			}
		}
		return date;
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("(([0-9]+)|([һ�����������߰˾�ʮ�٩���]+)|(��))��?(��|��|��|Сʱ|����|��|����)֮?[ǰ��]");
		return pattern;
	}

}
