/**
 * @version 1.0
 */

import java.util.Date;

public class Gig extends Event {

	public Gig( String place, Date date, int duration, Transaction ta) {

		super(place, date, duration, ta);
	}
	
	/**
	 * Einnahmen werden als positive Zahl ausgegeben, Ausgaben als negative.
	 */
	public int getFinances() {
		
		return (int)ta.get(ta.size()-1).getValue();
	}
	
	public String toString() {
		
		return "Gig: " + super.toString() + ", Gage: " + ta.get(ta.size()-1) + "Euro";
	}
}
