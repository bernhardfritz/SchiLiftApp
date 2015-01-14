package models;

import java.util.List;
import java.util.ArrayList;

public class Schigebiet {
	private List<Schilift> schilifte=new ArrayList<Schilift>();
	
	public void addSchilift(Schilift schilift) {
		schilifte.add(schilift);
	}
	
	public List<Schilift> getSchilifte() {
		return schilifte;
	}
}
