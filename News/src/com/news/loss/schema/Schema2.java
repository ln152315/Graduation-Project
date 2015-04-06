package com.news.loss.schema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.news.loss.data.Node;
import com.news.loss.util.LossRegex;

public class Schema2  extends SchemaModel {

//	private static String schema2Pattern = "("+degreeAdv1+")?(("+number+")("+manCount+")?("+name+")?(至|一|或|并列词)[^,]*?)?("+number+")("+degreeAdv2+")?("+manCount+"|"+homeCount+")?(?:国籍)?("+name+")[^,|未造成|未|避免|不会|尚未|没]*?("+result+")(?!于|"+number+"(?:"+degreeAdv2+")?人)";
	
	@Override
	public Pattern init() {
		//"([0-9]+)(个人|人)?(死)"
		Pattern pattern = Pattern.compile(LossRegex.getSchema2Pattern());
		return pattern;
	}

	@Override
	public Node extractInfo(String raw,int start ,int end) {
		Node node = LossRegex.buildNode(raw ,start,end);
		System.out.println("文本："+node.getText());
		System.out.println("结果类型："+node.getProperty());
		System.out.println("数量："+node.getQuantity());
		System.out.println("是否增加："+node.getIsIncrease());
		System.out.println("是否减少："+node.getIsDecrease());
		System.out.println("开始位置："+node.getStartPos()+"  结束位置： "+node.getEndPos());
		
	//	String cut = lexiconHandler.cutString(raw);
	//	ArrayList<Word> words = null;
	//	try {
	//		words = lexiconHandler.changeResultToArray(cut);
	//	} catch (IOException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	//	System.out.println(cut);
	//	System.out.println(words);
		return node;
	}

}
