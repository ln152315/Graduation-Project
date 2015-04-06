package com.news.time.schema;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema5 extends SchemaModel {

	public String filter(String raw){
		Matcher mat1 = Pattern.compile("(([0-9]{4}��)|([0-9]{1,2}��)|([0-9]{1,2}��))+").matcher(raw);
		String part1 ="";
		if(mat1.find()){
			part1 = mat1.group(0);
		}
		Matcher mat2 = Pattern.compile("(([0-9]{1,2}��)|([0-9]{1,2}ʱ))+(([0-9]{1,2}��)|([0-9]{1,2}��))*").matcher(raw);
		String part2="";
		if(mat2.find()){
			part2 = mat2.group(0);
		}
		raw = part1+part2;
		return raw;
		
	}
	@Override
	public Date solve(Date created, String raw) {
		raw = raw.replace("��", "��");
		raw = raw.replace("��", "ʱ");
		raw = raw.replace("��", "30��");
		Date date = null;
		raw = filter(raw);
		Boolean[] tags= {false,false,false,true,false,false};
		if(raw.contains("��"))tags[0]=true;
		if(raw.contains("��"))tags[1]=true;
		if(raw.contains("��"))tags[2]=true;
		if(raw.contains("��"))tags[4]=true;
		if(raw.contains("��"))tags[5]=true;
		if(tags[4]&&tags[5]){
			String base = "Hʱm��s��";
			date = add(base,tags,raw,created);
		}else if(tags[4]&&(!tags[5])){
			String base = "Hʱm��";
			date = add(base,tags,raw,created);
		}else if((!tags[4])&&(!tags[5])){
			String base = "Hʱ";
			date = add(base,tags,raw,created);
		}
		return date;
	}
	
	@SuppressWarnings("deprecation")
	public Date add(String base,Boolean[] tags,String raw,Date created){
		Date date = null;
		if(tags[0]&&tags[1]&&tags[2]){
			if((raw.indexOf("��")<raw.indexOf("��"))&&(raw.indexOf("��")<raw.indexOf("��")))
			date= new Utils().trans("y��M��d��"+base, raw);
		}else if((!tags[0])&&tags[1]&&tags[2]){
			if(raw.indexOf("��")<raw.indexOf("��")){
			date= new Utils().trans("M��d��"+base, raw);
			date.setYear(created.getYear());
			}
		}else if((!tags[0])&&(!tags[1])&&tags[2]){
			date= new Utils().trans("d��"+base, raw);
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
		Pattern pattern = Pattern.compile("(([0-9]{4}��)|([0-9]{1,2}��)|([0-9]{1,2}[�պ�]+)){0,3}\\W*(([0-9]{1,2}��)|([0-9]{1,2}ʱ))��?+(([0-9]{1,2}��)|([0-9]{1,2}��))*");
		return pattern;
	}

}
