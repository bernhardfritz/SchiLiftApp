package models;

import java.util.ArrayList;

import javax.persistence.Entity;

import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import play.db.ebean.Model;
import controllers.HashManager;

@Entity
public class QRcodeData {

	private static final long serialVersionUID = 8052894568875887475L;

	private Integer userID;
	private LocalDateTime Start;
	private LocalDateTime End;
	private String Gemeinde;
	private String HashCode;
	
	//public static Finder<Integer, QRcodeData> find = new Finder<Integer, QRcodeData>(Integer.class, QRcodeData.class);

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
	
	/*public QRcodeData(String data){ //Constructor for a String (!! 2015/1/1 12:01 muss als 201501011201 geschrieben werden!!)
		char[] dataarray= data.toCharArray(); 
		this.userID=Character.getNumericValue(dataarray[0])*1000+Character.getNumericValue(dataarray[1])*100+Character.getNumericValue(dataarray[2])*10+Character.getNumericValue(dataarray[3]);
		Integer StartYear=Character.getNumericValue(dataarray[4])*1000+Character.getNumericValue(dataarray[5])*100+Character.getNumericValue(dataarray[6])*10+Character.getNumericValue(dataarray[7]);
		Integer StartMonth= Character.getNumericValue(dataarray[8])*10+Character.getNumericValue(dataarray[9]);
		Integer StartDay=Character.getNumericValue(dataarray[10])*10+Character.getNumericValue(dataarray[11]);
		Integer StartHour=Character.getNumericValue(dataarray[12])*10+Character.getNumericValue(dataarray[13]);
		Integer StartMinute=Character.getNumericValue(dataarray[14])*10+Character.getNumericValue(dataarray[15]);
		Integer EndYear=Character.getNumericValue(dataarray[16])*1000+Character.getNumericValue(dataarray[17])*100+Character.getNumericValue(dataarray[18])*10+Character.getNumericValue(dataarray[19]);
		Integer EndMonth= Character.getNumericValue(dataarray[20])*10+Character.getNumericValue(dataarray[21]);
		Integer EndDay=Character.getNumericValue(dataarray[22])*10+Character.getNumericValue(dataarray[23]);
		Integer EndHour=Character.getNumericValue(dataarray[24])*10+Character.getNumericValue(dataarray[25]);
		Integer EndMinute=Character.getNumericValue(dataarray[26])*10+Character.getNumericValue(dataarray[27]);
		this.Start = new LocalDateTime(StartYear, StartMonth, StartDay,StartHour, StartMinute);
		this.End = new LocalDateTime(EndYear, EndMonth, EndDay, EndHour,EndMinute);
		String Gemeinde="";
		for (int i=28; i<dataarray.length; i++){
			Gemeinde+=dataarray[i];
		}
		this.Gemeinde= Gemeinde;
		this.HashCode=this.toHash();
	}*/
	
	public QRcodeData(Integer userID,String startdatetime, String enddatetime,String gemeinde) { // zb. 01/14/2015 11:21 AM
		this.userID=userID;
	    Start = LocalDateTime.parse(startdatetime, DateTimeFormat.forPattern("MM/dd/yyyy KK:mm aa"));
	    End = LocalDateTime.parse(enddatetime, DateTimeFormat.forPattern("MM/dd/yyyy KK:mm aa"));
	    this.Gemeinde=gemeinde;
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
		String left = null;
		if (getLeftDays()>0){
		left = "Verbliebene Zeit\nTage: " + getLeftDays().toString() + "   Stunden: "
				+ getLeftHours().toString() + "   Minuten: "
				+ getLeftMinutes().toString();
		}else{
			if (getLeftHours()>0){
			left =  "Verbliebene Zeit\nStunden: "
					+ getLeftHours().toString() + "   Minuten: "
					+ getLeftMinutes().toString();
			}else{
				left =  "Verbliebene Zeit\nMinuten: "
						+ getLeftMinutes().toString();
				}
			}
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