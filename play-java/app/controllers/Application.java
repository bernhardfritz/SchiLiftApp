package controllers;

import models.QRcodeData;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.about;
import views.html.gekauft;
import views.html.index;
import views.html.kaufen;
import views.html.login;
import views.html.schigebiet;
import views.html.schilift;
import views.html.suche;
import views.html.test;

public class Application extends Controller {
	
    public static class Login {
    	public String email;
    	public String password;
    	
    	public String validate() {
    		if (User.authenticate(email, password) == null) {
    			return "Invalid user or password!";
    		}
    		return null;
    	}
    }

    @Security.Authenticated(Secured.class)
    public static Result index() {
    	DBManager dbman = DBManager.getInstance();
        return ok(index.render(dbman.getQRcodeDataList(1)));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result suche() {
    	DBManager dbman = DBManager.getInstance();
    	return ok(suche.render("",dbman.getAlleSchigebiete()));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result suche(String suchbegriff) {
    	if(suchbegriff.equals("")) return suche();
    	else {
    		DBManager dbman = DBManager.getInstance();
    		return ok(suche.render(suchbegriff,dbman.getSchigebiete(suchbegriff)));
    	}
    }
    
    @Security.Authenticated(Secured.class)
    public static Result schigebiet(String gemeinde) {
    	DBManager dbman = DBManager.getInstance();
    	return ok(schigebiet.render(gemeinde,dbman.getSchigebiet(gemeinde).getSchilifte()));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result kaufen(String gemeinde) {
    	return ok(kaufen.render(gemeinde));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result schilift(Long id) {
    	DBManager dbman = DBManager.getInstance();
    	return ok(schilift.render(dbman.getSchilift(id)));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result about() {
    	return ok(about.render());
    }

    @Security.Authenticated(Secured.class)
    public static Result qrgen(String hash) {
    	QRcodeManager qrman = QRcodeManager.getInstance();
    	return ok(qrman.generateBinary(hash)).as("image/jpeg");
    }
    
    public static Result login() {
    	DBManager.getInstance();
    	Form<Login> loginForm = Form.form(Login.class);
    	return ok(login.render(loginForm));
    }
    
    public static Result authenticate() {
    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    	if (loginForm.hasErrors()) {
    		return badRequest(login.render(loginForm));
    	}
    	else {
    		session().clear();
    		session("email", loginForm.get().email);
    		return redirect(routes.Application.index());
    	}
    }
    
    @Security.Authenticated(Secured.class)
    public static Result logout() {
    	session().clear();
    	return redirect(routes.Application.login());
    }
    
    @Security.Authenticated(Secured.class)
    public static Result gekauft(String gemeinde, String startdatetime, String enddatetime) {
    	DBManager dbman = DBManager.getInstance();
    	System.out.println(startdatetime);
    	QRcodeData qrCodeData = new QRcodeData(1, startdatetime, enddatetime, gemeinde);
    	dbman.registerQRcode(qrCodeData);
    	return ok(gekauft.render(gemeinde, startdatetime, enddatetime, qrCodeData.getHashCode()));
    }
    
    @Security.Authenticated(Secured.class)
    public static Result test() {
    	return ok(test.render());
    }
}