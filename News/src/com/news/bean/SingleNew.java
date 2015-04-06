package com.news.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.news.lexicon.LexiconHandler;
import com.news.lexicon.Word;
import com.news.loss.data.Loss;
import com.news.loss.schema.ExtractLoss;
import com.news.ner.NamedEntity;
import com.news.sensitive.SensitiveDirHandler;
import com.news.time.schema.ExtractTime;
import com.news.time.util.Utils;

public class SingleNew {
	private String title;
	private String text;
	private Date date;
	private Loss loss;
	private Date createdDate;
	private String cutString;
	private Map<String, String> nerResult ;
	private ArrayList<Word> cutWordList ;
	
	private boolean hasExtractedTime;
	private long timeliness ;
	private double sensitiveness  ;
	private int clarity ;
	private double consequence ;
	
	private int timelinessRank =1;
	private int sensitivenessRank  =1;
	private int clarityRank  =1;
	private int consequenceRank  =1;
	
	private double allrank;
	private int rank = 1;
	
	private LexiconHandler  lexiconHandler;
	
	
	public SingleNew(String title,String text ,String time) {
		this.title = title;
		this.text=text;
		lexiconHandler = new LexiconHandler();
		init(text,time);
    }
	
	public void init(String text, String time){
		this.loss = ExtractLoss.determine(text);
		if(loss == null){
			System.out.println("no match");
		}else{
			System.out.println("死亡"+loss.getDead()+"   受伤"+loss.getInjury() );
		}
		
		
		Date created = new Utils().trans("yyyy年MM月dd日 HH:mm:ss",time);
		this.createdDate = created;
		this.date = new ExtractTime().determine(text,created);
		if(date == null){
			this.date = created;
			System.out.println(date);
		}else{
			System.out.println(date);
		}
		
		this.consequence = calConsequence(loss);
		this.timeliness = calTimeliness(this.date,created);
		
		this.clarity = calClarity() ;
		
		
		
		lexiconHandler.setUserDictionary(nerResult);
		lexiconHandler.getUserDictionary();
		cutString=lexiconHandler.cutString(text);
		
		cutWordList = lexiconHandler.changeStringToWordList(cutString);
		this.sensitiveness =calSensitiveness() ;
		
	}
	
	public double calConsequence(Loss loss){
		return (double)loss.getDead()+(double)loss.getInjury()/100;
	}
	
	public long calTimeliness(Date date ,Date created){
		if(date ==null){
			hasExtractedTime = false;
			return created.getTime();
		}
		else{
			hasExtractedTime = true;
			return System.currentTimeMillis()-date.getTime();
		}
	}
	
	public double calSensitiveness(){
		System.out.println("sensitive  ");
		SensitiveDirHandler sensitiveDirHandler = new SensitiveDirHandler();
		double sensitiveness=0;
		for(int i=0;i<cutWordList.size();i++){
			if(sensitiveDirHandler.getSen_map().containsKey(cutWordList.get(i).getWord())){
				System.out.println("sensitive  "+cutWordList.get(i).getWord());
				System.out.println("sensitive  "+sensitiveDirHandler.getSen_map().get(cutWordList.get(i).getWord()));
				sensitiveness += sensitiveDirHandler.getSen_map().get(cutWordList.get(i).getWord());
			}
		}
		return sensitiveness;
	}
	public int calClarity(){
		System.out.println("calClarity");
		NamedEntity ner = new NamedEntity();
		nerResult = NamedEntity.NamedEntityExtract(this.text);
		System.out.println(this.nerResult);
		return this.nerResult.size();
	}
	
	public boolean getHasExtractedTime(){
		return this.hasExtractedTime;
	}
	public void setHasExtractedTime(boolean hasExtractedTime){
		this.hasExtractedTime=hasExtractedTime;
	}
	
	public long getTimeliness(){
		return this.timeliness;
	}
	public void setTimeliness(long timeliness){
		this.timeliness=timeliness;
	}
	public double getSensitiveness(){
		return this.sensitiveness;
	}
	public void setSensitiveness(double sensitiveness){
		this.sensitiveness=sensitiveness;
	}
	public int getClarity(){
		return this.clarity;
	}
	public void setClarity(int clarity){
		this.clarity=clarity;
	}
	public double getConsequence(){
		return this.consequence;
	}
	public void setConsequence(double consequence){
		this.consequence=consequence;
	}
	
	public int getRank(){
		return this.rank;
	}
	public void setRank(int rank){
		this.rank=rank;
	}
	public int getSensitivenessRank(){
		return this.sensitivenessRank;
	}
	public void setSensitivenessRank(int sensitivenessRank){
		this.sensitivenessRank=sensitivenessRank;
	}
	public int getClarityRank(){
		return this.clarityRank;
	}
	public void setClarityRank(int clarityRank){
		this.clarityRank=clarityRank;
	}
	public int getConsequenceRank(){
		return this.consequenceRank;
	}
	public void setConsequenceRank(int consequenceRank){
		this.consequenceRank=consequenceRank;
	}
	
	public double getAllrank(){
		return this.allrank;
	}
	public void setAllrank(double allrank){
		this.allrank=allrank;
	}
	
	public int getTimelinessRank(){
		return this.timelinessRank;
	}
	public void setTimelinessRank(int timelinessRank){
		this.timelinessRank=timelinessRank;
	}
	
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
	public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getCutString() {
        return this.cutString;
    }

    public void setCutString(String cutString) {
        this.cutString = cutString;
    }
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date date) {
        this.createdDate = date;
    }
    
    public Loss getLoss() {
        return loss;
    }

    public void setLoss(Loss loss) {
        this.loss = loss;
    }
    public Map<String, String> getNerResult() {
        return nerResult;
    }

    public void setNerResult(Map<String, String> nerResult) {
        this.nerResult = nerResult;
    }
    
      
}
