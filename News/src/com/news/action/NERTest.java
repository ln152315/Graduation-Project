package com.news.action;

import java.util.List;
import java.util.Map;

import bupt.sse.ner.NERTagger;
import bupt.sse.ner.TimeTagger;

public class NERTest {
	
	public static void main(String[] args){
		System.out.println(System.getProperty("java.library.path"));
		// 抽取的正文
		String text = "在１９９８年来临之际，我十分高兴地通过中央人民广播电台、中国国际广播电台和中央电视台，向全国各族人民，向香港特别行政区同胞、澳门和台湾同胞、海外侨胞，向世界各国的朋友们，致以诚挚的问候和良好的祝愿！";
		// crfmodel文件路径
		String model = ".\\lib\\crfmodel";
		// 命名实体标注器
		NERTagger nerTagger = new NERTagger(model);
		// 时间实体标注器
		TimeTagger timeTagger = new TimeTagger();
		// 命名实体的标注结果
		Map<String, String> nerResult = nerTagger.tag(text);
		// 时间实体的标注结果
		List<String> timeResult = timeTagger.tag(text);
		// 打印标注结果
		System.out.println(nerResult);
		System.out.println(timeResult);
	}
}
