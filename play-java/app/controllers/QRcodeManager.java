package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


public class QRcodeManager {

	private static HashManager hash;

	public QRcodeManager(HashManager h){ //Constructor
		QRcodeManager.setHash(h);
	}

	private static class SingletonHelper {
		private static final QRcodeManager INSTANCE = new QRcodeManager(hash);
	}

	public static QRcodeManager getInstance() {
		return SingletonHelper.INSTANCE;

	}

	public void generateQRcode(QRcodeData data) { // creates a qrcode.png with a QRcodeData
		String DataString = data.InfoToString();
		getHash();
		String codeString = HashManager.codeString(DataString);
		try{
		QRCode.from(codeString).to(ImageType.PNG)
				.writeTo(new FileOutputStream(new File("qrcode.png"))); // Stream implementation fehlt
		} catch (FileNotFoundException e) {
			System.out.println("File qrcode.png not found");
			e.printStackTrace();
		}
	}

	public static HashManager getHash() {
		return hash;
	}

	public static void setHash(HashManager hash) {
		QRcodeManager.hash = hash;
	}

}
