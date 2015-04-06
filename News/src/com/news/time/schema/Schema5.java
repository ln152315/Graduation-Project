package com.news.time.schema;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema5 extends SchemaModel {

	public String filter(String raw){
		Matcher mat1 = Pattern.compile("(([0-9]{4}年)|([0-9]{1,2}月)|([0-9]{1,2}日))+").matcher(raw);
		String part1 ="";
		if(mat1.find()){
			part1 = mat1.group(0);
		}
		Matcher mat2 = Pattern.compile("(([0-9]{1,2}点)|([0-9]{1,2}时))+(([0-9]{1,2}分)|([0-9]{1,2}秒))*").matcher(raw);
		String part2="";
		if(mat2.find()){
			part2 = mat2.group(0);
		}
		raw = part1+part2;
		return raw;
		
	}
	@Override
	public Date solve(Date created, String raw) {
		raw = raw.replace("号", "日");
		raw = raw.replace("点", "时");
		raw = raw.replace("半", "30分");
		Date date = null;
		raw = filter(raw);
		Boolean[] tags= {false,false,false,true,false,false};
		if(raw.contains("年"))tags[0]=true;
		if(raw.contains("月"))tags[1]=true;
		if(raw.contains("日"))tags[2]=true;
		if(raw.contains("分"))tags[4]=true;
		if(raw.contains("秒"))tags[5]=true;
		if(tags[4]&&tags[5]){
			String base = "H时m分s秒";
			date = add(base,tags,raw,created);
		}else if(tags[4]&&(!tags[5])){
			String base = "H时m分";
			date = add(base,tags,raw,created);
		}else if((!tags[4])&&(!tags[5])){
			String base = "H时";
			date = add(base,tags,raw,created);
		}
		return date;
	}
	
	@SuppressWarnings("deprecation")
	public Date add(String base,Boolean[] tags,String raw,Date created){
		Date date = null;
		if(tags[0]&&tags[1]&&tags[2]){
			if((raw.indexOf("年")<raw.indexOf("月"))&&(raw.indexOf("月")<raw.indexOf("日")))
			date= new Utils().trans("y年M月d日"+base, raw);
		}else if((!tags[0])&&tags[1]&&tags[2]){
			if(raw.indexOf("月")<raw.indexOf("日")){
			date= new Utils().trans("M月d日"+base, raw);
			date.setYear(created.getYear());
			}
		}else if((!tags[0])&&(!tags[1])&&tags[2]){
			date= new Utils().trans("d日"+base, raw);
			date.setYear(created.getYear());
			date.setMonth(created.getMonth());
		}else if((!tags[0])&&(!tags[1])&&(!tags[2])){
			date= new Utils().trans(base, raw);
			date.setYear(created.getYear());
			date.setMonth(created.getMonth());
			date.setDate(created.getDate());
		}
		return date;
	}

	
	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("(([0-9]{4}年)|([0-9]{1,2}月)|([0-9]{1,2}[日号]+)){0,3}\\W*(([0-9]{1,2}点)|([0-9]{1,2}时))半?+(([0-9]{1,2}分)|([0-9]{1,2}秒))*");
		return pattern;
	}

}
