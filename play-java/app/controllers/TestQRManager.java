package controllers;

import java.io.IOException;

import models.QRcodeData;

import com.google.zxing.NotFoundException;


public class TestQRManager {
	public static void main(String[] args) throws NotFoundException, IOException{
		//QRcodeData d=new QRcodeData(0123,2012,12,12,12,8,2015,01,19,12,8,"Dornbirn");
		//QRcodeData d2=new QRcodeData("1234201401010101201511111111Dornbirn");
		QRcodeData d2=new QRcodeData("admin@test.at","01/20/2015 11:21 AM","01/28/2015 03:43 PM","Dornbirn");
		//System.out.println(d2);
		System.out.println(d2.isValid());
		//LocalDateTime a= new LocalDateTime(2015,1,1,01,01);
		//LocalDateTime b =new LocalDateTime(2015,1,22,15,38);
		//System.out.println(LocalDateTime.now().isBefore(b));
		//System.out.println(b.isBefore(a));
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
