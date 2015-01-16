package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.poi.ss.usermodel.Row;

import play.db.ebean.Model;
import controllers.Tool;

@Entity
public class Schilift extends Model {

	private static final long serialVersionUID = -5632600707152700197L;

	@Id
	private Long id;
	
	private String name;
	private int plz;
	private String gemeinde;
	private int baujahr;
	private String typ;
	private String zubringerfunktion;
	private float breite;					// [m]
	private int personenProAufhaengung;
	private boolean sitzplatzheizung;
	private boolean wetterschutz;
	private boolean einstiegshilfe;
	private int schraegeLaenge;				// [m]
	private int hoeheTalstation;			// [m]
	private int hoeheBergstation;			// [m]
	private int hoehendifferenz;			// [m]
	private int foerderleistung;			// [Pers/h]
	private int transportkapazitaet;		// [PersHkm/h]
	
	public Schilift() {}
	
	public Schilift(Row row) {
		setName(row.getCell(0).toString());
		setPlz(Tool.StringToInt(row.getCell(1).toString()));
		setGemeinde(row.getCell(2).toString());
		setBaujahr(Tool.StringToInt(row.getCell(3).toString()));
		setTyp(row.getCell(4).toString());
		setZubringerfunktion(row.getCell(5).toString());
		setBreite(Tool.StringToFloat(row.getCell(6).toString()));
		setPersonenProAufhaengung(Tool.StringToInt(row.getCell(7).toString()));
		setSitzplatzheizung(row.getCell(8).toString().equals("ja")?true:false);
		String tmp=row.getCell(9).toString();
		setWetterschutz(tmp.equals("Bubble")||tmp.equals("Kabine")?true:false);
		setEinstiegshilfe(row.getCell(10).toString().equals("Förderband")?true:false);
		setSchraegeLaenge(Tool.StringToInt(row.getCell(11).toString()));
		setHoeheTalstation(Tool.StringToInt(row.getCell(12).toString()));
		setHoeheBergstation(Tool.StringToInt(row.getCell(13).toString()));
		setHoehendifferenz(Tool.StringToInt(row.getCell(14).toString()));
		setFoerderleistung(Tool.StringToInt(row.getCell(15).toString()));
		setTransportkapazitaet(Tool.StringToInt(row.getCell(16).toString()));
	}
	
	public static Finder<Long, Schilift> find = new Finder<Long, Schilift>(Long.class, Schilift.class);
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPlz() {
		return plz;
	}
	
	public void setPlz(int plz) {
		this.plz = plz;
	}
	
	public String getGemeinde() {
		return gemeinde;
	}
	
	public void setGemeinde(String gemeinde) {
		this.gemeinde = gemeinde;
	}
	
	public int getBaujahr() {
		return baujahr;
	}
	
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	public String getTyp() {
		return typ;
	}
	
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	public String getZubringerfunktion() {
		return zubringerfunktion;
	}
	
	public void setZubringerfunktion(String zubringerfunktion) {
		this.zubringerfunktion = zubringerfunktion;
	}
	
	public float getBreite() {
		return breite;
	}
	
	public void setBreite(float breite) {
		this.breite = breite;
	}
	
	public int getPersonenProAufhaengung() {
		return personenProAufhaengung;
	}
	
	public void setPersonenProAufhaengung(int personenProAufhaengung) {
		this.personenProAufhaengung = personenProAufhaengung;
	}
	
	public boolean isSitzplatzheizung() {
		return sitzplatzheizung;
	}
	
	public void setSitzplatzheizung(boolean sitzplatzheizung) {
		this.sitzplatzheizung = sitzplatzheizung;
	}
	
	public boolean isWetterschutz() {
		return wetterschutz;
	}
	
	public void setWetterschutz(boolean wetterschutz) {
		this.wetterschutz = wetterschutz;
	}
	
	public boolean isEinstiegshilfe() {
		return einstiegshilfe;
	}
	
	public void setEinstiegshilfe(boolean einstiegshilfe) {
		this.einstiegshilfe = einstiegshilfe;
	}
	
	public int getSchraegeLaenge() {
		return schraegeLaenge;
	}
	
	public void setSchraegeLaenge(int schraegeLaenge) {
		this.schraegeLaenge = schraegeLaenge;
	}
	
	public int getHoeheTalstation() {
		return hoeheTalstation;
	}
	
	public void setHoeheTalstation(int hoeheTalstation) {
		this.hoeheTalstation = hoeheTalstation;
	}
	
	public int getHoeheBergstation() {
		return hoeheBergstation;
	}
	
	public void setHoeheBergstation(int hoeheBergstation) {
		this.hoeheBergstation = hoeheBergstation;
	}
	
	public int getHoehendifferenz() {
		return hoehendifferenz;
	}
	
	public void setHoehendifferenz(int hoehendifferenz) {
		this.hoehendifferenz = hoehendifferenz;
	}
	
	public int getFoerderleistung() {
		return foerderleistung;
	}
	
	public void setFoerderleistung(int foerderleistung) {
		this.foerderleistung = foerderleistung;
	}
	
	public int getTransportkapazitaet() {
		return transportkapazitaet;
	}
	
	public void setTransportkapazitaet(int transportkapazitaet) {
		this.transportkapazitaet = transportkapazitaet;
	}

	@Override
	public String toString() {
		return "Schilift [id=" + id + ", name=" + name + ", plz=" + plz + ", gemeinde="
				+ gemeinde + ", baujahr=" + baujahr + ", typ=" + typ
				+ ", zubringerfunktion=" + zubringerfunktion + ", breite="
				+ breite + ", personenProAufhaengung=" + personenProAufhaengung
				+ ", sitzplatzheizung=" + sitzplatzheizung + ", wetterschutz="
				+ wetterschutz + ", einstiegshilfe=" + einstiegshilfe
				+ ", schraegeLaenge=" + schraegeLaenge + ", hoeheTalstation="
				+ hoeheTalstation + ", hoeheBergstation=" + hoeheBergstation
				+ ", hoehendifferenz=" + hoehendifferenz + ", foerderleistung="
				+ foerderleistung + ", transportkapazitaet="
				+ transportkapazitaet + "]";
	}
}
