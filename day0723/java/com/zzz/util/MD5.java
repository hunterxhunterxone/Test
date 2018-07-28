package com.zzz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String md5(String src) {
		StringBuffer buffer = new StringBuffer();
		char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		byte[] bytes = src.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] zhuanma = md.digest(bytes);
			for(byte b:zhuanma) {
				buffer.append(chars[b>>4&0x0F]);
				buffer.append(chars[b&0x0F]);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
