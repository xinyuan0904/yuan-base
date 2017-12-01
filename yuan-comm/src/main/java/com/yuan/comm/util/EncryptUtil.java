package com.yuan.comm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.StringUtils;

import sun.misc.BASE64Encoder;

/**
 * 加密工具类
 * @ClassName EncryptUtil
 * @author YUAN
 * @date 2017年12月1日
 * @version 1.0
 */
public class EncryptUtil {

	/**
	 * MD5进行加密
	 * @MethodName EncoderByMd5 
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @author YUAN
	 * @return String
	 */
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException{
		if( StringUtils.isEmpty( str )){
			return str;
		}
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		return base64en.encode( md5.digest( str.getBytes() ));
	}
}
