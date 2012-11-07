/**
 * @version 1.0
 */

import java.util.Date;

public class Gig extends Event {

	/**
	 * Vorbedingungen:
	 * @see Event#Event(String, Date, int, Transaction)
	 * @param ta 	not null
	 */
	public Gig( String place, Date date, int duration, Transaction ta) {

		super(place, date, duration, ta);
	}
	
	/**
	 * Nachbedingung: 
	 * 			Liefert die aktuellst gesetzte Gage als positiven Wert
	 *SCHLECHT: Cast auf int statt Waehrungseinheit als Rueckgabewert
	 */
	public int getFinances() {
		
		return (int) getCorrespondingTransaction().getValue();
	}
	
	/**
	 * Nachbedingung:
	 * 		Liefert eine String-Repraesentation der Instanz
	 */
	public String toString() {
		
		return "Gig: " + super.toString() + ", Gage: " + getCorrespondingTransaction() + "Euro";
	}
}
