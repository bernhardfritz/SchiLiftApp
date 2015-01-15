package controllers;

import java.io.FileNotFoundException;

public class TestQRManager {
	public static void main(String[] args) throws FileNotFoundException{
		QRcodeData d=new QRcodeData(0123,2014,12,12,43,8,2015,06,12,33,9,0000);
		QRcodeManager m=new QRcodeManager();
		m.generateQRcode(d);
	}
}
