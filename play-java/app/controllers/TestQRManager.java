package controllers;


import java.io.IOException;

import com.google.zxing.NotFoundException;


public class TestQRManager {
	public static void main(String[] args) throws NotFoundException, IOException{
		QRcodeData d=new QRcodeData(0123,2012,12,12,12,8,2016,03,12,12,8,"Dornbirn");
		QRcodeManager m=new QRcodeManager();
		//m.generateQRcode(d);
		
		System.out.println("Time left: "+d.leftTime());
		
		System.out.println("created Hashcode: "+d.getHashCode());
		m.generateQRcode(d.getHashCode());
		
		System.out.println("decoded QRcode:   " + QRcodeManager.readQRCode("qrcode.png"));
		System.out.println("decoded QRcode: " + QRcodeManager.readQRCode("Test.png"));
	}
}
