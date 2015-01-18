package controllers;


import java.io.IOException;

import models.QRcodeData;

import com.google.zxing.NotFoundException;


public class TestQRManager {
	public static void main(String[] args) throws NotFoundException, IOException{
		//QRcodeData d=new QRcodeData(0123,2012,12,12,12,8,2015,01,19,12,8,"Dornbirn");
		//QRcodeData d2=new QRcodeData("1234201401010101201511111111Dornbirn");
		QRcodeData d2=new QRcodeData(1,"01/18/2015 11:21 AM","01/26/2015 11:21 AM","Dornbirn");
		System.out.println(d2);
		/*QRcodeManager m=new QRcodeManager();
		m.generateQRcode(d);
		
		System.out.println("Time left: "+d.leftTime());
		
		System.out.println("created Hashcode: "+d.getHashCode());
		m.generateQRcode(d.getHashCode());
		
		System.out.println("decoded QRcode:   " + QRcodeManager.readQRCode("qrcode.png"));
		System.out.println("decoded QRcode: " + QRcodeManager.readQRCode("Test.png"));
		*/
	}
}