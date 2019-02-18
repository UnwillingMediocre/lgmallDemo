package com.stodger.lgmall.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CommonsUtils {
	
	/**
	 * 获取随机UUID
	 * @return
	 */
	public static String getUUId(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replaceAll("-", "");
		return uuidStr;
	}
	
	/**
	 * 获取随机ID
	 * @return
	 */
	 public static String getRandomId(char ch) {
	        long millis = System.currentTimeMillis();
	        //加上两位随机数
	        Random random = new Random();
	        int end2 = random.nextInt(99);
	        //如果不足两位前面补0
	        String str = millis + String.format("%02d", end2);
	        String id = ch + str;
	        return id;
	    }
	/**
	 * 字符替换
	 */
	 public static String getStrReplace(String str){
		 String result = null;
		 String StrSub1 = str.substring(0, 3);
		 String StrSub2 = str.substring(7, str.length() - 1);
		 result = StrSub1 + "****" + StrSub2;
		 return result;
	 }
}
