package com.stodger.lgmall.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CommonsUtils {
	
	/**
	 * ��ȡ���UUID
	 * @return
	 */
	public static String getUUId(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replaceAll("-", "");
		return uuidStr;
	}
	
	/**
	 * ��ȡ���ID
	 * @return
	 */
	 public static String getRandomId(char ch) {
	        long millis = System.currentTimeMillis();
	        //������λ�����
	        Random random = new Random();
	        int end2 = random.nextInt(99);
	        //���������λǰ�油0
	        String str = millis + String.format("%02d", end2);
	        String id = ch + str;
	        return id;
	    }
	/**
	 * �ַ��滻
	 */
	 public static String getStrReplace(String str){
		 String result = null;
		 String StrSub1 = str.substring(0, 3);
		 String StrSub2 = str.substring(7, str.length() - 1);
		 result = StrSub1 + "****" + StrSub2;
		 return result;
	 }
}
