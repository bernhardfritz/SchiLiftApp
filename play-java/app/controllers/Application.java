package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(""));
    }
    
    public static Result suche(String suchbegriff) {
    	return ok(suche.render(suchbegriff,null));
    }
    
    public static Result schigebiet(String gemeinde) {
    	DBManager dbman = DBManager.getInstance();
    	return ok(schigebiet.render(gemeinde,dbman.getSchigebiet(gemeinde).getSchilifte()));
    }
    
    public static Result schilift(Long id) {
    	DBManager dbman = DBManager.getInstance();
    	return ok(schilift.render(dbman.getSchilift(id)));
    }

}
