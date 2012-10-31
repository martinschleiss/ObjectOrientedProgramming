/**
 * @version 1.1
 */

import java.util.ArrayList;
import java.util.Date;

public class Member {
	
	private String name;
	private String tel;
	private String instrument;
	private ArrayList<Song> songs;
	private ArrayList<Request> informedAbout;
	
	/**
	 * Vorbedingungen:
	 * @param tel			> 0
	 * @param memberFrom	darf nicht in der Zukunft liegen.
	 */
	
	public Member (String name, String tel, String instrument, Date memberFrom){
		this.name = name;
		this.tel = tel;
		this.instrument = instrument;
		songs = new ArrayList<Song>();
		informedAbout = new ArrayList<Request>();
	}

	/**
	 * Nachbedingungen:
	 * @return		Liste aller Songs des Mitglieds.
	 */
	public ArrayList<Song> getSongs(){
		return songs;
		
	}

	/**
	 * Vorbedingungen:
	 * @param s		not null
	 * Nachbedingungen:
	 * 				s ist songs hinzugefuegt
	 */
	public void setSong(Song s){
		songs.add(s);
	}
	
	/**
	 * Nachbedingungen:
	 * 				s ist nicht (mehr) in songs
	 */
    public void removeSong(Song s){
    	
    	songs.remove(s);
    	
    }
	
	/**
	 * Vorbedingungen:
	 * @param r		not null
	 * 
	 * Nachbedingungen: der Request ist gespeichert 
	 */
	public void inform(Request r, String furtherInfo) {

	informedAbout.add(r);
	}
	
	/**
	 * Vorbedingungen:
	 * @param r		not null
	 * @param b		entspricht dem Wert true fuer Zu- und false fuer Absage
	 * @param s		Antwort auf Request
	 * 
	 * Nachbedingungen:
	 * @return		true wenn das Mitglied zuvor ueber inform(Request, String) informiert wurde Request - auf den Request wird geantwortet
	 * 				false wenn Mitglied nicht ueber Request informiert wurde. (nichts passiert)
	 */
	public boolean respond(Request r, boolean b, String s) {
		
		if (informedAbout.contains(r)) {
			
			r.respond(this, b, s);
			return true;
		}
		
		//FEHLER: Mitglied muss garnicht ueber Request informiert worden sein, um darauf zu antworten.
		r.respond(this,b,s);
		return false;
		
	}
	
	public String toString() {
		
		return name;
	}
}
