package com.vvvtimes.util;


public class Base64 {
	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode(byte[] bstr) {
		return org.apache.commons.codec.binary.Base64.encodeBase64String(bstr);
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static byte[] decode(String str) {
		return org.apache.commons.codec.binary.Base64.decodeBase64(str);
	}

}
