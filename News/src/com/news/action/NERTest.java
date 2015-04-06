package com.news.action;

import java.util.List;
import java.util.Map;

import bupt.sse.ner.NERTagger;
import bupt.sse.ner.TimeTagger;

public class NERTest {
	
	public static void main(String[] args){
		System.out.println(System.getProperty("java.library.path"));
		// ��ȡ������
		String text = "�ڣ�������������֮�ʣ���ʮ�ָ��˵�ͨ����������㲥��̨���й����ʹ㲥��̨���������̨����ȫ����������������ر�������ͬ�������ź�̨��ͬ���������Ȱ�������������������ǣ����Գ�ֿ���ʺ�����õ�ףԸ��";
		// crfmodel�ļ�·��
		String model = ".\\lib\\crfmodel";
		// ����ʵ���ע��
		NERTagger nerTagger = new NERTagger(model);
		// ʱ��ʵ���ע��
		TimeTagger timeTagger = new TimeTagger();
		// ����ʵ��ı�ע���
		Map<String, String> nerResult = nerTagger.tag(text);
		// ʱ��ʵ��ı�ע���
		List<String> timeResult = timeTagger.tag(text);
		// ��ӡ��ע���
		System.out.println(nerResult);
		System.out.println(timeResult);
	}
}
