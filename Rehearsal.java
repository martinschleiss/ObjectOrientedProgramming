/**
 * @version 1.0
 */

import java.util.Date;

public class Rehearsal extends Event {
	
	public Rehearsal( String place, Date date, int duration, Transaction rent){

		super(place, date, duration, rent);
	}
	
	/**
	 * Einnahmen werden als positive Zahl ausgegeben, Ausgaben als negative.
	 */
	public int getFinances() {
		
		return -(int)ta.get(ta.size()-1).getValue();
	}
	
	public String toString() {
		
		return "Probe: " + super.toString() + ", Rent: " + ta.get(ta.size()-1) + "Euro";
	}
}
