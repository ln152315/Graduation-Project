package com.news.loss.schema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.news.loss.data.Node;
import com.news.loss.util.LossRegex;

public class Schema2  extends SchemaModel {

//	private static String schema2Pattern = "("+degreeAdv1+")?(("+number+")("+manCount+")?("+name+")?(��|һ|��|���д�)[^,]*?)?("+number+")("+degreeAdv2+")?("+manCount+"|"+homeCount+")?(?:����)?("+name+")[^,|δ���|δ|����|����|��δ|û]*?("+result+")(?!��|"+number+"(?:"+degreeAdv2+")?��)";
	
	@Override
	public Pattern init() {
		//"([0-9]+)(����|��)?(��)"
		Pattern pattern = Pattern.compile(LossRegex.getSchema2Pattern());
		return pattern;
	}

	@Override
	public Node extractInfo(String raw,int start ,int end) {
		Node node = LossRegex.buildNode(raw ,start,end);
		System.out.println("�ı���"+node.getText());
		System.out.println("������ͣ�"+node.getProperty());
		System.out.println("������"+node.getQuantity());
		System.out.println("�Ƿ����ӣ�"+node.getIsIncrease());
		System.out.println("�Ƿ���٣�"+node.getIsDecrease());
		System.out.println("��ʼλ�ã�"+node.getStartPos()+"  ����λ�ã� "+node.getEndPos());
		
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
