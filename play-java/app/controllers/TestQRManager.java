package controllers;


import java.io.IOException;

import models.QRcodeData;

import com.google.zxing.NotFoundException;


public class TestQRManager {
	public static void main(String[] args) throws NotFoundException, IOException{

		QRcodeData d=new QRcodeData(0123,2012,12,12,12,8,2015,01,19,12,8,"Dornbirn");
		//QRcodeData d2=new QRcodeData("1234201511010101201501191111Dornbirn");
		//System.out.println(d2.leftTime());
		//System.out.println(d2.getGemeinde());
		//QRcodeManager m=new QRcodeManager();
		//m.generateQRcode(d);

		//QRcodeData d=new QRcodeData(0123,2012,12,12,12,8,2015,01,19,12,8,"Dornbirn");
		//QRcodeData d2=new QRcodeData("1234201401010101201511111111Dornbirn");
		QRcodeData x=new QRcodeData(1,"01/18/2015 11:21 AM","01/26/2015 11:21 AM","Dornbirn");
		System.out.println(x);
		/*QRcodeManager m=new QRcodeManager();
		m.generateQRcode(d);
>>>>>>> 72c40919024a0fa4505111b0bef736a68ff46dc9
		
		System.out.println("Time left: "+d.leftTime());
		
		System.out.println("created Hashcode: "+d.getHashCode());
		m.generateQRcode(d.getHashCode());
		
		System.out.println("decoded QRcode:   " + QRcodeManager.readQRCode("qrcode.png"));
		System.out.println("decoded QRcode: " + QRcodeManager.readQRCode("Test.png"));
		*/
	}
}
