package com.news.loss.util;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.prefs.NodeChangeEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.loss.data.Node;

public class LossRegex {
	private static String degreeAdv1 = "������|����|������|����|������|����|����|��Լ|���|����|����|����|��|����|����|��|Լ��|Լ";
	private static String degreeAdv2 = "��|��";
	private static String number = "([0-9]+)|([һ�����������߰˾�ʮ�٩�����]+)";
	private static String name = "��Ů|��ͯ|Ⱥ��|��Ա|�˻�|����|Ů��|�к�|Ů��|����|Ů��|����|������|�ϸ���|��ʿ|Ůʿ|����|����|����|�û�|��ʦ|�ο�|ѧ��|�Ҵ���|������|��";
	private static String dead = "ɥ��|����|ɥ��|����|���|����|����|ɥ��|����|����|����|��";//���������ˡ��޷��ж�
	private static String injury = "����|����|����|����|����|ʧ��|����|����|����|����|����|��Ժ|��Σ|����|����|ѳְ|����|����|���|���|����|�Ҵ�|��|����|������|������";
	private static String result = injury+"|"+dead;
	
	private static String increase = "����|����|��|���|�·���|�ַ���|���ҵ�|����";
	private static String decrease = "�ų�|����";
	private static String change = increase+"|"+decrease;
	
	
	private static String manCount = "��|��|��|λ|��";
	private static String homeCount = "ס��|��";
	
	private static String including = "����|����|����";
	private static String included = "�ܼ�|�ۼ�|����|������|����|����|��������|������|���ӵ�|����|�ﵽ|��|��";
	private static String includeWord = including + "|" +included;
	
	private static String schema2PatternLevel1 = "(("+"("+change+")?"+number+")("+manCount+")?("+name+")?)("+result+")";
	private static String schema2PatternLevel2 = "("+result+").*?(("+"("+change+")?"+number+")("+manCount+")?("+name+"))";
	private static String schema2PatternLevel3 = "("+degreeAdv1+")?(("+"("+change+")?"+number+")("+manCount+")?("+name+")?(��|һ|��|���д�)[^,]*?)?("+"("+change+")?"+number+")("+degreeAdv2+")?("+manCount+"|"+homeCount+")?("+name+")[^,|δ���|δ|����|����|��δ|û]*?("+result+")(?!��|"+number+"(?:"+degreeAdv2+")?��)";
	private static String schema2Pattern = "(("+schema2PatternLevel1+")|("+schema2PatternLevel2+")|("+schema2PatternLevel3+"))";
	
	
	
	//��������ڵ�
	public static Node buildNode(String str, int start,int end){
		Node node = new Node();
		node.setText(str);
		buildNodeQuantity(node,str);
		buildNodeProperty(node,str);
		buildNodeNumberChange(node,str);
		buildNodePos(node,start,end);
		return node;
	}
	
	//��д�ڵ㼶��
	public static void nodesLevelHandler(ArrayList<Node> nodes, String sentence){
		Pattern pattern = Pattern.compile(includeWord);
		for(int i=1;i<nodes.size();i++){
			String str = sentence.substring(nodes.get(i-1).getEndPos(),nodes.get(i).getEndPos());
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()){
				String raw = matcher.group(0);
				//System.out.println("i-1��start :"+nodes.get(i-1).getStartPos()+"  i-1��end :"+nodes.get(i-1).getEndPos()+"  i��start :"+nodes.get(i).getStartPos()+"  i��end :"+nodes.get(i).getEndPos()+"  matcher:"+raw+" "+matcher.start()+" "+matcher.end());
				//�ڵ����͹淶��
				if(including.contains(raw)){
					nodes.get(i).setLevel(nodes.get(i-1).getLevel()-1);
				}
				else if(included.contains(raw)){
					nodes.get(i).setLevel(nodes.get(i-1).getLevel()+1);
				}
				else {
					nodes.get(i).setLevel(nodes.get(i-1).getLevel());
				}
				
			}	
		}
		
		
	}
	
	//��д�ڵ�λ��
	private static void buildNodePos(Node node,int start ,int end){
		node.setStartPos(start);
		node.setEndPos(end);
	}
	
	//��д�ڵ�����
	private static void buildNodeQuantity(Node node,String str){
		Pattern pattern = Pattern.compile(number);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			String raw = matcher.group(0);
			if(Format.isNumeric(raw)){
				node.setQuantity(Integer.parseInt(raw));
			} 
			else {
				node.setQuantity((int)Format.chnNum2Digit(raw));
			}
			
		}
	}
	//��д�ڵ�����
	private static void buildNodeProperty(Node node,String str){
		Pattern pattern = Pattern.compile(result);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			String raw = matcher.group(0);
			
			//�ڵ����͹淶��
			if(dead.contains(raw)){
				node.setProperty(1);
			}
			else if(injury.contains(raw)){
				node.setProperty(2);
			}
			
		}	
	}		
	
	//�ڵ����ֱ仯����   ����or����
	private static void buildNodeNumberChange(Node node,String str){
		Pattern pattern = Pattern.compile(change);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			String raw = matcher.group(0);
			System.out.println(raw);
			//�ڵ����͹淶��
			if(increase.contains(raw)){
				node.setIsIncrease(true);
			}
			else if(decrease.contains(raw)){
				node.setIsDecrease(true);
			}
			
		}
	}	
	
	
	//��ȡpattern
	public static String getSchema2Pattern(){
		return schema2Pattern;
	}
	
}
