package com.news.time.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public Date trans(String format,String raw){
		Date date = null;
		SimpleDateFormat formater = new SimpleDateFormat(format);
		try{
			date = formater.parse(raw);
		}catch (ParseException e){
			e.printStackTrace();
		}
		return date;
	}
	public String revese(String format,Date date){
		return new SimpleDateFormat(format).format(date);
	}
	public int map(char CN){
		char[][] map ={{'一','1'},{'二','2'},{'三','3'},{'四','4'},{'五','5'},{'六','6'},
				{'七','7'},{'八','8'},{'九','9'}};
		for(int i=0;i<map.length;i++){
			if(CN == map[i][0]){
				return map[i][1]-'0';
			}
		}
		//”〇“或者”零“
		return 0;
	}
	public int parseCN(String CN){
		int[] num = {0,0,0};
		if(CN.startsWith("十")||CN.startsWith("百")){
			CN ="一"+CN;
		}
		if(CN.contains("〇")){
			CN = CN.substring(0,CN.indexOf("〇")+1)+"十"+ CN.substring(CN.indexOf("〇")+1,CN.length());
		}
		if(CN.contains("零")){
			CN = CN.substring(0,CN.indexOf("零")+1)+"十"+ CN.substring(CN.indexOf("零")+1,CN.length());
		}
		if(CN.contains("百"))
			num[0]=map(CN.charAt(CN.indexOf("百")-1));
		if(CN.contains("十"))
			num[1]=map(CN.charAt(CN.indexOf("十")-1));
		if(!CN.endsWith("十"))
			num[2]=map(CN.charAt(CN.length()-1));
		return num[0]*100+num[1]*10+num[2];
	}
}
