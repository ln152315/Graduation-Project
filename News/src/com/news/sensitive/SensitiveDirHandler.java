package com.news.sensitive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SensitiveDirHandler {
	private static String sensitivePath = "F:\\Myeclipse\\workspace\\News\\WebRoot\\model\\sensitivedir.txt";
	private static HashMap<String, Double> sen_Map = null;
	private static boolean isInit = false;
	
	private static HashMap<String, Double> textToArray(String path){
		
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		try {
			FileReader read = new FileReader(path);
			BufferedReader br = new BufferedReader(read);
			String str = "";
			
			try {
				while((str = br.readLine())!=null){
					String strArray[] =str.split("\t");
			//		System.out.println(strArray.length);
			//		for(int o=0;o<strArray.length;o++){
			//			System.out.println(strArray[o]);
			//		}
				//	arrayOfString.add(strMoodScore);
					map.put(strArray[0], Double.parseDouble(strArray[1]));
				}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return map;
		
		
	}
	
	public SensitiveDirHandler(){
		if(!isInit)init();
	}
	
	private static void init() {
		if(isInit)return;		
		sen_Map=textToArray(sensitivePath);	
		isInit = true;
		
	}
	
	public static HashMap<String, Double> getSen_map() {
		return sen_Map;
	}

	public static void setSen_map(HashMap<String, Double> sen_Map) {
		SensitiveDirHandler.sen_Map = sen_Map;
	}
}
