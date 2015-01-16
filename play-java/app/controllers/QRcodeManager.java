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
	
	public QRcodeManager() { // Constructor
	}

	private static class SingletonHelper {
		private static final QRcodeManager INSTANCE = new QRcodeManager();
	}

	public static QRcodeManager getInstance() {
		return SingletonHelper.INSTANCE;
	}

	

	public void generateQRcode(String codeString) { // creates a qrcode.png with a Hash
		try {
			QRCode.from(codeString).to(ImageType.PNG)
					.writeTo(new FileOutputStream(new File("qrcode.png"))); // Stream implementation fehlt
		} catch (FileNotFoundException e) {
			System.out.println("File qrcode.png not found");
			e.printStackTrace();
		}
	}

	public static String readQRCode(String filePath) { // decodes a QRcode given a filepath
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
