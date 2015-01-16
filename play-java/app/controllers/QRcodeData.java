package controllers;

import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;

public class QRcodeData {
	// TODO: Attribute sollten private sein und für userID und location sollten getter-Methoden verfügbar sein.
	public Integer userID;
	public LocalDateTime Start;
	public LocalDateTime End;
	public Integer Location;

	// TODO: Konstruktor ist nicht wirklich benutzerfreundlich, besser wäre wenn
	// man nur 2 Parameter (StartDate, EndDate) übergeben muss. Das kann gelöst
	// werden indem man z.B. den aktuellen Konstruktor ändert oder einen
	// zusätzlichen Konstruktor anlegt.
	
	// Constructor
	public QRcodeData(Integer userID, Integer StartYear, Integer StartMonth,
			Integer StartDay, Integer StartMinute, Integer StartHour,
			Integer EndYear, Integer EndMonth, Integer EndDay,
			Integer EndMinute, Integer EndHour, Integer Location) {
		this.userID = userID;
		this.Start = new LocalDateTime(StartYear, StartMonth, StartDay,
				StartHour, StartMinute);
		this.End = new LocalDateTime(EndYear, EndMonth, EndDay, EndHour,
				EndMinute);
		this.Location = Location;

	}

	// TODO: hier könnte man die toString() Methode überschreiben, um einheitlich zu bleiben.
	public String InfoToString() { // Creates a String out of all the
									// Information
		String string = this.userID.toString() + this.Start.toString()
				+ this.End.toString() + this.Location.toString();
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

	public String leftTime() { // returns String with left Time from now until
								// end
		String left = "Days: " + getLeftDays().toString() + "   Hours: "
				+ getLeftHours().toString() + "   Minutes: "
				+ getLeftMinutes().toString();
		return left;
	}
}
