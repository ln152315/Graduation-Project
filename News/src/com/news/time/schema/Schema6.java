package com.news.time.schema;

import java.util.Date;
import java.util.regex.Pattern;

public class Schema6 extends SchemaModel {

	@Override
	public Date solve(Date created, String raw) {
		raw = CN2Num(raw);
		SchemaModel sm = new Schema4();
		Date date = sm.process(raw,created);
		return date;
	}
	
	public String CN2Num(String raw){
		String[][] model = {{"一","1"},{"二","2"},{"三","3"},{"四","4"},{"五","5"},
				{"六","6"},{"七","7"},{"八","8"},{"九","9"},{"十","10"},{"十一","11"},
				{"十二","12"},{"十三","13"},{"十四","14"},{"十五","15"},{"十六","16"},
				{"十七","17"},{"十八","18"},{"十九","19"},{"二十","20"},{"二十一","21"},
				{"二十二","22"},{"二十三","23"},{"二十四","24"},{"二十五","25"},{"二十六","26"},
				{"二十七","27"},{"二十八","28"},{"二十九","29"},{"三十","30"},{"三十一","31"}
				,{"〇","0"},{"零","0"}};
		for(int i=model.length-1;i>=0;i--)
			raw = raw.replace(model[i][0],model[i][1]);
		return raw;
		
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("[零〇一二三四五六七八九十年月日]+");
		return pattern;
	}

}
