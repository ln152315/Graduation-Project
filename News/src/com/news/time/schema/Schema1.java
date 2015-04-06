package com.news.time.schema;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema1 extends SchemaModel {
 
	@SuppressWarnings("deprecation")
	public Date accurateTime(Date date,int num,Boolean after,String raw,Date created){
		if(raw.contains("月")){
			if(after){
				date.setMonth(created.getMonth()+num);
			}else{
				date.setMonth(created.getMonth()-num);
			}
		}else if(raw.contains("日")||raw.contains("天")){
			if(after){
				date.setDate(created.getDate()+num);
			}else{
				date.setDate(created.getDate()-num);
			}
		}else if(raw.contains("小时")){
			if(after){
				date.setHours(created.getHours()+num);
			}else{
				date.setHours(created.getHours()-num);
			}
		}else if(raw.contains("分钟")){
			if(after){
				date.setMinutes(created.getMinutes()+num);
			}else{
				date.setMinutes(created.getMinutes()-num);
			}
		}else if(raw.contains("秒")){
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
		if(raw.contains("后")){
			after = true; 
		}
		if(raw.contains("月")){
			date = new Utils().trans("yyyy年",new Utils().revese("yyyy年", created));
		}else if(raw.contains("日")||raw.contains("天")){
			date = new Utils().trans("yyyy年MM月",new Utils().revese("yyyy年MM月", created));
		}else if(raw.contains("小时")){
			date = new Utils().trans("yyyy年MM月dd日",new Utils().revese("yyyy年MM月dd日", created));
		}else if(raw.contains("分钟")){
			date = new Utils().trans("yyyy年MM月dd日 HH",new Utils().revese("yyyy年MM月dd日 HH", created));
		}else if(raw.contains("秒")){
			date = new Utils().trans("yyyy年MM月dd日 HH::mm",new Utils().revese("yyyy年MM月dd日 HH::mm", created));
		}
		
		if(!raw.contains("几")){
			Matcher mat= Pattern.compile("([0-9]+)个?(月|日|天|小时|分钟|秒|秒钟)之?[前后]").matcher(raw);
			if(mat.find()){
				String str = mat.group(1);
				int num = Integer.parseInt(str);
				date = accurateTime(date,num,after,raw,created);
			}
			mat= Pattern.compile("([一二三四五六七八九十百〇零]+)个?(月|日|天|小时|分钟|秒|秒钟)之?[前后]").matcher(raw);
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
		Pattern pattern = Pattern.compile("(([0-9]+)|([一二三四五六七八九十百〇零]+)|(几))个?(月|日|天|小时|分钟|秒|秒钟)之?[前后]");
		return pattern;
	}

}
