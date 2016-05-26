package com.huihui.common.utils;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;



/**
 * 加解密方法
 */
public class CryptoTools {  
  
	private static final byte[] DESkey = { (byte) 0x56, (byte) 0x61, (byte) 0x76,
        (byte) 0x69, (byte) 0x63, (byte) 0x41, (byte) 0x70, (byte) 0x70};// 设置密钥

	private static final byte[] DESIV = { (byte) 0x56, (byte) 0x61, (byte) 0x76,
    (byte) 0x69, (byte) 0x63, (byte) 0x41, (byte) 0x70, (byte) 0x70};// 设置向量
  
    static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现  
    private static Key key = null;  
  
    public CryptoTools() throws Exception {
        DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数  
        iv = new IvParameterSpec(DESIV);// 设置向量  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂  
        key = keyFactory.generateSecret(keySpec);// 得到密钥对象  
  
    }  
  
//    public String encode(String data) throws Exception {
//        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
//        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
//        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
//        BASE64Encoder base64Encoder = new BASE64Encoder();
//        return base64Encoder.encode(pasByte);
//    }
//
//    public String decode(String data) throws Exception {
//        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
//        BASE64Decoder base64Decoder = new BASE64Decoder();
//        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
//        return new String(pasByte, "UTF-8");
//    }
  
    /*public static void main(String[] args) throws Exception {  
  
        CryptoTools tools = new CryptoTools();  
        System.out.println("加密:" + tools.encode("天下"));  
        System.out.println("解密:" + tools.decode(tools.encode("天下")));  
    }*/
}
