/**
 * @version 1.0
 */

import java.util.Date;

public class Rehearsal extends Event {

	private int rent;
	
	public Rehearsal( String place, Date date, int duration, int rent ){

		super(place, date, duration);
		this.rent = rent;
	}
	
	/**
	 * Einnahmen werden als positive Zahl ausgegeben, Ausgaben als negative.
	 */
	public int getFinances() {
		
		return -rent;
	}
	
	public String toString() {
		
		return super.toString() + ", Rent: " + rent + "€";
	}
}
