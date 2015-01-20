package controllers;

import models.QRcodeData;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	DBManager dbman = DBManager.getInstance();
    	System.out.println(dbman.getQRcodeDataList(1).size());
        return ok(index.render(dbman.getQRcodeDataList(1)));
    }
    
    public static Result suche() {
    	DBManager dbman = DBManager.getInstance();
    	return ok(suche.render("",dbman.getAlleSchigebiete()));
    }
    
    public static Result suche(String suchbegriff) {
    	if(suchbegriff.equals("")) return suche();
    	else {
    		DBManager dbman = DBManager.getInstance();
    		return ok(suche.render(suchbegriff,dbman.getSchigebiete(suchbegriff)));
    	}
    }
    
    public static Result schigebiet(String gemeinde) {
    	DBManager dbman = DBManager.getInstance();
    	return ok(schigebiet.render(gemeinde,dbman.getSchigebiet(gemeinde).getSchilifte()));
    }
    
    public static Result kaufen(String gemeinde) {
    	return ok(kaufen.render(gemeinde));
    }
    
    public static Result schilift(Long id) {
    	DBManager dbman = DBManager.getInstance();
    	return ok(schilift.render(dbman.getSchilift(id)));
    }
    
    public static Result about() {
    	return ok(about.render());
    }

    public static Result qrgen(String hash) {
    	QRcodeManager qrman = QRcodeManager.getInstance();
    	return ok(qrman.generateBinary(hash)).as("image/jpeg");
    }
    
    public static Result login() {
    	return ok(login.render(""));
    }
    
    public static Result gekauft(String gemeinde, String startdatetime, String enddatetime) {
    	DBManager dbman = DBManager.getInstance();
    	System.out.println(startdatetime);
    	QRcodeData qrCodeData = new QRcodeData(1, startdatetime, enddatetime, gemeinde);
    	dbman.registerQRcode(qrCodeData);
    	return ok(gekauft.render(gemeinde, startdatetime, enddatetime, qrCodeData.getHashCode()));
    }
    
    public static Result test() {
    	return ok(test.render());
    }
}