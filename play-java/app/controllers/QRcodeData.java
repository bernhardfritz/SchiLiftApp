package controllers;

import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;

public class QRcodeData {
	private Integer userID;
	private LocalDateTime Start;
	private LocalDateTime End;
	private String Gemeinde;
	private String HashCode;

	
	// Constructor
	public QRcodeData(Integer userID, Integer StartYear, Integer StartMonth,
			Integer StartDay, Integer StartMinute, Integer StartHour,
			Integer EndYear, Integer EndMonth, Integer EndDay,
			Integer EndMinute, Integer EndHour, String Gemeinde) {
		this.userID = userID;
		this.Start = new LocalDateTime(StartYear, StartMonth, StartDay,
				StartHour, StartMinute);
		this.End = new LocalDateTime(EndYear, EndMonth, EndDay, EndHour,
				EndMinute);
		this.Gemeinde = Gemeinde;
		this.HashCode=this.toHash();
	}
	
	public QRcodeData(Integer userID, LocalDateTime Start, LocalDateTime End, String Gemeinde){
		this.userID = userID;
		this.Gemeinde = Gemeinde;
		this.Start=Start;
		this.End=End;
		this.HashCode=this.toHash();
	}

	public String toString() { //overwrites toString() and Creates a String out of all the Information
		String string = this.userID.toString() + this.Start.toString()+ this.End.toString() + Gemeinde;
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
		String left = "Days: " + getLeftDays().toString() + "   Hours: "
				+ getLeftHours().toString() + "   Minutes: "
				+ getLeftMinutes().toString();
		return left;
	}
	
	private String toHash() { // creates a Hash with a QRcodeData
		HashManager x=HashManager.getInstance();
		String DataString = this.toString();
		String codeString = x.codeString(DataString);
		return codeString;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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