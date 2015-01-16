package controllers;

import java.util.List;

import models.Schigebiet;
import models.Schilift;

public class DBManager {
	
	private DBManager() {
		init();
	}
	
	private static class SingletonHelper {
		private static final DBManager INSTANCE = new DBManager();
	}
	
	public static DBManager getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public void init() {
		if (Schilift.find.all().isEmpty()) {
			insertData();
		}
	}
	
	private void insertData() {
		List<Schilift> lifte = SchiliftManager.getInstance().getSchilifte();
		for (Schilift l : lifte) {
			l.save();
		}
	}
	
	public Schigebiet getSchigebiet(String gemeinde) {
		Schigebiet schigebiet = new Schigebiet(gemeinde);
		
		List<Schilift> lifte = Schilift.find.where().ieq("gemeinde", gemeinde).findList();
		for (Schilift l : lifte) {
			schigebiet.addSchilift(l);
		}
		
		return schigebiet;
	}
	
	// TODO: public Schilift getSchilift(long id) {}
}