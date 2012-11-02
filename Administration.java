/** 
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Administration {

	/**
	 * SCHLECHT: (Klassenzusammenhalt) Klassenvariablen sind ohne Modifier definiert. Dadurch verlieren die setter und getter
	 * an Bedeutung da auch von anderen Klassen im selben Package die Variablen veraendern koennen 
	 */	

	private Band band;
	private ArrayList<Event> events;
	private ArrayList<Event> deletedEvents;
	private ArrayList<Member> members;
	private ArrayList<Song> songs;
	private ArrayList<Transaction> transactions;
	private ArrayList<Request> requests;
	private ArrayList<GigLocation> gigLocations;
	private ArrayList<RehearsalLocation> rehearsalLocations;

	/**
	 * Nachbedingung: alle Klassenvariablen muessen erfolgreich initialisiert sein
	 */
	public Administration() {

		band = new Band();
		events = new ArrayList<Event>();
		deletedEvents = new ArrayList<Event>();
		members = new ArrayList<Member>();
		songs= new ArrayList<Song>();
		transactions = new ArrayList<Transaction>();
		requests = new ArrayList<Request>();
		gigLocations =new ArrayList<GigLocation>();
		rehearsalLocations =new ArrayList<RehearsalLocation>();
	}

	/**
	 * Vorbedingung: der Wert r darf nicht NULL sein. Eventuelle Vorbedingungen in Request von der Methode
	 * broadcast()
	 * Nachbedingung: r muss in der Arraylist requests enthalten sein
	 * @param r
	 * @param furtherInfo
	 */
	
	//GUT: 	Die Klassen Administration und Request arbeiten weitgehend unabhaengig voneinander, die Objektkopplung ist sehr gering
	//		durch dynamisches Binden ist der Code sehr kompakt und es ist einfach, neue Requests hinzuzufuegen. 
	public void addRequest(Request r, String furtherInfo) {

		requests.add(r);
		r.broadcast(furtherInfo);
	}

	/**
	 * Vorbedingung: der Wert r darf nicht NULL sein. Eventuelle Vorbedingungen von execute in Request
	 * muessen erfuellt sein.
	 * Nachbedingung: falls r in requests enhalten war, muss es aus requests entfernt worden sein
	 * @param r
	 * @return
	 */
	public boolean executeRequest(Request r) {

		boolean executed = false;

		executed = r.execute();
		requests.remove(r);

		return executed;

	}

	/**
	 * Vorbedingung: der Wert e darf nicht NULL sein
	 * Nachbedingung: das Event muss in der Liste events enthalten sein. 
	 * Fuegt eine Probe zur Datenbank hinzu. Dabei wird die dazugehoerige Transaktion zu der Liste aller
	 * Transaktionen hinzugefuegt.
	 * @param r : die Probe die hinzugefuegt werden soll
	 */
	public void addEvent(Event e) {

		events.add(e);
		e.getCorrespondingTransaction().setCorrespondingEvent(e);
		e.getCorrespondingTransaction().setDate(e.getDate());
		transactions.add(e.getCorrespondingTransaction());
	}
	
	/**
	 * Vorbedingungen: 
	 * @param e		Event, das geloescht werden soll
	 * Nachbedingungen:
	 * @return		true, wenn Element gefunden wurde, Element wird geloescht
	 * 				false, wenn Element nicht gefunden wurde	
	 * Methode loescht Events nicht permanent. Geloeschte Events werden in einer eigenen ArrayList gespeichert
	 * und koennen wiederhergestellt werden
	 */
	public boolean deleteEvent(Event e) {

		boolean removed;

		removed = events.remove(e);

		if (removed) {
			deletedEvents.add(e);
		}
		return removed;
	}
	
	/**
	 * @param e		Event, das wiederhergestellt werden soll
	 * Nachbedingungen:
	 * @return		true, wenn Element gefunden wurde, Element wird wiederhergestellt und ist wieder in events gespeichert
	 * 				false, wenn Element nicht gefunden wurde
	 */
	public boolean restoreEvent(Event e) {

		if (deletedEvents.contains(e)) {

			events.add(e);
			deletedEvents.remove(e);
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Vorbedingung: eventuelle Vorbedinungen in Event von der Methode update(String) muessen erfuellt sein
	 * @param e
	 * @param newPlace
	 */
	public void updateEvent(Event e, String newPlace) {

		e.update(newPlace);
	}

	/**
	 * Vorbedingung: eventuelle Vorbedinungen in Event von der Methode update(int) muessen erfuellt sein
	 * @param e
	 * @param newDuration
	 */
	public void updateEvent(Event e, int newDuration) {

		e.update(newDuration);
	}

	/**
	 * Vorbedingung: eventuelle Vorbedinungen in Event von der Methode update(Date) muessen erfuellt sein
	 * @param e
	 * @param newDate
	 */
	public void postponeEvent(Event e, Date newDate) {

		e.update(newDate);
	}

	/**
	 * SCHLECHT: Uebergabe von place und date anstatt eines Events
	 * Vorbedingung: eventuelle Vorbedinungen in Event von der Methode resetPlace() muessen erfuellt sein
	 * Nachbedingung: der Ort des Events muss nicht unbedingt zurueckgesetzt worden sein, falls das Event
	 * nicht in events enthalten ist
	 * @param place
	 * @param date
	 * @return
	 */
	public boolean resetEventPlace(String place, Date date) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			return tmp.resetPlace();

		} else {

			return false;
		}
	}

	/**
	 * SCHLECHT: Uebergabe von place und date anstatt eines Events
	 * Vorbedingung: eventuelle Vorbedinungen in Event von der Methode resetDate() muessen erfuellt sein
	 * Nachbedingung: das Datum des Events muss nicht unbedingt zurueckgesetzt worden sein, falls das Event
	 * nicht in events enthalten ist
	 * @param place
	 * @param date
	 * @return
	 */
	public boolean resetEventDate(String place, Date date) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			return tmp.resetDate();

		} else {

			return false;
		}
	}

	/**
	 * SCHLECHT: Uebergabe von place und date anstatt eines Events
	 * FEHLER: Datum wird zurueckgesetzt und nicht die Dauer, wie es der Methodenkopf versprechen wuerde
	 * Vorbedingung: eventuelle Vorbedinungen in Event von der Methode resetDate() muessen erfuellt sein
	 * Nachbedingung: die Dauer des Events muss nicht unbedingt zurueckgesetzt worden sein, falls das Event
	 * nicht in events enthalten ist
	 * @param place
	 * @param date
	 * @return
	 */
	public boolean resetEventDuration(String place, Date date) {

		Event tmp = getEvent(place, date);

		if (tmp != null) {

			return tmp.resetDate();

		} else {

			return false;
		}
	}


	/**
	 * Vorbedingung: der Wert t darf nicht NULL sein
	 * Nachbedingung: t muss in transaction enthalten sein
	 * Methode zum Hinzufuegen einer Transaktion
	 * @param t
	 */
	public void addTransaction(Transaction t) {
		transactions.add(t);
	}

	/**
	 * Vorbedingung: Vorbedingungen von Band setReleaseSongDateList(Song, Date) und Member setSong(Song)
	 * muessen eventuell erfuellt sein
	 * Nachbedingung: jedes aktive Bandmitglied muss mit dem Song s in Verbindung stehen
	 * @param s
	 */
	public void addSong(Song s){

		band.setReleaseSongDateList(s, new Date());
		ArrayList<Member> am=new ArrayList<Member>();
		am=getCurrentMembers();

		for(Member m:am){
			m.setSong(s);
		}
	}

	/**
	 * Vorbedingung: Vorbedingungen von Band setEndDateSongList(Song, Date) und Member removeSong(Song)
	 * muessen eventuell erfuellt sein
	 * Nachbedingung: alle aktiven Bandmitglieder haben den Song aus ihrem Repoitoire gestrichen
	 * Methdode zum Entfernen eines Songs. Der Song wird dabei nicht tatsaechlich entfernt, sondern nur das Enddatum festgelegt.
	 * Das Enddatum wird auf den Zeitpunkt des Methodenaufrufes gesetzt.
	 * @param m
	 */
	public void removeSong(Song s) {

		band.setEndDateSongList(s, new Date());
		ArrayList<Member> am=new ArrayList<Member>();
		am=getCurrentMembers();

		for(Member m:am){
			m.removeSong(s);
		}
	}

	public void addMember(Member m) {

		band.setJoinMemberList(m, new Date());
	}

	/**
	 * Methdode zum Entfernen eines Mitglieds. Das Mitglied wird dabei nicht tatsaechlich entfernt, sondern nur das Austrittsdatum festgelegt.
	 * Das Austrittsdatum wird auf den Zeitpunkt des Methodenaufrufes gesetzt.
	 * @param m
	 */
	public void removeMember(Member m) {

		band.setLeaveMemberList(m, new Date());
	}

	/**
	 * Nachbedingung: Liefert eine Liste aller aktiven Bandmitglieder, kann auch eine leere Liste sein
	 * Liefert alle derzeit in der Band befindlichen Mitglieder
	 * null-Wert sagt aus, das das Mitglied noch kein Austrittsdatum hat, es ist also noch in der Band.
	 */
	public ArrayList<Member> getCurrentMembers() {

		HashMap<Member,Date> memberList=new HashMap<Member,Date>();

		memberList=band.getLeaveMemberList();

		ArrayList<Member> output = new ArrayList<Member>();

		for(Map.Entry<Member, Date> e : memberList.entrySet()){

			Member m = e.getKey();
			Date d = e.getValue();
			if(d==null){
				output.add(m);
			}
		}

		return output;
	}

	/**
	 * Nachbedingung: Liefert eine Liste aller Bandmitglierder zu einem gewissen Zeitpunkt. Kann auch
	 * eine Liste ohne Eintraege sein
	 * Liefert alle zum uebergebenen Zeitpunkt aktiven Mitglieder der Band
	 * @param d
	 * 		frueherer Zeitpunkt
	 * @return
	 */
	public ArrayList<Member> getMembers(Date d) {

		ArrayList<Member> output = new ArrayList<Member>();

		HashMap<Member,Date> memberListFrom=new HashMap<Member,Date>();
		HashMap<Member,Date> memberListUntil=new HashMap<Member,Date>();
		memberListFrom=band.getJoinMemberList();
		memberListUntil=band.getLeaveMemberList();

		for(Map.Entry<Member, Date> e : memberListFrom.entrySet()){
			Member m = e.getKey();
			Date da = e.getValue();

			if(da.before(d) && memberListUntil.get(m) ==null){
				output.add(m);
			}else if(da.before(d) && memberListUntil.get(m).after(d)){
				output.add(m);
			}

		}
		return output;
	}

	/**
	 * Liefert alle derzeit im Reportoire befindlichen Songs
	 * null-Wert sagt aus, das der Song noch immer gespielt wird, es also noch kein Enddatum gibt.
	 */
	public ArrayList<Song> getCurrentSongs() {

		ArrayList<Member> am=new ArrayList<Member>();
		am=getCurrentMembers();

		Member first=am.get(0);

		ArrayList<Song> firstSongs = new ArrayList<Song>();
		firstSongs=first.getSongs();
		ArrayList<Song> output = new ArrayList<Song>();
		Boolean check=false;
		int counter=0;
		for(Song s: firstSongs){
			for(Member m: am){

				ArrayList<Song> nSongs = new ArrayList<Song>();
				nSongs=m.getSongs();

				for(Song sn: nSongs){
					if(sn==s){
						check=true;
					}
				}
				if(check==true){
					check=false;
					counter++;
				}
			}
			if(counter==am.size()){
				output.add(s);
			}
			counter=0;
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

		ArrayList<Song> output = new ArrayList<Song>();
		HashMap<Song,Date> songListRelease=new HashMap<Song,Date>();
		HashMap<Song,Date> songListEnd=new HashMap<Song,Date>();
		songListRelease=band.getReleaseSongDateList();
		songListEnd=band.getEndDateSongList();

		for(Map.Entry<Song, Date> e : songListRelease.entrySet()){
			Song s = e.getKey();
			Date da = e.getValue();

			if(da.before(d) && songListEnd.get(s) ==null){
				output.add(s);
			}else if(da.before(d) && songListEnd.get(s).after(d)){
				output.add(s);
			}

		}
		return output;
	}

	/**
	 * Liefert alle Events im Zeitfenster zwischen from und until
	 * @param from
	 * @param until
	 * @return
	 */
	public ArrayList<Event> getRehearsals(Date from, Date until) {

		ArrayList<Event> tmpList = extractSpecialEvents(events, Rehearsal.class);
		ArrayList<Event> output = new ArrayList<Event>(); 


		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				output.add(e);
			}
		}
		return output;
	}


	public ArrayList<Event> getGigs(Date from, Date until) {

		ArrayList<Event> tmpList = extractSpecialEvents(events, Gig.class);
		ArrayList<Event> output = new ArrayList<Event>();

		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				output.add(e);
			}
		}
		return output;
	}


	/**
	 * Ueberladene Methode
	 * Liefert alle Events im Zeitfenster zwischen from und until
	 * @param from
	 * 			Datum, Anfang des Zeitfensters
	 * @param until
	 * 			Datum, Ende des Zeitfensters
	 * @param type
	 * 			bestimmt, ob sich die Abfrage nur auf Proben, nur auf Auftritte, oder auf beides bezieht.
	 * @return
	 */
	public ArrayList<Event> getEvents(Date from, Date until) {

		ArrayList<Event> tmpList = new ArrayList<Event>(events);
		ArrayList<Event> output = new ArrayList<Event>();

		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				output.add(e);
			}
		}
		return output;
	}

	/**
	 * Nachbedingung: liefet den aktuellen Kontostand
	 * Diese Methode gibt den aktuellen Kontostand zurueck.
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
	 * Vorbedingung: Vorbedingung von getRehearsal(Date, Date) muessen gegeben sein
	 * Liefert eine Bilanz aus Summe der Einnahmen und  Ausgaben im Zeitfenster zwischen from und until
	 * Uebergibt an die ueberladene Methode zusaetzlich den String "Both", was bedeutet, dass beides, Proben und Auftritte ausgewaehlt werden. 
	 * @param from
	 * @param until
	 * @return
	 */
	public int rehearsalFinancials(Date from, Date until) {

		ArrayList<Event> tmpList = getRehearsals(from, until);
		int budget = 0;

		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				budget += e.getFinances();
			}
		}
		return budget;
	}

	/**
	 * Vorbedingungen von getGigs(Date, Date) muessen gegeben sein
	 * @param from
	 * @param until
	 * @return
	 */
	public int gigFinancials(Date from, Date until) {

		ArrayList<Event> tmpList = getGigs(from, until);
		int budget = 0;

		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				budget += e.getFinances();
			}
		}
		return budget;
	}

	/**
	 * Vorbedingung: eventuelle Vorbedingungen von getEvents(Date, Date) muessen geben sein
	 * Ueberladene Methode
	 * Liefert eine Bilanz im Zeitfenster zwischen from und untilaben.
	 * Das aussortieren uebernimmt die Methode getEvents(from, until, type)
	 * @param from
	 * @param until
	 * @return
	 */
	public int financials(Date from, Date until) {

		ArrayList<Event> tmpList = getEvents(from, until);
		int budget = 0;

		for (Event e : tmpList) {

			if (e.getDate().after(from) && e.getDate().before(until) ) {

				budget += e.getFinances();
			}
		}

		return budget;
	}

	/**
	 * GUT: Auf Grund von dynamischem Binden ist das ausgeben von Transaktionen, die vom Typ Income oder Expense
	 * sind, sehr leicht mit einer ArrayList zu bewerkstelligen
	 * Methode liefert alle Transaktionen zurueck die einen Wert ungleich 0 besitzen
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

	private ArrayList<Event> extractSpecialEvents(ArrayList<Event> events, Class<? extends Event> c) {

		ArrayList<Event> output = new ArrayList<Event>();

		for (Event e : events) {

			if (e.getClass() == c) {

				output.add(e);
			}
		}
		return output;
	}

	public Event getEvent(String place, Date date) {

		Iterator<Event> iterator = events.iterator();
		Event output = null;
		boolean found = false;

		while (iterator.hasNext() && !found ) {

			output = iterator.next();

			if (output.isEqualEvent(place, date)) {

				found = true;
			}
		}

		if (!found) {

			output = null;
		}

		return output;
	}
	public void addGigLocation(GigLocation g){
		gigLocations.add(g);

	}

	public void addRehearsalLocation(RehearsalLocation r){
		rehearsalLocations.add(r);

	}
	public ArrayList<RehearsalLocation> getRehearsalLocation(){
		return rehearsalLocations;
	}
	//0<district<24  size>0   stageSize>0  distanceToCenter>0
	public ArrayList<RehearsalLocation> getRehearsalLocation(int district ,int size, int stageSize, int distanceToCenter, String wallColor){

		ArrayList<RehearsalLocation> output = new ArrayList<RehearsalLocation>();

		for (RehearsalLocation l : rehearsalLocations) {

			if(district==l.getDistrict()&&size==l.getSize()&&stageSize==l.getStageSize()&&distanceToCenter==l.getDistanceToCenter()&&wallColor.equals(l.getWallColor())){
				output.add(l);
			}
		}
		return output;
	}
	public ArrayList<GigLocation> getGigLocation(){

		return gigLocations;
	}
	//0<district<24  size>0   stageSize>0  distanceToCenter>0
	public ArrayList<GigLocation> getGigLocation(int district ,int size, int stageSize, int seatings){

		ArrayList<GigLocation> output = new ArrayList<GigLocation>();

		for (GigLocation l : gigLocations) {

			if(district==l.getDistrict()&&size==l.getSize()&&stageSize==l.getStageSize()&&seatings==l.getSeatings()){
				output.add(l);
			}
		}
		return output;
	}

}
