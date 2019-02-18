package com.stodger.lgmall.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.stodger.lgmall.domain.LGResult;

public class CheckUtil {
	private static LGResult result = new LGResult();
	private static List<String> words = new ArrayList<String>();
	/**
	 * 汉字验证码
	 * @param path
	 * @return words
	 */
	public static  List<String> chinese_character(String path){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
	/**
	 * 数字、字母验证码
	 * @return check
	 */
	public static String number_letter(){
		String check = "";
		char [] codeSequence = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H',
				'i','I','j','J','k','K','m','M','n','N','o','O','p','P','q','Q',
				'r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y',
				'z','Z','0','1','2','3','4','5','6',
				'7','8','9'};
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			String rand = codeSequence[random.nextInt(codeSequence.length)]+"";
			check += rand;
		}
		return check;
	}
	
	public static LGResult codeCheck(String newCode, String oldCode){
		if(newCode.equals(oldCode)){
			result.setOk(false);
			result.setMsg("验证码错误！");
		}else{
			result.setOk(true);
		}
		return result;
	}
	
}
