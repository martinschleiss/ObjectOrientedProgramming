/**
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;

public abstract class Event {

	private ArrayList<String> place;
	private ArrayList<Date> date;
	
	/**
	 * Invariante: duration ist immer > 0
	 */
	private ArrayList<Integer> duration;
	private ArrayList<Transaction> ta;
	
	/**
	 * Vorbedingungen:
	 * @param place			not null
	 * @param date			not null
	 * @param duration		> 0
	 * @param ta			not null
	 * Nachbedingung: die Klasse Event ist erfolgreich initialisiert
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
	 * Nachbedingung:
	 * @return die aktuell gesetzte Transaktion (kann durch Update oder Reset veraendert werden)
	 */
	public Transaction getCorrespondingTransaction() {
		return ta.get(ta.size()-1);
	}
	
	/**
	 * Nachbedingungen:
	 * @return	das aktuell gesetzte Datum (kann durch Update oder Reset veraendert werden)
	 */
	public Date getDate() {
		
		return date.get(date.size()-1);
	}
	
	/**
	 * Nachbedingungen:
	 * @return	den aktuell gesetzten Ort (kann durch Update oder Reset veraendert werden)
	 */
	public String getPlace() {
		
		return place.get(place.size()-1);
	}
	
	/**
	 * Vorbedingungen:
	 * @param place		not null
	 * Nachbedingungen:
	 * 					der neue Ort place wird gespeichert und ist als aktueller Ort ueber getPlace() aufrufbar
	 */
	public void update(String place) {
		
		this.place.add(place);
	}
	
	/**
	 * Vorbedingungen:
	 * @param date		not null
	 * Nachbedingungen:
	 * 					das neue Datum date wird gespeichert und ist als aktuelles Datum ueber getDate() aufrufbar
	 */
	public void update(Date date) {
		
		this.date.add(date);
	}
	
	/**
	 * Vorbedingungen:
	 * @param duration		not null
	 * Nachbedingungen:	
	 * 						di neue Dauer duration wird gespeichert und ist als aktuelle Dauer ueber getDuration() aufrufbar
	 */	
	public void update(int duration) {
		
		this.duration.add(duration);
	}
	
	/**
	 * Nachbedingungen:	
	 * @return		true, wenn Ort erfolgreich zurueckgesetzt werden konnte, also wenn zuvor schon ein Wert gespeichert war 
	 * 				(Der Wert, der vor dem Reset aktuell war, geht dabei verloren)
	 * 				false, wenn es keinen frueheren Eintrag gibt (dann passiert auch nichts)
	 * Invariante:
	 * 				es bleibt mindestens ein Ort immer gespeichert
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
	 * Nachbedingungen:	
	 * @return		true, wenn Datum erfolgreich zurueckgesetzt werden konnte, also wenn zuvor schon ein Wert gespeichert war 
	 * 				(Der Wert, der vor dem Reset aktuell war, geht dabei verloren)
	 * 				false, wenn es keinen frueheren Eintrag gibt (dann passiert auch nichts)
	 * Invariante:
	 * 				es bleibt mindestens ein Datum immer gespeichert
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
	 * Nachbedingungen:	
	 * @return		true, wenn Dauer erfolgreich zurueckgesetzt werden konnte, also wenn zuvor schon ein Wert gespeichert war 
	 * 				(Der Wert, der vor dem Reset aktuell war, geht dabei verloren)
	 * 				false, wenn es keinen frueheren Eintrag gibt (dann passiert auch nichts)
	 * Invariante:
	 * 				es bleibt mindestens eine Dauer immer gespeichert
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
	 * SCHLECHT: besser equals ueberschreiben
	 */
	public boolean isEqualEvent(String place, Date date) {
		
		return this.place.get(this.place.size()-1).equals(place) && this.date.get(this.date.size()-1).equals(date);
	}

	/**
	 * Nachbedingung:
	 * 		Liefert eine String-Repraesentation der Instanz
	 */
	public String toString() {
		
		return "Ort: " + place.get(place.size()-1) + ", Datum: " + date.get(date.size()-1) + ", Dauer: " + duration.get(duration.size()-1) + " min";
	}
	
}
