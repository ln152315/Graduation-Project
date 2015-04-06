package com.news.rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.news.bean.SingleNew;

public class Rank {
	private ArrayList<SingleNew> news;
	private  double timelinessWeight=0.25;
	private  double sensitivenessWeight=0.25;
	private  double clarityWeight=0.25;
	private  double consequenceWeight=0.25;

	public Rank(ArrayList<SingleNew> news){
		this.news = news;
	}
	
	public double getTimelinessWeight(){
		return this.timelinessWeight;
	}
	public void setTimelinessWeight(double timelinessWeight){
		this.timelinessWeight = timelinessWeight;
	}
	
	public double getSensitivenessWeight(){
		return this.sensitivenessWeight;
	}
	public void setSensitivenessWeight(double sensitivenessWeight){
		this.sensitivenessWeight = sensitivenessWeight;
	}
	
	public double getClarityWeight(){
		return this.clarityWeight;
	}
	public void setClarityWeight(double clarityWeight){
		this.clarityWeight = clarityWeight;
	}
	
	public double getConsequenceWeight(){
		return this.consequenceWeight;
	}
	public void setConsequenceWeight(double consequenceWeight){
		this.consequenceWeight = consequenceWeight;
	}
	
	public ArrayList<SingleNew> getNews(){
		return news;
	}
	
	public void set (ArrayList<SingleNew> news){
		this.news = news;
	}
	
	public void  calRank(){
		System.out.println("timelinessWeight: "+timelinessWeight);
		System.out.println("sensitivenessWeight: "+sensitivenessWeight);
		System.out.println("clarityWeight: "+clarityWeight);
		System.out.println("consequenceWeight: "+consequenceWeight);
		calConsequenceRank();
		calSensitivenessRank();
		calClarityRank();
		calTimelinessRank();
		for (SingleNew singleNew : news) {
			double allrank = (singleNew.getTimelinessRank()*timelinessWeight + singleNew.getSensitivenessRank()*sensitivenessWeight+
					singleNew.getClarityRank()*clarityWeight+singleNew.getConsequenceRank()*consequenceWeight)/4;
			singleNew.setAllrank(allrank);
			
		}
		System.out.println("cccccc");
		
		Collections.sort(news, new SortByRank());
		int i=1;
		for (SingleNew singleNew : news) {
			singleNew.setRank(i);
			i++;
		}
		System.out.println("ddddddd");
		
	}
	
	private  void calConsequenceRank(){
		Collections.sort(news, new SortByConsequence());
		int i=1;
		for (SingleNew singleNew : news) {
			
			singleNew.setConsequenceRank(i);
			System.out.println("test"+" "+singleNew.getConsequenceRank()+"   "+singleNew.getConsequence());
			i++;
		}
		
		
	}
	private void  calSensitivenessRank( ){
		Collections.sort(news, new SortBySensitiveness());
		int i=1;
		for (SingleNew singleNew : news) {
			singleNew.setSensitivenessRank(i);
			i++;
		}
		
		
	}
	private void calClarityRank( ){
		Collections.sort(news, new SortByClarity());
		int i=1;
		for (SingleNew singleNew : news) {
			singleNew.setClarityRank(i);
			i++;
		}
		 
		
	}
	
	private void calTimelinessRank( ){
		Collections.sort(news, new SortByTimeliness());
		int i=1;
		for (SingleNew singleNew : news) {
			singleNew.setTimelinessRank(i);
			i++;
		}
		 
		
	}
	
	class SortByConsequence implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			SingleNew s1 = (SingleNew) o1;
			SingleNew s2 = (SingleNew) o2;
			if (s1.getConsequence() > s2.getConsequence())
				return -1;
			return 1;
		}
	}
	class SortBySensitiveness implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			SingleNew s1 = (SingleNew) o1;
			SingleNew s2 = (SingleNew) o2;
			if (s1.getSensitiveness() > s2.getSensitiveness())
				return -1;
			return 1;
		}
	}
	
	class SortByClarity implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			SingleNew s1 = (SingleNew) o1;
			SingleNew s2 = (SingleNew) o2;
			if (s1.getClarity() > s2.getClarity())
				return -1;
			return 1;
		}
	}
	
	class SortByTimeliness implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			SingleNew s1 = (SingleNew) o1;
			SingleNew s2 = (SingleNew) o2;
			if (s1.getHasExtractedTime()&&s2.getHasExtractedTime()){
				if(s1.getTimeliness() < s2.getTimeliness())
					return -1;
				else return 1;
			}
			else if((!s1.getHasExtractedTime())&&(!s2.getHasExtractedTime())){
				if(s1.getTimeliness() > s2.getTimeliness())
					return -1;
				else return 1;
			}
			else if((!s1.getHasExtractedTime())&&(s2.getHasExtractedTime())){
				
				return 1;
			
			}
			else if((s1.getHasExtractedTime())&&(!s2.getHasExtractedTime())){
				
				return -1;
			
			}
			return 1;
			
		}
	}
	class SortByRank implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			SingleNew s1 = (SingleNew) o1;
			SingleNew s2 = (SingleNew) o2;
			if (s1.getAllrank() < s2.getAllrank())
				return -1;
			return 1;
		}
	}
	
}
