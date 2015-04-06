package com.news.time.schema;

import java.util.Date;
import java.util.regex.Pattern;

import com.news.time.util.Utils;

public class Schema4 extends SchemaModel{
	
	@Override
	public Pattern init(){
		Pattern pattern = Pattern.compile("(([0-9]{4}��)|([0-9]{1,2}��)|([0-9]{1,2}[�պ�]))+");
		return pattern;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Date solve(Date created,String raw) {
		Date date = null;
		//replace the word with same meaning
		raw = raw.replace("��", "��");
		Boolean[] tags= {false,false,false};
		if(raw.contains("��"))tags[0]=true;
		if(raw.contains("��"))tags[1]=true;
		if(raw.contains("��"))tags[2]=true;
		
		//Classified discussion
		if(tags[0]&&tags[1]&&tags[2]){
			if((raw.indexOf("��")<raw.indexOf("��"))&&(raw.indexOf("��")<raw.indexOf("��")))
			date = new Utils().trans("y��M��d��", raw);
		}else if((!tags[0])&&tags[1]&&tags[2]){
			if(raw.indexOf("��")<raw.indexOf("��")){
			date = new Utils().trans("M��d��", raw);
			date.setYear(created.getYear());
			}
		}else if((!tags[0])&&(!tags[1])&&tags[2]){
			date = new Utils().trans("d��", raw);
			date.setYear(created.getYear());
			date.setMonth(created.getMonth());
		}else if(tags[0]&&(!tags[1])&&(!tags[2])){
			date = new Utils().trans("y��", raw);
		}else if(tags[0]&&tags[1]&&(!tags[2])){
			if(raw.indexOf("��")<raw.indexOf("��")){
			date = new Utils().trans("y��M��", raw);
			}
		}else if((!tags[0])&&tags[1]&&(!tags[2])){
			date = new Utils().trans("M��", raw);
			date.setYear(created.getYear());
		}
		return date;
	}


	
}
