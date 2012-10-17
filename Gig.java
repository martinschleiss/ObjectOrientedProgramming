/**
 * @version 1.0
 */

import java.util.Date;

public class Gig extends Event {

	private int gage;
	
	public Gig( String place, Date date, int duration, int gage ) {

		super(place, date, duration);
		this.gage = gage;
	}
	
	/**
	 * Einnahmen werden als positive Zahl ausgegeben, Ausgaben als negative.
	 */
	public int getFinances() {
		
		return gage;
	}
	
	public String toString() {
		
		return super.toString() + ", Gage: " + gage + "€";
	}
}
