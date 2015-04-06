package com.news.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.news.bean.ColorWord;
import com.news.bean.RankRow;
import com.news.bean.SingleNew;
import com.news.lexicon.LexiconHandler;
import com.news.loss.data.Loss;
import com.news.loss.schema.ExtractLoss;
import com.news.rank.Rank;
import com.news.time.schema.ExtractTime;
import com.news.time.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class InputAction extends ActionSupport{
	private String news;  
	private String loss;
	private String time;
	private JSONObject dataMap;
	private JSONObject dataRank;
	private JSONObject dataColor;
	private JSONObject dataNerColor;
	private JSONObject dataSenColor;
	
	private JSONObject timelinessRank;
	private JSONObject sensitivenessRank;
	private JSONObject clarityRank;
	private JSONObject consequenceRank;
	
	private  String timelinessWeight;
	private  String sensitivenessWeight;
	private  String clarityWeight;
	private  String consequenceWeight;
	
	
	
	private LexiconHandler lexiconHandler;
	
	public String getTimelinessWeight(){
		return this.timelinessWeight;
	}
	public void setTimelinessWeight(String timelinessWeight){
		this.timelinessWeight = timelinessWeight;
	}
	
	public String getSensitivenessWeight(){
		return this.sensitivenessWeight;
	}
	public void setSensitivenessWeight(String sensitivenessWeight){
		this.sensitivenessWeight = sensitivenessWeight;
	}
	
	public String getClarityWeight(){
		return this.clarityWeight;
	}
	public void setClarityWeight(String clarityWeight){
		this.clarityWeight = clarityWeight;
	}
	
	public String getConsequenceWeight(){
		return this.consequenceWeight;
	}
	public void setConsequenceWeight(String consequenceWeight){
		this.consequenceWeight = consequenceWeight;
	}
	
	public JSONObject getConsequenceRank() {  
		return consequenceRank;  
	    
	}

	public void setConsequenceRank(JSONObject consequenceRank) {  
	    this.consequenceRank = consequenceRank;  
	}
	
	public JSONObject getClarityRank() {  
		return clarityRank;  
	    
	}

	public void setClarityRank(JSONObject clarityRank) {  
	    this.clarityRank = clarityRank;  
	}
	
	public JSONObject getSensitivenessRank() {  
		return sensitivenessRank;  
	    
	}

	public void setSensitivenessRank(JSONObject sensitivenessRank) {  
	    this.sensitivenessRank = sensitivenessRank;  
	}
	
	public JSONObject getTimelinessRank() {  
		return timelinessRank;  
	    
	}

	public void setTimelinessRank(JSONObject timelinessRank) {  
	    this.timelinessRank = timelinessRank;  
	}
	        
	
	public JSONObject getDataNerColor() {  
        return dataNerColor;  
    }  
    public void setDataNerColor(JSONObject dataNerColor) {  
        this.dataNerColor = dataNerColor;  
    } 
    
    public JSONObject getDataSenColor() {  
        return dataSenColor;  
    }  
    public void setDataSenColor(JSONObject dataSenColor) {  
        this.dataSenColor = dataSenColor;  
    }
	
	public JSONObject getDataColor() {  
        return dataColor;  
    }  
    public void setDataColor(JSONObject dataColor) {  
        this.dataColor = dataColor;  
    } 
	
	public JSONObject getDataMap() {  
        return dataMap;  
    }  
    public void setDataMap(JSONObject dataMap) {  
        this.dataMap = dataMap;  
    } 
    
    public JSONObject getDataRank() {  
        return dataRank;  
    }  
    public void setDataRank(JSONObject dataRank) {  
        this.dataRank = dataRank;  
    }
    public String getNews() {  
        return news;  
    }  
    public void setNews(String news) {  
        this.news = news;  
    }  
    public String getLoss() {  
        return loss;  
    }  
    public void setLoss(String loss) {  
        this.loss = loss;  
    } 
    public String getTime() {  
        return time;  
    }  
    public void setTime(String time) {  
        this.time = time;  
    } 
 
    public String execute(){  

	
    	System.out.println(System.getProperty("java.library.path"));

    	ArrayList<SingleNew> sn = new ArrayList<SingleNew>();
    	String [] strArray = this.news.split("\\|#\\|");
    	System.out.println(strArray.length);
    	String [] tmp;
    	for(int i=0;i<strArray.length;i++){
    		
    		tmp=strArray[i].split("\\|!\\|");
    		sn.add(new SingleNew(tmp[0],tmp[1],tmp[2]));

    	}
    	
    	lexiconHandler = new LexiconHandler();
 //   	for(int i=0;i<sn.size();i++){
 //   		lexiconHandler.setUserDictionary(sn.get(i).getNerResult());
 //   		lexiconHandler.getUserDictionary();
//    		sn.get(i).setCutString(lexiconHandler.cutString(sn.get(i).getText()));
    	
 //   	}
    	
    	
    	
    	Rank rank = new Rank(sn);
    	try{
    		System.out.println("timelinessWeight: "+timelinessWeight);
    		System.out.println("sensitivenessWeight: "+sensitivenessWeight);
    		System.out.println("clarityWeight: "+clarityWeight);
    		System.out.println("consequenceWeight: "+consequenceWeight);
    		rank.setTimelinessWeight(Double.parseDouble(this.timelinessWeight));
    		rank.setSensitivenessWeight(Double.parseDouble(this.sensitivenessWeight));
    		rank.setClarityWeight(Double.parseDouble(this.clarityWeight));
    		rank.setConsequenceWeight(Double.parseDouble(this.consequenceWeight));
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	rank.calRank();
    	
    	for (SingleNew singleNew : rank.getNews()) {
			System.out.println("文本："+singleNew.getText());
			System.out.println("抽取时间："+singleNew.getDate());
			System.out.println("发布时间："+singleNew.getCreatedDate());
			System.out.println("伤亡：死亡"+singleNew.getLoss().getDead()+"   受伤："+singleNew.getLoss().getInjury());
			System.out.println("是否有抽取时间："+singleNew.getHasExtractedTime());
			System.out.println("时效性："+singleNew.getTimeliness());
			System.out.println("时效性排名："+singleNew.getTimelinessRank());
			System.out.println("敏感性："+singleNew.getSensitiveness());
			System.out.println("敏感性排名："+singleNew.getSensitivenessRank());

			System.out.println("清晰性："+singleNew.getClarity());
			System.out.println("清晰性排名："+singleNew.getClarityRank());
			System.out.println("后果："+singleNew.getConsequence());
			System.out.println("后果排名："+singleNew.getConsequenceRank());
			System.out.println("allrank："+singleNew.getAllrank());
			System.out.println("rank："+singleNew.getRank());

		}
    	
    	this.dataMap = buildTree(sn);
    	this.dataRank = buildRank(sn);
    	this.dataColor = buildColorBlock(sn);
    	this.dataNerColor = buildNerColorBlock(sn);
    	this.dataSenColor = buildSenColorBlock(sn);
    
    	this.timelinessRank = buildTimelinessRank(sn);
    	this.sensitivenessRank = buildSensitivenessRank(sn);
    	this.clarityRank = buildClarityRank(sn);
    	this.consequenceRank = buildConsequenceRank(sn);
    	System.out.println(this.dataSenColor.toString());
    	

	    return "success";
    }
    
    public JSONObject buildTree(ArrayList<SingleNew> sn){
    	JSONObject dataMap = new JSONObject();
    	dataMap.put("id", "root");
    	dataMap.put("name", "新闻");
    	dataMap.put("data", null);
    	ArrayList<JSONObject> children = new ArrayList<JSONObject>();
    	for(int i=0;i<sn.size();i++){
    		JSONObject timeChildMap = new JSONObject();
    		timeChildMap.put("id", "node"+i+"00");
    		
    		timeChildMap.put("name", sn.get(i).getDate().toString());
    		timeChildMap.put("data", null);
    		timeChildMap.put("children", null);
    		
    		ArrayList<JSONObject> timeChildren = new ArrayList<JSONObject>();
    		timeChildren.add(timeChildMap);
        	
    		JSONObject timeMap = new JSONObject();
        	timeMap.put("id", "node"+i+"0");
        	timeMap.put("name", "时间");
        	timeMap.put("data", null);
        	timeMap.put("children", timeChildren);
        	
        	JSONObject lossDeadMap = new JSONObject();
        	lossDeadMap.put("id", "node"+i+"10");
        	lossDeadMap.put("name", sn.get(i).getLoss().getDead()+"人");
        	lossDeadMap.put("data", null);
        	lossDeadMap.put("children", null);
        	
        	JSONObject lossInjuryMap = new JSONObject();
        	lossInjuryMap.put("id", "node"+i+"11");
        	lossInjuryMap.put("name", sn.get(i).getLoss().getInjury()+"人");
        	lossInjuryMap.put("data", null);
        	lossInjuryMap.put("children", null);
        	
        	ArrayList<JSONObject> lossChildren = new ArrayList<JSONObject>();
        	lossChildren.add(lossDeadMap);
        	lossChildren.add(lossInjuryMap);
        	
        	JSONObject lossMap = new JSONObject();
        	lossMap.put("id", "node"+i+"1");
        	lossMap.put("name", "伤亡");
        	lossMap.put("data", null);
        	lossMap.put("children",lossChildren );
        	
        	ArrayList<JSONObject> singleChildren = new ArrayList<JSONObject>();
        	singleChildren.add(timeMap);
        	singleChildren.add(lossMap);
    		
        	JSONObject singleMap = new JSONObject();
        	singleMap.put("id", "node"+i);
        	singleMap.put("name", sn.get(i).getTitle());
        	singleMap.put("data", null);
        	singleMap.put("children",singleChildren );
        	
        	children.add(singleMap);
        	
    	}

    	dataMap.put("children",children );
    	
    	
		return dataMap;
    	
    }
    
    public JSONObject buildRank(ArrayList<SingleNew> sn){
    	JSONObject dataRank = new JSONObject();
    	
    	if(sn.size()>=10){
    		for(int i=0;i<sn.size();i++){
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getRank(),sn.get(i).getText(),100-sn.get(i).getAllrank());
        		dataRank.put(""+sn.get(i).getRank(), rr);
        	}
    	}
    	else {
    		for(int i=0;i<sn.size();i++){
    			
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getRank(),sn.get(i).getText(),100-sn.get(i).getAllrank());
        		dataRank.put(""+sn.get(i).getRank(), rr);

        	}
    		for(int i=sn.size()+1;i<11;i++){
    			RankRow rr = new RankRow("none",i,"none",0);
        		dataRank.put(""+i, rr);
        	}
    		
    	}
    	

		return dataRank;
    	
    }
    
    public JSONObject buildTimelinessRank(ArrayList<SingleNew> sn){
    	JSONObject timelinessRank = new JSONObject();
    	
    	if(sn.size()>=10){
    		for(int i=0;i<sn.size();i++){
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getTimelinessRank(),sn.get(i).getText(),sn.get(i).getTimeliness());
    			timelinessRank.put(""+sn.get(i).getTimelinessRank(), rr);
        	}
    	}
    	else {
    		for(int i=0;i<sn.size();i++){
    			
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getTimelinessRank(),sn.get(i).getText(),sn.get(i).getTimeliness());
    			timelinessRank.put(""+sn.get(i).getTimelinessRank(), rr);

        	}
    		for(int i=sn.size()+1;i<11;i++){
    			RankRow rr = new RankRow("none",i,"none",0);
    			timelinessRank.put(""+i, rr);
        	}
    		
    	}
    	

		return timelinessRank;
    	
    }
    
    public JSONObject buildSensitivenessRank(ArrayList<SingleNew> sn){
    	JSONObject sensitivenessRank = new JSONObject();
    	
    	if(sn.size()>=10){
    		for(int i=0;i<sn.size();i++){
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getSensitivenessRank(),sn.get(i).getText(),sn.get(i).getSensitiveness());
    			sensitivenessRank.put(""+sn.get(i).getSensitivenessRank(), rr);
        	}
    	}
    	else {
    		for(int i=0;i<sn.size();i++){
    			
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getSensitivenessRank(),sn.get(i).getText(),sn.get(i).getSensitiveness());
    			sensitivenessRank.put(""+sn.get(i).getSensitivenessRank(), rr);

        	}
    		for(int i=sn.size()+1;i<11;i++){
    			RankRow rr = new RankRow("none",i,"none",0);
    			sensitivenessRank.put(""+i, rr);
        	}
    		
    	}
    	

		return sensitivenessRank;
    	
    }
    
    public JSONObject buildClarityRank(ArrayList<SingleNew> sn){
    	JSONObject clarityRank = new JSONObject();
    	
    	if(sn.size()>=10){
    		for(int i=0;i<sn.size();i++){
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getClarityRank(),sn.get(i).getText(),sn.get(i).getClarity());
    			clarityRank.put(""+sn.get(i).getClarityRank(), rr);
        	}
    	}
    	else {
    		for(int i=0;i<sn.size();i++){
    			
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getClarityRank(),sn.get(i).getText(),sn.get(i).getClarity());
    			clarityRank.put(""+sn.get(i).getClarityRank(), rr);

        	}
    		for(int i=sn.size()+1;i<11;i++){
    			RankRow rr = new RankRow("none",i,"none",0);
    			clarityRank.put(""+i, rr);
        	}
    		
    	}
    	

		return clarityRank;
    	
    }
    
    public JSONObject buildConsequenceRank(ArrayList<SingleNew> sn){
    	JSONObject consequenceRank = new JSONObject();
    	
    	if(sn.size()>=10){
    		for(int i=0;i<sn.size();i++){
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getConsequenceRank(),sn.get(i).getText(),sn.get(i).getConsequence());
    			consequenceRank.put(""+sn.get(i).getConsequenceRank(), rr);
        	}
    	}
    	else {
    		for(int i=0;i<sn.size();i++){
    			
    			RankRow rr = new RankRow(sn.get(i).getTitle(),sn.get(i).getConsequenceRank(),sn.get(i).getText(),sn.get(i).getConsequence());
    			consequenceRank.put(""+sn.get(i).getConsequenceRank(), rr);

        	}
    		for(int i=sn.size()+1;i<11;i++){
    			RankRow rr = new RankRow("none",i,"none",0);
    			consequenceRank.put(""+i, rr);
        	}
    		
    	}
    	

		return consequenceRank;
    	
    }
    
    
    
    
    public JSONObject buildColorBlock(ArrayList<SingleNew> sn){
    	
    	JSONObject dataColor = new JSONObject();
    	
    	
		
    	for(int i=0;i<sn.size();i++){
    		
    		ArrayList<ColorWord> tmp = lexiconHandler.changeStringToColorWordList(sn.get(i).getCutString());
    		dataColor.put(sn.get(i).getTitle(),tmp);
    		
    	}
    	
    	System.out.println("c");

		return dataColor;
    	
    	
    }
    
    public JSONObject buildNerColorBlock(ArrayList<SingleNew> sn){
    	
    	JSONObject dataNerColor = new JSONObject();
    	
    	
		
    	for(int i=0;i<sn.size();i++){
    		
    		ArrayList<ColorWord> tmp = lexiconHandler.changeStringToNerColorWordList(sn.get(i).getCutString());
    		dataNerColor.put(sn.get(i).getTitle(),tmp);
    		
    	}
    	

		return dataNerColor;
    	
    	
    }
    public JSONObject buildSenColorBlock(ArrayList<SingleNew> sn){
    	
    	JSONObject dataNerColor = new JSONObject();
    	
    	
		
    	for(int i=0;i<sn.size();i++){
    		
    		ArrayList<ColorWord> tmp = lexiconHandler.changeStringToSenColorWordList(sn.get(i).getCutString());
    		dataNerColor.put(sn.get(i).getTitle(),tmp);
    		
    	}
    	

		return dataNerColor;
    	
    	
    }
    
    
	    
}
