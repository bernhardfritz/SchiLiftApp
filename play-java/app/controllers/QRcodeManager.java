package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRcodeManager {

	// TODO: der HashManager sollte nicht global im QRcodeManager initialisiert werden
	// Bitte Singleton pattern für HashManager umsetzen, und immer dann wenn HashManager gebraucht
	// wird mit HashManager.getInstance() instanziieren.
	private static HashManager hash;

	public QRcodeManager(HashManager h) { // Constructor
		QRcodeManager.setHash(h);
	}

	private static class SingletonHelper {
		private static final QRcodeManager INSTANCE = new QRcodeManager(hash);
	}

	public static QRcodeManager getInstance() {
		return SingletonHelper.INSTANCE;

	}

	// TODO: diese Methode hat im QRcodeManager nix verloren
	public String generateHash(QRcodeData data) { // creates a Hash with a
													// String
		String DataString = data.InfoToString();
		String codeString = HashManager.codeString(DataString);
		return codeString;
	}

	public void generateQRcode(String codeString) { // creates a qrcode.png with
													// a Hash
		try {
			QRCode.from(codeString).to(ImageType.PNG)
					.writeTo(new FileOutputStream(new File("qrcode.png"))); // Stream
																			// implementation
																			// fehlt
		} catch (FileNotFoundException e) {
			System.out.println("File qrcode.png not found");
			e.printStackTrace();
		}
	}

	// TODO: remove
	public static HashManager getHash() {
		return hash;
	}

	// TODO: remove
	public static void setHash(HashManager hash) {
		QRcodeManager.hash = hash;
	}

	// readQRcode braucht nur einen Parameter. Setze den charset einfach standardmäßig auf UTF-8
	public static String readQRCode(String filePath, String charset) { // decodes
																		// a
																		// given
																		// qr
																		// code
																		// (filepath,
																		// "UTF-8")
		BinaryBitmap binaryBitmap = null;
		try {
			binaryBitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(
							ImageIO.read(new FileInputStream(filePath)))));
		} catch (IOException e) {
			System.out.println("File " + filePath + " not Found");
			e.printStackTrace();
		}
		Result qrCodeResult = null;

		try {
			qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
		} catch (NotFoundException e) {
			System.out.println("File " + filePath + " not Found");
			e.printStackTrace();
		}
		return qrCodeResult.toString();
	}
}
