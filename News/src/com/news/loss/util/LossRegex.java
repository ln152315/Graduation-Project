package com.news.loss.util;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.prefs.NodeChangeEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.news.loss.data.Node;

public class LossRegex {
	private static String degreeAdv1 = "超过了|高于|至少有|起码|最少有|低于|至少|大约|多达|部分|少数|超过|超|共有|仍有|近|约有|约";
	private static String degreeAdv2 = "多|余";
	private static String number = "([0-9]+)|([一二三四五六七八九十百〇零两]+)";
	private static String name = "妇女|儿童|群众|人员|伤患|居民|女孩|男孩|女性|男性|女子|男子|受伤者|老妇人|男士|女士|村民|病人|行人|用户|教师|游客|学生|幸存者|遇难者|人";
	private static String dead = "丧生|遇难|丧命|淹死|罹难|遇害|葬身|丧生|致死|身亡|死亡|死";//伤亡、死伤、无法判断
	private static String injury = "受伤|避难|撤离|负伤|待救|失踪|轻伤|救治|重伤|避难|逃生|出院|病危|脱险|撤离|殉职|受困|受灾|获救|存活|被困|幸存|伤|受伤|受轻伤|受重伤";
	private static String result = injury+"|"+dead;
	
	private static String increase = "新增|增加|添|添加|新发现|又发现|再找到|又有";
	private static String decrease = "排除|减少";
	private static String change = increase+"|"+decrease;
	
	
	private static String manCount = "具|名|个|位|口";
	private static String homeCount = "住家|户";
	
	private static String including = "其中|其余|包括";
	private static String included = "总计|累计|共有|上升到|增至|加至|总人数达|总数达|增加到|最终|达到|共|达";
	private static String includeWord = including + "|" +included;
	
	private static String schema2PatternLevel1 = "(("+"("+change+")?"+number+")("+manCount+")?("+name+")?)("+result+")";
	private static String schema2PatternLevel2 = "("+result+").*?(("+"("+change+")?"+number+")("+manCount+")?("+name+"))";
	private static String schema2PatternLevel3 = "("+degreeAdv1+")?(("+"("+change+")?"+number+")("+manCount+")?("+name+")?(至|一|或|并列词)[^,]*?)?("+"("+change+")?"+number+")("+degreeAdv2+")?("+manCount+"|"+homeCount+")?("+name+")[^,|未造成|未|避免|不会|尚未|没]*?("+result+")(?!于|"+number+"(?:"+degreeAdv2+")?人)";
	private static String schema2Pattern = "(("+schema2PatternLevel1+")|("+schema2PatternLevel2+")|("+schema2PatternLevel3+"))";
	
	
	
	//构建结果节点
	public static Node buildNode(String str, int start,int end){
		Node node = new Node();
		node.setText(str);
		buildNodeQuantity(node,str);
		buildNodeProperty(node,str);
		buildNodeNumberChange(node,str);
		buildNodePos(node,start,end);
		return node;
	}
	
	//填写节点级别
	public static void nodesLevelHandler(ArrayList<Node> nodes, String sentence){
		Pattern pattern = Pattern.compile(includeWord);
		for(int i=1;i<nodes.size();i++){
			String str = sentence.substring(nodes.get(i-1).getEndPos(),nodes.get(i).getEndPos());
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()){
				String raw = matcher.group(0);
				//System.out.println("i-1的start :"+nodes.get(i-1).getStartPos()+"  i-1的end :"+nodes.get(i-1).getEndPos()+"  i的start :"+nodes.get(i).getStartPos()+"  i的end :"+nodes.get(i).getEndPos()+"  matcher:"+raw+" "+matcher.start()+" "+matcher.end());
				//节点类型规范化
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
	
	//填写节点位置
	private static void buildNodePos(Node node,int start ,int end){
		node.setStartPos(start);
		node.setEndPos(end);
	}
	
	//填写节点数字
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
	//填写节点类型
	private static void buildNodeProperty(Node node,String str){
		Pattern pattern = Pattern.compile(result);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			String raw = matcher.group(0);
			
			//节点类型规范化
			if(dead.contains(raw)){
				node.setProperty(1);
			}
			else if(injury.contains(raw)){
				node.setProperty(2);
			}
			
		}	
	}		
	
	//节点数字变化趋势   增加or减少
	private static void buildNodeNumberChange(Node node,String str){
		Pattern pattern = Pattern.compile(change);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			String raw = matcher.group(0);
			System.out.println(raw);
			//节点类型规范化
			if(increase.contains(raw)){
				node.setIsIncrease(true);
			}
			else if(decrease.contains(raw)){
				node.setIsDecrease(true);
			}
			
		}
	}	
	
	
	//获取pattern
	public static String getSchema2Pattern(){
		return schema2Pattern;
	}
	
}
