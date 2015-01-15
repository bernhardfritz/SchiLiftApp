package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import org.apache.commons.codec.binary.Hex;

public class QRcodeManager {

	private static MessageDigest algorythm;

	public QRcodeManager() { // creates a MessageDigest with MD5
		try {
			algorythm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
	}

	private static class SingletonHelper {
		private static final QRcodeManager INSTANCE = new QRcodeManager();
	}

	public static QRcodeManager getInstance() {
		return SingletonHelper.INSTANCE;

	}

	public static String codeString(String x) { //encodes the given String with MessageDigest
		algorythm.update(x.getBytes());
		byte[] digest = algorythm.digest();
		String output = Hex.encodeHexString(digest);
		return output;
	}

	public void generateQRcode(QRcodeData data) throws FileNotFoundException { // creates a qrcode.png with a QRcodeData
		String DataString = data.InfoToString();
		String codeString = codeString(DataString);
		QRCode.from(codeString).to(ImageType.PNG)
				.writeTo(new FileOutputStream(new File("qrcode.png"))); // Stream
																		// implementation
																		// fehlt
	}

}
