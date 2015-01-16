package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

// TODO: hier auch wieder singleton pattern anwenden
public class HashManager {
	private static MessageDigest algorythm;
	
	public HashManager() { // creates a MessageDigest with MD5
		try {
			algorythm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}	
		
	}
	
	public static String codeString(String x) { //encodes the given String with MessageDigest
		algorythm.update(x.getBytes());
		byte[] digest = algorythm.digest();
		String output = Hex.encodeHexString(digest);
		return output;
}
}