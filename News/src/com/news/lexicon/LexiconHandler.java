package com.news.lexicon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.news.bean.ColorWord;
import com.news.sensitive.SensitiveDirHandler;
import com.news.util.Utils;

import ICTCLAS.I3S.AC.ICTCLAS50;

public class LexiconHandler {
	public static boolean isInit = false;
	private static String argu = ".";
	private static ICTCLAS50 testICTCLAS50  = null;
//	private static String usrdir = "C:\\xinhua\\apache-tomcat-6.0.43\\webapps\\News\\model\\userdict.txt";
	private static String usrdir = "F:\\Myeclipse\\workspace\\News\\WebRoot\\model\\userdict.txt";
	//构造函数
	//构造函数
	public LexiconHandler(){
		if (!isInit) init();
	}
	//初始化
	public static void init() {
		if (isInit) return;
		testICTCLAS50 = new ICTCLAS50();
        try {
			if(testICTCLAS50.ICTCLAS_Init(argu.getBytes("GB2312")) == false){
			    System.out.println("Init Fail");
			}else{
			    System.out.println("Init Succeed!");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		isInit = true;		
	}	
	//导入用户字典
	public static void getUserDictionary(){
		int nCount = 0;
        byte[] usrdirb = usrdir.getBytes();
        //第一个参数为用户字典路径，第二个参数为用户字典的编码类型(0:type unknown;1:ASCII码;2:GB2312,GBK,GB10380;3:UTF-8;4:BIG5)
        nCount = testICTCLAS50.ICTCLAS_ImportUserDictFile(usrdirb, 2);        
        System.out.println("导入用户词个数："+nCount);
        nCount = 0; 
	}
	//写入用户字典
	public static void setUserDictionary(Map<String, String> wordArray){
	    OutputStreamWriter outputStream; 	    
		try {
			outputStream = new OutputStreamWriter(new FileOutputStream(usrdir), "GB2312");  
			Iterator its = new SensitiveDirHandler().getSen_map().entrySet().iterator();
			String tmp="";
			while (its.hasNext()) {
				Map.Entry pairs = (Map.Entry) its.next();
				//System.out.println(pairs.getKey());
				
				if((pairs.getValue()+"").equals("1.0")){
					tmp = "zsa";
				}
				else if((pairs.getValue()+"").equals("1.5")){
					tmp = "zsb";
				}
				else if((pairs.getValue()+"").equals("2.0")){
					tmp = "zsc";
				}
				else if((pairs.getValue()+"").equals("2.5")){
					tmp = "zsd";
				}
				else if((pairs.getValue()+"").equals("3.0")){
					tmp = "zse";
				}
				else if((pairs.getValue()+"").equals("3.5")){
					tmp = "zsf";
				}
				else if((pairs.getValue()+"").equals("4.0")){
					tmp = "zsg";
				}
				
				outputStream.write(pairs.getKey()+"@@"+tmp+"\n");
				outputStream.flush();
			}
			
			Iterator it = wordArray.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pairs = (Map.Entry) it.next();
				System.out.println(pairs.getKey());
				outputStream.write(pairs.getKey()+"@@"+"zz"+"\n");
				outputStream.flush();
			}
			
			
			outputStream.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}	

	public static String cutString(String str) {
		
		byte nativeBytes[];
		String nativeStr = "";
		try {
			nativeBytes = testICTCLAS50.ICTCLAS_ParagraphProcess(str.getBytes("GB2312"), 0, 1);
	//		System.out.println(nativeBytes.length);            
	        nativeStr = new String(nativeBytes,0,nativeBytes.length,"GB2312");
	        System.out.println("未导入用户词典分词结果："+nativeStr);
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return nativeStr;

	}
	
	//将分词后的文本包括词性存入List中；
	public ArrayList<Word> changeStringToWordList(String text){
        ArrayList<Word> wordArray = new ArrayList<Word>();
        
        boolean isText = false;
        
        String word = "";
        String word_type="";
      //	fr = new FileReader(path);
		//	int i;
			int j=0;
	        for(int i=0;i<text.length();i++) {
				char nowChar = text.charAt(i);
//System.out.println(nowChar);
				if(nowChar=='/'){
					Word wordOfOne = new Word();
					wordOfOne.setWord(word);
					wordArray.add(wordOfOne);
					word="";
					isText = true;
					
					
				}
				else if(nowChar==' '){
					if(!isText){
						word = "";
					}
					else{
						wordArray.get(j).setWord_type(word_type);
						word_type="";
						j++;
						isText = false;
					}
					
				}
				else {
					if((nowChar<48)||(nowChar>57&&nowChar<127)){
						word_type+=nowChar;
					}
					else {word+=nowChar;
				//	System.out.print(word + "111");
					}
				}
//	 System.out.print(nowChar + "000000");
			} 
        return wordArray;
	}			
	
	
	//将分词后的文本包括词性，颜色存入List中；
	public ArrayList<ColorWord> changeStringToColorWordList(String text){
        ArrayList<ColorWord> wordArray = new ArrayList<ColorWord>();
        
        boolean isText = false;
        
        String word = "";
        String word_type="";
      //	fr = new FileReader(path);
		//	int i;
			int j=0;
	        for(int i=0;i<text.length();i++) {
				char nowChar = text.charAt(i);
//System.out.println(nowChar);
				if(nowChar=='/'){
					ColorWord wordOfOne = new ColorWord();
					wordOfOne.setWord(word);
					wordArray.add(wordOfOne);
					word="";
					isText = true;
					
					
				}
				else if(nowChar==' '){
					if(!isText){
						word = "";
					}
					else{
						wordArray.get(j).setColor(Utils.wordTypeToColor(word_type));
						word_type="";
						j++;
						isText = false;
					}
					
				}
				else {
					if((nowChar<48)||(nowChar>57&&nowChar<127)){
						word_type+=nowChar;
					}
					else {word+=nowChar;
				//	System.out.print(word + "111");
					}
				}
//	 System.out.print(nowChar + "000000");
			} 
        return wordArray;
	}
	
	//将分词后的文本包括词性，颜色存入List中；
	public ArrayList<ColorWord> changeStringToNerColorWordList(String text){
        ArrayList<ColorWord> wordArray = new ArrayList<ColorWord>();
        
        boolean isText = false;
        
        String word = "";
        String word_type="";
      //	fr = new FileReader(path);
		//	int i;
			int j=0;
	        for(int i=0;i<text.length();i++) {
				char nowChar = text.charAt(i);
//System.out.println(nowChar);
				if(nowChar=='/'){
					ColorWord wordOfOne = new ColorWord();
					wordOfOne.setWord(word);
					wordArray.add(wordOfOne);
					word="";
					isText = true;
					
					
				}
				else if(nowChar==' '){
					if(!isText){
						word = "";
					}
					else{
						wordArray.get(j).setColor(Utils.wordTypeToNerColor(word_type));
						word_type="";
						j++;
						isText = false;
					}
					
				}
				else {
					if((nowChar<48)||(nowChar>57&&nowChar<127)){
						word_type+=nowChar;
					}
					else {word+=nowChar;
				//	System.out.print(word + "111");
					}
				}
//	 System.out.print(nowChar + "000000");
			} 
        return wordArray;
	}			
	
	//将分词后的文本包括词性，颜色存入List中；
	public ArrayList<ColorWord> changeStringToSenColorWordList(String text){
        ArrayList<ColorWord> wordArray = new ArrayList<ColorWord>();
        
        boolean isText = false;
        
        String word = "";
        String word_type="";
      //	fr = new FileReader(path);
		//	int i;
			int j=0;
	        for(int i=0;i<text.length();i++) {
				char nowChar = text.charAt(i);
//System.out.println(nowChar);
				if(nowChar=='/'){
					ColorWord wordOfOne = new ColorWord();
					wordOfOne.setWord(word);
					wordArray.add(wordOfOne);
					word="";
					isText = true;
					
					
				}
				else if(nowChar==' '){
					if(!isText){
						word = "";
					}
					else{
						wordArray.get(j).setColor(Utils.wordTypeToSenColor(word_type));
						word_type="";
						j++;
						isText = false;
					}
					
				}
				else {
					if((nowChar<48)||(nowChar>57&&nowChar<127)){
						word_type+=nowChar;
					}
					else {word+=nowChar;
				//	System.out.print(word + "111");
					}
				}
//	 System.out.print(nowChar + "000000");
			} 
        return wordArray;
	}						
}
