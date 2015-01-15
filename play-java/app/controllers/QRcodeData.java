package controllers;

public class QRcodeData {
	public Integer userID;
	public Integer StartYear;
	public Integer StartMonth;
	public Integer StartDay;
	public Integer StartMinute;
	public Integer StartHour;
	public Integer EndYear;
	public Integer EndMonth;
	public Integer EndDay;
	public Integer EndMinute;
	public Integer EndHour;
	public Integer Location;
	
	public QRcodeData(Integer userID,Integer StartYear,Integer StartMonth, Integer StartDay, Integer StartMinute, Integer StartHour, Integer EndYear, Integer EndMonth, Integer EndDay,Integer EndMinute, Integer EndHour, Integer Location){
		this.userID=userID;
		this.StartYear=StartYear;
		this.StartMonth=StartMonth;
		this.StartDay=StartDay;
		this.StartMinute=StartMinute;
		this.StartHour=StartHour;
		this.EndYear=EndYear;
		this.EndMonth=EndMonth;
		this.EndDay=EndDay;
		this.EndMinute=EndMinute;
		this.EndHour=EndHour;
		this.Location=Location;
		
	}
	
	public String InfoToString(){ //Creates a String out of all the Information 
		String string=this.userID.toString()+this.StartYear.toString()+this.StartMonth.toString()+this.StartDay.toString()+this.StartMinute.toString()+this.StartHour.toString()+this.EndYear.toString()+this.EndMonth.toString()+this.EndDay.toString()+this.EndMinute.toString()+this.EndHour.toString()+this.Location.toString();
		return string;
	}
	
}
