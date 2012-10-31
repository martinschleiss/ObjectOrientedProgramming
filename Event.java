/**
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;

public abstract class Event {

	private ArrayList<String> place;
	private ArrayList<Date> date;
	private ArrayList<Integer> duration; //in Minuten
	protected ArrayList<Transaction> ta;
	
	/**
	 * Vorbedingung: der Wert ta, date und place duerfen nicht null sein
	 * Nachbedingung: die Klasse Event muss erfolgreich initialisiert sein
	 * @param place
	 * @param date
	 * @param duration
	 * @param ta
	 */
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
	 * Abstrakte Methode zur Rueckgabe der Kosten/Einnahmen.
	 * Mieten und Gagen werden als positive Zahl gespeichert. getFinance() retourniert Ausgaben (z.B. Mieten) mit negativem Vorzeichen,
	 * und Einnahmen (z.B. Gagen) mit positivem Vorzeichen, um in einer umfassenden Addition alle Werte leicht zusammenrechnen zu koennen.
	 * @return (vorzeichenbehafteter) Kostenfaktor  
	 */
	public abstract int getFinances();
	
	/**
	 * Vorbedingung: es muss bisher mindestens eine Transaktion mit dem Event in Verbindung gestanden sein
	 * @return
	 */
	public Transaction getCorrespondingTransaction() {
		return ta.get(ta.size()-1);
	}
	
	public Date getDate() {
		
		return date.get(date.size()-1);
	}
	
	public String getPlace() {
		
		return place.get(place.size()-1);
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
	
	/**
	 * erlaubt zuruecksetzen des Orts auf den alten Wert, sofern einer vorhanden ist.
	 * @return
	 */
	public boolean resetPlace() {
		
		if ( place.size() > 1 ) {
			
			place.remove(place.size()-1);
			return true;
			
		} else {
			
			return false;
		}

	}
	
	/**
	 * erlaubt zuruecksetzen des Datums auf den alten Wert, sofern einer vorhanden ist.
	 * @return
	 */
	public boolean resetDate() {
		
		if ( date.size() > 1 ) {
			
			date.remove(date.size()-1);
			return true;
			
		} else {
			
			return false;
		}

	}
	
	/**
	 * erlaubt zuruecksetzen der Dauer auf den alten Wert, sofern einer vorhanden ist.
	 * @return
	 */
	public boolean resetDuration() {
		
		if ( duration.size() > 1 ) {
			
			duration.remove(duration.size()-1);
			return true;
			
		} else {
			
			return false;
		}

	}

	/**
	 * Vergleichsmethode fuer Events (ich weiss schon: besser equals ueberschreiben :-))
	 * @param place
	 * @param date
	 * @return
	 */
	public boolean isEqualEvent(String place, Date date) {
		
		return this.place.get(this.place.size()-1).equals(place) && this.date.get(this.date.size()-1).equals(date);
	}

	public String toString() {
		
		return "Ort: " + place.get(place.size()-1) + ", Datum: " + date.get(date.size()-1) + ", Dauer: " + duration.get(duration.size()-1) + " min";
	}
	
}
