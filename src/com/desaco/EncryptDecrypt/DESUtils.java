package com.desaco.EncryptDecrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DESUtils {
	//加密
	public static byte[] encrypt(byte[] data, byte[] password) {
		byte[] ret = null;
		// 判断参数是否符合条件
		if (data != null && data.length > 0) {
			if (password != null && password.length == 8) {
				try {
					// 1、创造加密引擎
					Cipher cipher = Cipher.getInstance("DES");
					// 2、初始化
					SecretKeySpec key = new SecretKeySpec(password, "DES");
					cipher.init(Cipher.ENCRYPT_MODE, key);
					// 3、对数据进行加密
					ret = cipher.doFinal(data);

				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (BadPaddingException e) {
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	//解密
	public static byte[] decrypt(byte[] data, byte[] password) {
		byte[] ret = null;

		if (data != null && data.length > 0) {
			if (password != null && password.length == 8) {
				try {
					// 1、获取解密引擎
					Cipher cipher = Cipher.getInstance("DES");

					// 2、初始化
					SecretKeySpec key = new SecretKeySpec(password, "DES");

					cipher.init(Cipher.DECRYPT_MODE, key);

					// 3、解密
					ret = cipher.doFinal(data);

				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (BadPaddingException e) {
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}

			}

		}
		return ret;
	}
}
