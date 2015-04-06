package com.news.loss.util;

public class Format {
	public static boolean isNumeric(String str){
		for (int i = str.length();--i>=0;){ 
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	public static long chnNum2Digit(String chnNum) {  
        // initialize map  
        java.util.Map<String, Integer> unitMap = new java.util.HashMap<String, Integer>();  
        unitMap.put("��", 1);// �������ݴ洢ʱʹ��  
        unitMap.put("ʮ", 10);  
        unitMap.put("��", 100);  
        unitMap.put("ǧ", 1000);  
        unitMap.put("��", 10000);  
        unitMap.put("��", 100000000);  
  
        java.util.Map<String, Integer> numMap = new java.util.HashMap<String, Integer>();  
        numMap.put("��", 0);  
        numMap.put("һ", 1);  
        numMap.put("��", 2);  
        numMap.put("��", 2); 
        numMap.put("��", 3);  
        numMap.put("��", 4);  
        numMap.put("��", 5);  
        numMap.put("��", 6);  
        numMap.put("��", 7);  
        numMap.put("��", 8);  
        numMap.put("��", 9);  
  
        // ���ݴ洢�ṹ��  
        // ��λ ����  
        // "��" num  
        // "ʮ" num  
        // "��" num  
        // "ǧ" num  
        // "��" num  
        // "��" num  
        java.util.Map<String, Long> dataMap = new java.util.LinkedHashMap<String, Long>();  
  
        // ����"��"��"��"֮ǰ���ڵĶ�λ��  
        java.util.List<Long> multiNumList = new java.util.ArrayList<Long>();  
  
        long tempNum = 0;  
        for (int i = 0; i < chnNum.length(); i++) {  
            char bit = chnNum.charAt(i);  
            System.out.print(bit);  
  
            // ��Ϊ"��"��"��"���ڶ�λ�����������Ҫ�����ж�  
            boolean isExist = false;  
            // ����"��"��"��"���(�����㵱ǰ����λ)  
            if ((chnNum.indexOf('��', i) != -1 || chnNum.indexOf('��', i) != -1)  
                    && chnNum.charAt(i) != '��' && chnNum.charAt(i) != '��') {  
                isExist = true;  
            }  
  
            // ����  
            if (numMap.containsKey(bit + "")) {  
                if (i != chnNum.length() - 1) {  
                    tempNum = tempNum + numMap.get(bit + "");  
                }  
                // ��ĩλ�������  
                else {  
                    dataMap.put("��", Long.valueOf(numMap.get(bit + "") + ""));  
                    tempNum = 0;  
                }  
            } else if (bit == '��') {  
                // ����"����"�����ȡ��"��"λֵ*10000,0000������put��map  
                if (i - 1 >= 0 && chnNum.charAt(i - 1) == '��') {  
                    Long dataValue = dataMap.get("��");  
                    if (dataValue != null && dataValue > 0) {  
                        dataMap.put("��", dataValue * unitMap.get(bit + ""));  
                    }  
                    continue;  
                }  
  
                // ���һλ����list�ȴ�����  
                if (tempNum != 0) {  
                    multiNumList.add(tempNum);  
                }  
                // ����"��"֮ǰ�Ķ�λ��  
                long sum = 0;  
                for (Long num : multiNumList) {  
                    sum += num;  
                }  
                multiNumList.clear();  
                dataMap.put("��", sum);  
                tempNum = 0;  
            } else if (bit == '��') {  
                // ���һλ����list�ȴ�����  
                if (tempNum != 0) {  
                    multiNumList.add(tempNum);  
                }  
                // ����"��"֮ǰ�Ķ�λ��  
                long sum = 0;  
                for (Long num : multiNumList) {  
                    sum += num;  
                }  
                multiNumList.clear();  
                dataMap.put("��", sum);  
                tempNum = 0;  
            } else if (bit == 'ǧ' && tempNum > 0) {  
                // ����"��"��"��"�������ʱ����ֵ*"ǧ"��λֵ��list�ȴ�����  
                if (isExist) {  
                    multiNumList.add(tempNum * unitMap.get(bit + ""));  
                    tempNum = 0;  
                }  
                // ������"��"��"��"�������ʱ����ֵput��map  
                else {  
                    dataMap.put("ǧ", tempNum);  
                    tempNum = 0;  
                }  
            } else if (bit == '��' && tempNum > 0) {  
                // ����"��"��"��"�������ʱ����ֵ*"��"��λֵ��list�ȴ�����  
                if (isExist) {  
                    multiNumList.add(tempNum * unitMap.get(bit + ""));  
                    tempNum = 0;  
                }  
                // ������"��"��"��"�������ʱ����ֵput��map  
                else {  
                    dataMap.put("��", tempNum);  
                    tempNum = 0;  
                }  
            } else if (bit == 'ʮ') {  
                // ����"��"��"��"�������ʱ����ֵ*"ʮ"��λֵ��list�ȴ�����  
                if (isExist) {  
                    if (tempNum != 0) {  
                        multiNumList.add(tempNum * unitMap.get(bit + ""));  
                        tempNum = 0;  
                    }  
                    // ��"ʮ"ת����"һʮ"  
                    else {  
                        tempNum = 1 * unitMap.get(bit + "");  
                    }  
                }  
                // ������"��"��"��"�������ʱ����ֵput��map  
                else {  
                    if (tempNum != 0) {  
                        dataMap.put("ʮ", tempNum);  
                    }  
                    // ��"ʮ"ת����"һʮ"  
                    else {  
                        dataMap.put("ʮ", 1l);  
                    }  
                    tempNum = 0;  
                }  
            }  
        }  
  
        // output  
        System.out.println();  
        long sum = 0;  
        java.util.Set<String> keys = dataMap.keySet();  
        for (String key : keys) {  
            Integer unitValue = unitMap.get(key);  
            Long dataValue = dataMap.get(key);  
            sum += unitValue * dataValue;  
        }  
        return sum;
    }  
}
