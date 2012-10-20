/** 
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Administration {

	ArrayList<Event> events;
	ArrayList<Member> members;
	ArrayList<Song> songs;
	ArrayList<Transaction> transactions;

	public Administration() {

		events = new ArrayList<Event>();
		members = new ArrayList<Member>();
		songs= new ArrayList<Song>();
		transactions = new ArrayList<Transaction>();
	}

	/**
	 * Fuegt eine Probe zur Datenbank hinzu. Dabei wird die dazugehoerige Transaktion zu der Liste aller
	 * Transaktionen hinzugefuegt.
	 * @param r : die Probe die hinzugefuegt werden soll
	 */

	public void addRehearsal(Rehearsal r) {

		events.add(r);
		r.getCorrespondingTransaction().setCorrespondingEvent(r);
		r.getCorrespondingTransaction().setDate(r.getDate());
		transactions.add(r.getCorrespondingTransaction());
	}

	/**
	 * Fuegt einen Auftritt zur Datenbank hinzu. Dabei wird die dazugehoerige Transaktion zu der Liste aller
	 * Transaktionen hinzugefuegt.
	 * @param g : der Auftritt der hinzugefuegt werden soll
	 */

	public void addGig(Gig g) {

		events.add(g);
		g.getCorrespondingTransaction().setCorrespondingEvent(g);
		g.getCorrespondingTransaction().setDate(g.getDate());
		transactions.add(g.getCorrespondingTransaction());
	}
	
	public boolean updateEvent(String place, Date date, String newPlace) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			tmp.update(newPlace);
			return true;

		} else {

			return false;
		}
	}
	
	public boolean updateEvent(String place, Date date, Date newDate) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			tmp.update(newDate);
			return true;

		} else {

			return false;
		}
	}


	public boolean updateEvent(String place, Date date, int newDuration) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			tmp.update(newDuration);
			return true;

		} else {

			return false;
		}
	}

	public boolean resetEventPlace(String place, Date date) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			return tmp.resetPlace();

		} else {

			return false;
		}
	}
	
	public boolean resetEventDate(String place, Date date) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			return tmp.resetDate();

		} else {

			return false;
		}
	}
	
	public boolean resetEventDuration(String place, Date date) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			return tmp.resetDate();

		} else {

			return false;
		}
	}


	/**
	 * Methode zum Hinzufuegen einer Transaktion
	 * @param t
	 */

	public void addTransaction(Transaction t) {
		transactions.add(t);
	}

	public void addSong(Song s){

		songs.add(s);
	}

	/**
	 * Methdode zum Entfernen eines Songs. Der Song wird dabei nicht tatsaechlich entfernt, sondern nur das Enddatum festgelegt.
	 * Das Enddatum wird auf den Zeitpunkt des Methodenaufrufes gesetzt.
	 * @param m
	 */
	public void removeSong(Song s) {

		s.setEndDate(new Date());
	}

	public void addMember(Member m) {

		members.add(m);
	}

	/**
	 * Methdode zum Entfernen eines Mitglieds. Das Mitglied wird dabei nicht tatsaechlich entfernt, sondern nur das Austrittsdatum festgelegt.
	 * Das Austrittsdatum wird auf den Zeitpunkt des Methodenaufrufes gesetzt.
	 * @param m
	 */
	public void removeMember(Member m) {

		m.setMemberUntil(new Date());
	}

	/**
	 * Liefert alle derzeit in der Band befindlichen Mitglieder
	 * null-Wert sagt aus, das das Mitglied noch kein Austrittsdatum hat, es ist also noch in der Band.
	 */
	public ArrayList<Member> getCurrentMembers() {

		ArrayList<Member> output = new ArrayList<Member>(members);

		for (Member m : members) {

			if ( m.getMemberUntil() != null ) {

				output.remove(m);
			}
		}
		return output;
	}

	/**
	 * Liefert alle zum uebergebenen Zeitpunkt aktiven Mitglieder der Band
	 * @param d
	 * 		frueherer Zeitpunkt
	 * @return
	 */
	public ArrayList<Member> getMembers(Date d) {

		ArrayList<Member> output = new ArrayList<Member>(members);

		for (Member m : members) {

			if ( m.getMemberFrom().after(d) ) {

				output.remove(m);
			}

			if ( m.getMemberUntil() != null && m.getMemberUntil().before(d) ) {

				output.remove(m);
			}
		}
		return output;
	}

	/**
	 * Liefert alle derzeit im Reportoire befindlichen Songs
	 * null-Wert sagt aus, das der Song noch immer gespielt wird, es also noch kein Enddatum gibt.
	 */
	public ArrayList<Song> getCurrentSongs() {

		ArrayList<Song> output = new ArrayList<Song>(songs);

		for (Song s : songs) {

			if ( s.getEndDate()!=null ) {

				output.remove(s);
			}
		}
		return output;
	}

	/**
	 * Liefert alle zum uebergebenen Zeitpunkt im Reportoire befindlichnen Songs der Band
	 * @param d
	 * 		frueherer Zeitpunkt
	 * @return
	 */
	public ArrayList<Song> getSongs(Date d) {

		ArrayList<Song> output = new ArrayList<Song>(songs);

		for (Song s : songs) {

			if ( s.getReleaseDate().after(d) ) {

				output.remove(s);
			}

			if ( s.getEndDate() != null && s.getEndDate().before(d) ) {

				output.remove(s);
			}
		}
		return output;
	}

	/**
	 * Liefert alle Events im Zeitfenster zwischen from und until
	 * Uebergibt an die ueberladene Methode zusaetzlich den String "Both", was bedeutet, dass beides, Proben und Auftritte ausgewaehlt werden.
	 * @param from
	 * @param until
	 * @return
	 */
	public ArrayList<Event> getEvents(Date from, Date until) {

		return getEvents(from, until, "Both");	
	}

	/**
	 * Ueberladene Methode
	 * Liefert alle Events im Zeitfenster zwischen from und until
	 * Der String type muss entweder den Wert "Rehearsal", den Wert "Gig", oder den Wert "Both" haben.
	 * "Both" kann auch von der ueberladenen Methode ohne String type übergeben werden.
	 * @param from
	 * 			Datum, Anfang des Zeitfensters
	 * @param until
	 * 			Datum, Ende des Zeitfensters
	 * @param type
	 * 			bestimmt, ob sich die Abfrage nur auf Proben, nur auf Auftritte, oder auf beides bezieht.
	 * @return
	 */
	public ArrayList<Event> getEvents(Date from, Date until, String type) {

		assert type.equals("Rehearsal") || type.equals("Gig") || type.equals("Both") : "String type nicht \"Rehearsal\", \"Gig\" oder \"Both\"";

		ArrayList<Event> tmpList;
		ArrayList<Event> output = new ArrayList<Event>();

		if (type.equals("Rehearsal")) {

			tmpList = extractSpecialEvents(events, Rehearsal.class);

		} else if (type.equals("Gig")) {

			tmpList = extractSpecialEvents(events, Gig.class);

		} else { //type ist "Both"

			tmpList = new ArrayList<Event>(events);
		}

		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				output.add(e);
			}
		}
		return output;
	}

	/**
	 * Diese Methode gibt den aktuellen Kontostand zurŸck.
	 * Zur Auswertung werden alle Transaktionen verwendet.
	 * @return
	 */

	public float getBalance() {
		float balance = 0;

		for(Transaction t :transactions) {
			balance += t.getValue();
		}

		return balance;		
	}

	/**
	 *
	 * Liefert eine Bilanz aus Summe der Einnahmen und  Ausgaben im Zeitfenster zwischen from und until
	 * Uebergibt an die ueberladene Methode zusaetzlich den String "Both", was bedeutet, dass beides, Proben und Auftritte ausgewaehlt werden. 
	 * @param from
	 * @param until
	 * @return
	 */
	public int financials(Date from, Date until) {

		return financials(from, until, "Both");
	}

	/**
	 * Ueberladene Methode
	 * Liefert eine Bilanz im Zeitfenster zwischen from und until, wobei zwischen Proben, Auftritten und beidem gewaehlt werden kann.
	 * Der String type muss entweder den Wert "Rehearsal", den Wert "Gig", oder den Wert "Both" haben.
	 * "Both" kann auch von der ueberladenen Methode ohne String type uebergeben werden.
	 * Das aussortieren übernimmt die Methode getEvents(from, until, type)
	 * @param from
	 * @param until
	 * @param type
	 * @return
	 */
	public int financials(Date from, Date until, String type) {

		assert type.equals("Rehearsal") || type.equals("Gig") || type.equals("Both") : "String type nicht \"Rehearsal\", \"Gig\" oder \"Both\"";

		ArrayList<Event> tmpList = getEvents(from, until, type);
		int budget = 0;

		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				budget += e.getFinances();
			}
		}

		return budget;
	}

	/**
	 * Methode liefert alle Transaktionen zurŸck die einen Wert ungleich 0 besitzen
	 * @return
	 */

	public ArrayList<Transaction> getTransactions() {

		ArrayList<Transaction> output = new ArrayList<Transaction>();

		for(Transaction t :transactions) {
			if(t.getValue() != 0) {
				output.add(t);
			}
		}

		return output;
	}

	/**
	 * Methode zum Extrahieren der Auftritte/Proben aus der Eventliste.
	 * @param events
	 * @param c
	 * 		ist entweder die Klasse Rehearal oder die Klasse Gig
	 * @return
	 */
	private ArrayList<Event> extractSpecialEvents(ArrayList<Event> events, Class<? extends Event> c) {

		ArrayList<Event> output = new ArrayList<Event>();

		for (Event e : events) {

			if (e.getClass() == c) {

				output.add(e);
			}
		}
		return output;
	}
	

	private Event getEvent(String place, Date date) {

		Iterator<Event> iterator = events.iterator();
		Event output = null;
		boolean found = false;

		while (iterator.hasNext() && !found ) {

			output = iterator.next();

			if (output.isEqual(place, date)) {

				found = true;
			}
		}

		return output;
	}

}
