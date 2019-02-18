package com.stodger.lgmall.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class EncryptUtil {
	/**
	 * ��byte����ת����16����
	 * @param bytes
	 * @return result
	 */
	private static String convertByteHexString(byte[] bytes) {
		StringBuilder  result = new StringBuilder();
		for(int i = 0; i < bytes.length; i++) {
			int temp = bytes[i] & 0xff;
			String tempHex = Integer.toHexString(temp);
			if(tempHex.length() < 2) {
				tempHex = '0' + tempHex;
			}
			result.append(tempHex);
		}
		return result.toString();
	}
	/**
	 * md5����
	 * @param name
	 * @return res
	 */
	public static String md5Encrypt(String name) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String result = "";
		MessageDigest md5Digest = MessageDigest.getInstance("md5");
		byte[] encodeMd5Digest = md5Digest.digest(name.getBytes());
		result = convertByteHexString(encodeMd5Digest);
		return result;
	}
	/**
	 * ����У��
	 * @param str
	 * @param code
	 * @return result
	 */
	public static boolean md5Check(String newpassword, String oldpassword) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		boolean result = false;
		if(oldpassword.equals(md5Encrypt(newpassword))) {
			result = true;
		}
		return result;
	}
}
