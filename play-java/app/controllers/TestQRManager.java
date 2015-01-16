package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class TestQRManager {
	public static void main(String[] args) throws NotFoundException, IOException{
		QRcodeData d=new QRcodeData(0123,2014,12,12,43,8,2016,11,16,0,0,0000);
		HashManager hash= new HashManager();
		QRcodeManager m=new QRcodeManager(hash);
		//m.generateQRcode(d);
		//System.out.println(d.leftTime());
		System.out.println(m.generateHash(d));
		m.generateQRcode(m.generateHash(d));
		
		Map hintMap = new HashMap();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		System.out.println(QRcodeManager.readQRCode("qrcode.png", "UTF-8", hintMap));
	}
}
