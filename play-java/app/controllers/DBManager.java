package controllers;

import java.util.ArrayList;
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
	
	public Schilift getSchilift(Long id) {
		return Schilift.find.byId(id);
	}
	
	public List<Schigebiet> getSchigebiete(String suchbegriff) {
		return getSchigebieteFromLifte(Schilift.find.where().like("gemeinde", suchbegriff.toLowerCase()+"%").findList());
	}
	
	public List<Schigebiet> getAlleSchigebiete() {		
		return getSchigebieteFromLifte(Schilift.find.all());
	}
	
	private List<Schigebiet> getSchigebieteFromLifte(List<Schilift> lifte) {
		List<Schigebiet> schigebiete = new ArrayList<Schigebiet>();
		
		for (Schilift l : lifte) {
			Schigebiet tempSchigebiet = new Schigebiet(l.getGemeinde());
			if (schigebiete.contains(tempSchigebiet)) {
				schigebiete.get(schigebiete.indexOf(tempSchigebiet)).addSchilift(l);
			}
			else {
				tempSchigebiet.addSchilift(l);
				schigebiete.add(tempSchigebiet);
			}
		}
		
		return schigebiete;
	}
}