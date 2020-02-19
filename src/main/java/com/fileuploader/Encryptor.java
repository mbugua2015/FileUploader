package com.fileuploader;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class Encryptor {
	private static final String ALGO="AES";
	
	private static final byte[] keyValue= new byte[]{
			'!','*','-','&','^','9','1','7','8','2','(',')','+','=','%','%'
	};
	
	public static String Encrypt(String plainText)throws Exception{
		Key key= generateKey();
		
		Cipher c= Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal= c.doFinal(plainText.getBytes());
		String encryptedValue= new BASE64Encoder().encode(encVal);
		
		return encryptedValue;
	}
	
	public static String Decrypt(String CipherText)
			throws Exception{
		Key key= generateKey();
		
		Cipher c= Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		
		byte[] decodedValue= new BASE64Decoder().decodeBuffer(CipherText);
		
		byte[] decValue= c.doFinal(decodedValue);
		
		String decryptedValue= new String(decValue);
		
		return decryptedValue;
	}
	
	private static Key generateKey()throws Exception{
		Key key= new SecretKeySpec(keyValue, ALGO);
		
		return key;
	}

}
