package controllers;

import java.io.FileNotFoundException;

public class TestQRManager {
	public static void main(String[] args) throws FileNotFoundException{
		QRcodeData d=new QRcodeData(0123,2014,12,12,43,8,2016,11,16,0,0,0000);
		HashManager hash= new HashManager();
		QRcodeManager m=new QRcodeManager(hash);
		//m.generateQRcode(d);
		System.out.println(d.leftTime());
	}
}
