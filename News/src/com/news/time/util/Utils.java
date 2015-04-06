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
		char[][] map ={{'һ','1'},{'��','2'},{'��','3'},{'��','4'},{'��','5'},{'��','6'},
				{'��','7'},{'��','8'},{'��','9'}};
		for(int i=0;i<map.length;i++){
			if(CN == map[i][0]){
				return map[i][1]-'0';
			}
		}
		//���������ߡ��㡰
		return 0;
	}
	public int parseCN(String CN){
		int[] num = {0,0,0};
		if(CN.startsWith("ʮ")||CN.startsWith("��")){
			CN ="һ"+CN;
		}
		if(CN.contains("��")){
			CN = CN.substring(0,CN.indexOf("��")+1)+"ʮ"+ CN.substring(CN.indexOf("��")+1,CN.length());
		}
		if(CN.contains("��")){
			CN = CN.substring(0,CN.indexOf("��")+1)+"ʮ"+ CN.substring(CN.indexOf("��")+1,CN.length());
		}
		if(CN.contains("��"))
			num[0]=map(CN.charAt(CN.indexOf("��")-1));
		if(CN.contains("ʮ"))
			num[1]=map(CN.charAt(CN.indexOf("ʮ")-1));
		if(!CN.endsWith("ʮ"))
			num[2]=map(CN.charAt(CN.length()-1));
		return num[0]*100+num[1]*10+num[2];
	}
}
