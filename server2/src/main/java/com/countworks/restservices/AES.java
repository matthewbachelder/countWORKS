package com.countworks.restservices;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static String KEY = "aQr82w359Br71qA5";
	private Key aesKey;
	private Cipher cipher;

	public AES() {
		aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
		try {
			cipher = Cipher.getInstance("AES");

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String encryptText(String text) {
		return iEncryptText(text);
	}

	private String iEncryptText(String text) {

		try {
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (byte b : encrypted) {
				sb.append((char) b);
			}
			text = sb.toString();
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException
				| UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return text;
	}

	public String decryptText(String text) {
		return iDecryptText(text);
	}

	private String iDecryptText(String text) {

		try {

			byte[] b = new byte[text.length()];
			for (int i = 0; i < text.length(); i++)
				b[i] = (byte) text.charAt(i);

			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			text = new String(cipher.doFinal(b));

		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {

			e.printStackTrace();
		}
		
		return text;
	}

}
