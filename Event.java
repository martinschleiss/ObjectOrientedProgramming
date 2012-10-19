/**
 * @version 1.0
 */

import java.util.Date;

public abstract class Event implements Comparable<Event> {

	private String place;
	private Date date;
	private int duration; //in Minuten
	protected Transaction ta;

	public Event(String place, Date date, int duration, Transaction ta) {
		this.place = place;
		this.date = date;
		this.duration = duration;
		this.ta = ta;
	}
	
	/**
	 * Abstrakte Methode zur Rückgabe der Kosten/Einnahmen.
	 * Mieten und Gagen werden als positive Zahl gespeichert. getFinance() retourniert Ausgaben (z.B. Mieten) mit negativem Vorzeichen,
	 * und Einnahmen (z.B. Gagen) mit positivem Vorzeichen, um in einer umfassenden Addition alle Werte leicht zusammenrechnen zu können.
	 * @return (vorzeichenbehafteter) Kostenfaktor  
	 */
	public abstract int getFinances();
	
	public Transaction getCorrespondingTransaction() {
		return ta;
	}

	public Date getDate() {
		
		return date;
	}
	
	/**
	 * Vergleichbar anhand des Datums. Späteres Datum bedeutet größere Ordnung, früheres Datum bedeutet kleinere Ordnung.
	 */
	public int compareTo(Event that) {
		
		int compare = 0;
		
		if ( this.date.after(that.getDate()) ) {
			
			compare = 1;
			
		} else {
			
			if (this.date.before(that.getDate()) ) {
				
				compare = -1;
			}
		}
		return compare;
	}
	
	public String toString() {
		
		return "Place: " + place + ", Date: " + date + ", Duration: " + duration + " min";
	}
	
}
