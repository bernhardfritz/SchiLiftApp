package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRTest {

	public static void main(String[] args) throws FileNotFoundException {
		QRCode.from("Hello World").to(ImageType.PNG).writeTo(new FileOutputStream(new File("qrtest.png")));
	}

}
