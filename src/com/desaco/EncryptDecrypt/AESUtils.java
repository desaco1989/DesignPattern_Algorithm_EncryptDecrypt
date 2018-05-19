package com.desaco.EncryptDecrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
	public static byte[] encrypt(byte[] data, byte[] password) {  
        byte[] ret = null;  
  
        if(data!=null&&data.length>0){  
            if(password!=null&&password.length==16){  
  
                try {  
                    //1、创造加密引擎  
                    Cipher cipher = Cipher.getInstance("AES");  
                    //2、初始化,无法使用SecretKeyFactory  
                    SecretKeySpec key = new SecretKeySpec(password,"AES");  
                    cipher.init(Cipher.ENCRYPT_MODE,key);  
                    //3、加密  
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
  
    public static byte[] decrypt(byte[] data, byte[] password) {  
        byte[] ret = null;  
  
        if(data!=null&&data.length>0){  
            if(password!=null&&password.length==16){  
  
                try {  
                    //1、创造加密引擎  
                    Cipher cipher = Cipher.getInstance("AES");  
                    //2、初始化,无法使用SecretKeyFactory  
                    SecretKeySpec key = new SecretKeySpec(password,"AES");  
                    cipher.init(Cipher.DECRYPT_MODE,key);  
                    //3、加密  
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
  
    /** 
     * AES 第二种加密算法 
     * @param data 
     * @param password 
     * @param ivParams 
     * @return 
     */  
//    public static byte[] encrypt2(byte[] data, byte[] password, byte[] ivParams) {  
//        byte[] ret = null;  
//        if(data!=null&&data.length>0){  
//            if(password!=null&&password.length==16&&ivParams!=null&&ivParams.length==16){  
//                try {  
//                    //1、创造加密引擎,CBC:加密模式；PKCS5Padding：填充模式  
//                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
//                    //2、初始化,无法使用SecretKeyFactory  
//                    SecretKeySpec key = new SecretKeySpec(password,"AES");  
//                    //相当于第二个密码，向量参数，加密级别更高  
//                    IvParameterSpec iv_params = new IvParameterSpec(ivParams);  
//                    cipher.init(Cipher.ENCRYPT_MODE,key,iv_params);  
//                    //3、加密  
//                    ret = cipher.doFinal(data);  
//  
//                } catch (NoSuchAlgorithmException e) {  
//                    e.printStackTrace();  
//                } catch (NoSuchPaddingException e) {  
//                    e.printStackTrace();  
//                } catch (InvalidKeyException e) {  
//                    e.printStackTrace();  
//                } catch (BadPaddingException e) {  
//                    e.printStackTrace();  
//                } catch (IllegalBlockSizeException e) {  
//                    e.printStackTrace();  
//                } catch (InvalidAlgorithmParameterException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return ret;  
//    }  
}
