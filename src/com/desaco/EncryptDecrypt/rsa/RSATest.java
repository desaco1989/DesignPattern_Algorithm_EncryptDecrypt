package com.desaco.EncryptDecrypt.rsa;

public class RSATest {
	public static void main(String[] args) {
		String filepath = "D:/android_keystore/"; // D:/android_keystore/
													// G:/tmp/
		// RSAEncrypt.genKeyPair(filepath);
		System.out.println("--------------公钥加密私钥解密过程-------------------");
		String plainText = "we are family..公钥加密私钥解密过程";
		// 公钥加密过程
		byte[] cipherData = null;
		try {
			cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),
					plainText.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cipher = Base64.encode(cipherData);
		// 私钥解密过程
		byte[] res = null;
		try {
			res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),
					Base64.decode(cipher));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String restr = new String(res);
		System.out.println("原文：" + plainText);
		System.out.println("加密：" + cipher);
		System.out.println("解密：" + restr);
		System.out.println();

		System.out.println("--------------私钥加密公钥解密过程-------------------");
		plainText = "we are family..私钥加密公钥解密过程";
		// 私钥加密过程
		try {
			cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),
					plainText.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cipher = Base64.encode(cipherData);
		// 公钥解密过程
		try {
			res = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),
					Base64.decode(cipher));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		restr = new String(res);
		System.out.println("原文：" + plainText);
		System.out.println("加密：" + cipher);
		System.out.println("解密：" + restr);
		System.out.println();

		System.out.println("---------------私钥签名过程------------------");
		String content = "ihep_这是用于签名的原始数据";
		String signstr = null;
		try {
			signstr = RSASignature.sign(content, RSAEncrypt.loadPrivateKeyByFile(filepath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("签名原串：" + content);
		System.out.println("签名串：" + signstr);
		System.out.println();

		System.out.println("---------------公钥校验签名------------------");
		System.out.println("签名原串：" + content);
		System.out.println("签名串：" + signstr);

		try {
			System.out.println(
					"验签结果：" + RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
