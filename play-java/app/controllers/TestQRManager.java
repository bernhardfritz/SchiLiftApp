package controllers;


import java.io.IOException;

import com.google.zxing.NotFoundException;


public class TestQRManager {
	public static void main(String[] args) throws NotFoundException, IOException{
		QRcodeData d=new QRcodeData(0123,2014,12,12,12,8,2016,03,12,12,8,6666);
		HashManager hash= new HashManager();
		QRcodeManager m=new QRcodeManager(hash);
		//m.generateQRcode(d);
		
		System.out.println("Time left: "+d.leftTime());
		
		System.out.println("created Hashcode: "+m.generateHash(d));
		m.generateQRcode(m.generateHash(d));
		
		System.out.println("decoded QRcode: " + QRcodeManager.readQRCode("qrcode.png", "UTF-8"));
		System.out.println("decoded QRcode: " + QRcodeManager.readQRCode("Test.png", "UTF-8"));
	}
}
