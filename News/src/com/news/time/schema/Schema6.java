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
		String[][] model = {{"һ","1"},{"��","2"},{"��","3"},{"��","4"},{"��","5"},
				{"��","6"},{"��","7"},{"��","8"},{"��","9"},{"ʮ","10"},{"ʮһ","11"},
				{"ʮ��","12"},{"ʮ��","13"},{"ʮ��","14"},{"ʮ��","15"},{"ʮ��","16"},
				{"ʮ��","17"},{"ʮ��","18"},{"ʮ��","19"},{"��ʮ","20"},{"��ʮһ","21"},
				{"��ʮ��","22"},{"��ʮ��","23"},{"��ʮ��","24"},{"��ʮ��","25"},{"��ʮ��","26"},
				{"��ʮ��","27"},{"��ʮ��","28"},{"��ʮ��","29"},{"��ʮ","30"},{"��ʮһ","31"}
				,{"��","0"},{"��","0"}};
		for(int i=model.length-1;i>=0;i--)
			raw = raw.replace(model[i][0],model[i][1]);
		return raw;
		
	}

	@Override
	public Pattern init() {
		Pattern pattern = Pattern.compile("[�㩖һ�����������߰˾�ʮ������]+");
		return pattern;
	}

}
