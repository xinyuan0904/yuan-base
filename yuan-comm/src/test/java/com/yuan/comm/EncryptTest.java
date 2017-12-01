package com.yuan.comm;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.yuan.comm.util.EncryptUtil;

public class EncryptTest {

	public static void main(String[] args) {
		String uid = UUID.randomUUID().toString().replace("-", "");
		System.out.println(uid);
		try {
			String str = new EncryptUtil().EncoderByMd5("123"+uid);
			System.out.println(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
