package controllers;


import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;



public class QRcodeData {
	public Integer userID;
	public LocalDateTime Start;
	public LocalDateTime End;
	public Integer Location;
	
	//Constructor
	public QRcodeData(Integer userID,Integer StartYear,Integer StartMonth, Integer StartDay, Integer StartHour,Integer StartMinute,  Integer EndYear, Integer EndMonth, Integer EndDay, Integer EndHour,Integer EndMinute, Integer Location){
		this.userID=userID;
		this.Start = new LocalDateTime(StartYear, StartMonth, StartDay, StartHour, StartMinute);
		this.End= new LocalDateTime(EndYear, EndMonth, EndDay, EndHour, EndMinute);
		this.Location=Location;
		
	}
	
	public String InfoToString(){ //Creates a String out of all the Information 
		String string=this.userID.toString()+this.Start.toString()+this.End.toString()+this.Location.toString();
		return string;	
	}
	
	public Boolean isValid(){ //checks if Ticket is still valid
		if (End.isAfter(LocalDateTime.now()) && Start.isBefore(LocalDateTime.now())){
			return true;
		}else{
			return false;
		}
	}
	
	public Integer getLeftDays(){ //returns Integer with left Days from now until end
		  return Days.daysBetween(LocalDateTime.now(), End).getDays();
		  
	}
	public Integer getLeftHours(){ //returns Integer with left Hours from now until end
		 return Hours.hoursBetween(LocalDateTime.now(), End).getHours() % 24; 
	}
	
	public Integer getLeftMinutes(){ //returns Integer with left Minutes from now until end
		 return Minutes.minutesBetween(LocalDateTime.now(), End).getMinutes() % 60 ;
	}
	
	public String leftTime(){ //returns String with left Time from now until end
		String left= "Days: "+getLeftDays().toString()+"   Hours: "+getLeftHours().toString()+"   Minutes: "+getLeftMinutes().toString();
		return left;
	}
}
