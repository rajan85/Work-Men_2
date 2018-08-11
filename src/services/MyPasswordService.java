package services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MyPasswordService {

	public String encode(String uname , String plainpswd)
	{
		MessageDigest md = null;
		
		try {
			md =MessageDigest.getInstance("SHA-1");
			md.update(plainpswd.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte raw[] = null;
		raw = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
		
		
	}
}
