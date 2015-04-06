package com.news.time.schema;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Schema7 extends SchemaModel {
	public String[] split(String sentence,String token){
		if(token.equals(".")){
			token ="\\.";
		}
		String[] array= sentence.split(token);
		return array;
	}
	public String replaceToken(String raw){
		Matcher mat =Pattern.compile("[0-9]{4}([\\s/.。-])[0-9]{1,2}[\\s/.。-][0-9]{1,2}").matcher(raw);
		if(mat.find()){
			String res = mat.group(0);
			String token = mat.group(1);
			String[] array= split(res,token);
			String temp =array[0]+"年"+array[1]+"月"+array[2]+"日";
			raw = raw.replace(res,temp);
		}else{
			mat =Pattern.compile("[0-9]{4}([\\s/.。-])[0-9]{1,2}").matcher(raw);
			if(mat.find()){
				String res = mat.group(0);
				String token = mat.group(1);
				String[] array= split(res,token);
				String temp =array[0]+"年"+array[1]+"月";
				raw = raw.replace(res,temp);
			}else{
				mat =Pattern.compile("[0-9]{1,2}([\\s/.。-])[0-9]{1,2}").matcher(raw);
				if(mat.find()){
					String res = mat.group(0);
					String token = mat.group(1);
					String[] array= split(res,token);
					String temp =array[0]+"月"+array[1]+"日";
					raw = raw.replace(res,temp);
				}
			}
		}
		mat =Pattern.compile("[0-9]{1,2}[：:][0-9]{1,2}[：:][0-9]{1,2}").matcher(raw);
		if(mat.find()){
			String res = mat.group(0);
			String temp = res.replace("：", ":");
			String[] array = split(temp,":");
			temp = array[0]+"时"+array[1]+"分"+array[2]+"秒";
			raw = raw.replace(res,temp);
			
		}else{
			mat =Pattern.compile("[0-9]{1,2}[：:][0-9]{1,2}").matcher(raw);
			if(mat.find()){
				String res = mat.group(0);
				String temp = res.replace("：", ":");
				temp = temp.replace(":", "时");
				temp += "分";
				raw = raw.replace(res,temp);
			}
			
		}
		return raw;
	}

	@Override
	public Date solve(Date created, String raw) {
		Date date = null;
		raw = replaceToken(raw);
		if(raw.matches("[\\w\\W]*([0-9]{1,2}[时点])(([0-9]{1,2}分)|([0-9]{1,2}秒))*[\\w\\W]*")){
			SchemaModel sm = new Schema5();
			date = sm.process(raw,created);
		}else{
			SchemaModel sm = new Schema4();
			date = sm.process(raw,created);
		}
		return date;
	}

	@Override
	public Pattern init() {
		String all = "(([0-9]{4}[\\s/.。-][0-9]{1,2}([\\s/.。-][0-9]{1,2})?)|([0-9]{1,2}[\\s/.。-][0-9]{1,2}))+\\W*[0-9]{1,2}[：:][0-9]{1,2}([：:][0-9]{1,2})?";
		String part1 ="(([0-9]{4}[\\s/.。-][0-9]{1,2}([\\s/.。-][0-9]{1,2})?)|([0-9]{1,2}[\\s/.。-][0-9]{1,2}))+[\\w\\W]*";
		String part2 ="[\\w\\W]*[0-9]{1,2}([：:][0-9]{1,2})+";
		String reg ="("+"("+all+")|"+"("+part1+")|"+"("+part2+")"+")?";
		Pattern pattern = Pattern.compile(reg);
		return pattern;
	}

}
