package com.desaco.EncryptDecrypt.hash_md5;

public class StringUtils {
	public static boolean isBlank(String str) {
		if (null == str || "".equals(str)) {
			return true;
		}
		return false;
	}
}
