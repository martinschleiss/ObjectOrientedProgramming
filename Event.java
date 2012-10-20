/**
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;

public abstract class Event implements Comparable<Event> {

	private ArrayList<String> place;
	private ArrayList<Date> date;
	private ArrayList<Integer> duration; //in Minuten
	protected ArrayList<Transaction> ta;

	public Event(String place, Date date, int duration, Transaction ta) {
		
		this.place = new ArrayList<String>();
		this.place.add(place);
		this.date = new ArrayList<Date>();
		this.date.add(date);
		this.duration = new ArrayList<Integer>();
		this.duration.add(duration);
		this.ta = new ArrayList<Transaction>();
		this.ta.add(ta);
	}
	
	/**
	 * Abstrakte Methode zur Rückgabe der Kosten/Einnahmen.
	 * Mieten und Gagen werden als positive Zahl gespeichert. getFinance() retourniert Ausgaben (z.B. Mieten) mit negativem Vorzeichen,
	 * und Einnahmen (z.B. Gagen) mit positivem Vorzeichen, um in einer umfassenden Addition alle Werte leicht zusammenrechnen zu können.
	 * @return (vorzeichenbehafteter) Kostenfaktor  
	 */
	public abstract int getFinances();
	
	public Transaction getCorrespondingTransaction() {
		return ta.get(ta.size()-1);
	}
	
	public Date getDate() {
		
		return date.get(date.size()-1);
	}
	
	/**
	 * Vergleichbar anhand des Datums. Späteres Datum bedeutet größere Ordnung, früheres Datum bedeutet kleinere Ordnung.
	 */
	public int compareTo(Event that) {
		
		int compare = 0;
		
		if ( this.date.get(date.size()-1).after(that.getDate()) ) {
			
			compare = 1;
			
		} else {
			
			if (this.date.get(date.size()-1).before(that.getDate()) ) {
				
				compare = -1;
			}
		}
		return compare;
	}

	
	public void update(String place) {
		
		this.place.add(place);
	}
	
	public void update(Date date) {
		
		this.date.add(date);
	}
	
	public void update(int duration) {
		
		this.duration.add(duration);
	}
	
	public boolean resetPlace() {
		
		if ( place.size() > 1 ) {
			
			place.remove(place.size()-1);
			return true;
			
		} else {
			
			return false;
		}

	}
	public boolean resetDate() {
		
		if ( date.size() > 1 ) {
			
			date.remove(date.size()-1);
			return true;
			
		} else {
			
			return false;
		}

	}
	public boolean resetDuration() {
		
		if ( duration.size() > 1 ) {
			
			duration.remove(duration.size()-1);
			return true;
			
		} else {
			
			return false;
		}

	}

	public boolean isEqual(String place, Date date) {
		
		return this.place.get(this.place.size()-1).equals(place) && this.date.get(this.date.size()-1).equals(date);
	}

	public String toString() {
		
		return "Place: " + place.get(place.size()-1) + ", Date: " + date.get(date.size()-1) + ", Duration: " + duration.get(duration.size()-1) + " min";
	}
	
}
