package models;

import java.util.List;
import java.util.ArrayList;

public class Schigebiet {
	private String gemeinde;
	private List<Schilift> schilifte=new ArrayList<Schilift>();
	
	public Schigebiet(String gemeinde) {
		this.gemeinde = gemeinde;
	}
	
	public String getGemeinde() {
		return gemeinde;
	}

	public void setGemeinde(String gemeinde) {
		this.gemeinde = gemeinde;
	}
	
	public void addSchilift(Schilift schilift) {
		schilifte.add(schilift);
	}
	
	public List<Schilift> getSchilifte() {
		return schilifte;
	}
}
