package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;

import play.db.ebean.Model;
import controllers.HashManager;

@Entity
public class QRcodeData extends Model{

	private static final long serialVersionUID = 8052894568875887475L;

	@Id
	private Long id;
	
	// Keine Referenz auf User, weil SQLite das ADD Constraint im ALTER TABLE nicht unterstützt.
	private String userEmail;
	private LocalDateTime Start;
	private LocalDateTime End;
	private String Gemeinde;
	private String HashCode;
	
	public static Finder<Long, QRcodeData> find = new Finder<Long, QRcodeData>(Long.class, QRcodeData.class);

	// Constructor
	public QRcodeData(String userEmail, Integer StartYear, Integer StartMonth,
			Integer StartDay, Integer StartMinute, Integer StartHour,
			Integer EndYear, Integer EndMonth, Integer EndDay,
			Integer EndMinute, Integer EndHour, String Gemeinde) {
		this.userEmail = userEmail;
		this.Start = new LocalDateTime(StartYear, StartMonth, StartDay,
				StartHour, StartMinute);
		this.End = new LocalDateTime(EndYear, EndMonth, EndDay, EndHour,
				EndMinute);
		this.Gemeinde = Gemeinde;
		this.HashCode=this.toHash();
	}
	
	public QRcodeData(String userEmail, LocalDateTime Start, LocalDateTime End, String Gemeinde){
		this.userEmail = userEmail;
		this.Gemeinde = Gemeinde;
		this.Start=Start;
		this.End=End;
		this.HashCode=this.toHash();
	}
	
	public QRcodeData(String userEmail, String startdatetime, String enddatetime,String gemeinde) { // zb. 01/14/2015 11:21 AM
		this.userEmail = userEmail;
	    this.Start = LocalDateTime.parse(startdatetime, DateTimeFormat.forPattern("MM/dd/yyyy KK:mm aa"));
	    this.End = LocalDateTime.parse(enddatetime, DateTimeFormat.forPattern("MM/dd/yyyy KK:mm aa"));
	    this.Gemeinde=gemeinde;
	    this.HashCode = toHash();
	}
	
	public String getStartDateTimeString() {
		return Start.toString(DateTimeFormat.forPattern("MM/dd/yyyy KK:mm aa"));
	}
	
	public String getEndDateTimeString() {
		return End.toString(DateTimeFormat.forPattern("MM/dd/yyyy KK:mm aa"));
	}

	public String toString() { //overwrites toString() and Creates a String out of all the Information
		String string = this.userEmail + this.Start.toString()+ this.End.toString() + Gemeinde;
		return string;
	}

	public Boolean isValid() { // checks if Ticket is still valid
		if (End.isAfter(LocalDateTime.now())
				&& Start.isBefore(LocalDateTime.now())) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getLeftDays() { // returns Integer with left Days from now
									// until end
		return Days.daysBetween(LocalDateTime.now(), End).getDays();

	}

	public Integer getLeftHours() { // returns Integer with left Hours from now
									// until end
		return Hours.hoursBetween(LocalDateTime.now(), End).getHours() % 24;
	}

	public Integer getLeftMinutes() { // returns Integer with left Minutes from
										// now until end
		return Minutes.minutesBetween(LocalDateTime.now(), End).getMinutes() % 60;
	}

	public String leftTime() { // returns String with left Time from now until end
		if(!isValid()) return "QR-Code ist abgelaufen.";
		StringBuilder sb = new StringBuilder();
		sb.append("Noch ");
		if(getLeftDays()>0) sb.append(getLeftDays()).append(" Tage "); 
		if(getLeftHours()>0) sb.append(getLeftHours()).append(" Stunden ");
		if(getLeftMinutes()>0) sb.append(getLeftMinutes()).append(" Minuten ");
		else sb.append("weniger als eine Minute ");
		sb.append("gültig.");
		return sb.toString();
	}
		
	
	private String toHash() { // creates a Hash with a QRcodeData
		HashManager x=HashManager.getInstance();
		String DataString = this.toString();
		String codeString = x.codeString(DataString);
		return codeString;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getGemeinde() {
		return Gemeinde;
	}

	public void setLocation(String Gemeinde) {
		this.Gemeinde = Gemeinde;
	}
	
	public String getHashCode(){
		return this.HashCode;
	}
}