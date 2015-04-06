package com.news.bean;

public class RankRow  {
	private String title;
    private int rank;
    private String text;
    private double rankValue;
    

    public RankRow() {
    }

    public RankRow(String title,int rank, String text, double rankValue) {
    	this.title = title;
        this.rank = rank;
        this.text = text;
        this.rankValue = rankValue;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRankValue() {
        return rankValue;
    }

    public void setRankValue(double rankValue) {
        this.rankValue = rankValue;
    }

}