package com.news.time.schema;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public abstract class SchemaModel{
	
	private Date date;//null for not matched
	
	//will callback the function if matched
	public abstract Date solve(Date created,String raw);
	
	//initial pattern
	public abstract Pattern init();

	//dominant function
	public Date process(String sentence,Date created){
		Pattern pattern = init();
		Matcher matcher = pattern.matcher(sentence);
		if(matcher.find()){
			String raw = matcher.group(0);
			date = solve(created,raw);
		}
		return date;
	}
	
}
