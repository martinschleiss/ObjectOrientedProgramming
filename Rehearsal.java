/**
 * @version 1.0
 */

import java.util.Date;

public class Rehearsal extends Event {
	
	/**
	 * Vorbedingungen:
	 * @see Event#Event(String, Date, int, Transaction)
	 * @param rent not null
	 */
	public Rehearsal( String place, Date date, int duration, Transaction rent){

		super(place, date, duration, rent);
	}
	
	/**
	 * Nachbedingung: 
	 * 			Liefert die aktuellst gesetzte Miete als negativen Wert
	 *SCHLECHT: Cast auf int statt double als Rueckgabewert
	 */
	public int getFinances() {
		
		return -(int)ta.get(ta.size()-1).getValue();
	}
	
	public String toString() {
		
		return "Probe: " + super.toString() + ", Rent: " + ta.get(ta.size()-1) + "Euro";
	}
}
