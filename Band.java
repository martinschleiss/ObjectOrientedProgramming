/**
 * @version 1.0
 * @author Anil
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Band {

	private HashMap<Member,Date[]> memberList;
	private HashMap<Song,Date[]> songList; 

	/**
	 * Nachbedingung: Objekt wurde korrekt initialisiert.
	 */
	public Band(){

		memberList=new HashMap<Member,Date[]>();
		songList=new HashMap<Song,Date[]>();

	}
	
	/**
	 * Nachbedingung:
	 * @return alle Mitglieder der Band mit ihrem Eintrittsdatum
	 */
	public HashMap<Member,Date> getJoinMemberList() {
		HashMap<Member,Date> joinMemberList=new HashMap<Member,Date>();
		for(Map.Entry<Member, Date[]> e : memberList.entrySet()){

			Member m = e.getKey();
			Date[] da = e.getValue();

			joinMemberList.put(m, da[0]);
		}
		return joinMemberList;
	}

	/**
	 * Vorbedingungen:
	 * @param m 	not null
	 * 
	 * Nachbedingungen:
	 * 		Mitglied wird mit Datum in Liste der aktiven Mitglieder aufgenommen
	 */
	public void addMember(Member m, Date d) {

		Date[] ar=new Date[2];
		ar[0]=d;
		ar[1]=null;

		memberList.put(m,ar);
	}
	
	/**
	 * Nachbedingun:
	 * @return alle ehemaligen Bandmitglieder mit ihrem Austrittsdatum
	 */
	public HashMap<Member,Date> getLeaveMemberList() {
		HashMap<Member,Date> leaveMemberList=new HashMap<Member,Date>();
		for(Map.Entry<Member, Date[]> e : memberList.entrySet()){

			Member m = e.getKey();
			Date[] da = e.getValue();
			leaveMemberList.put(m, da[1]);
		}
		return leaveMemberList;
	}

	/**
	 * Vorbedingungen:
	 * @param m 	not null
	 * Nachbedingungen:
	 * 		Mitglied wird mit Datum in Liste der aktiven Mitglieder aufgenommen
	 * ANMERKUNG: (AUSGEBESSERT) ein besserer Methodenname waere retireMember, 
	 * das entspraeche genau der Funktion und waere eine bessere Zusicherung fuer den Client
	 */
	public void retireMember(Member m, Date d) {
		Date[] ar=new Date[2];

		ar= memberList.get(m);
		ar[1]=d;
		memberList.put(m, ar);
	}

	/**
	 * Nachbedingungen:
	 * @return alle derzeitigen Songs mit ihrem Releasedatum
	 */
	public HashMap<Song,Date> getReleaseSongDateList() {
		HashMap<Song,Date> endDateSong=new HashMap<Song,Date>();
		for(Map.Entry<Song, Date[]> e : songList.entrySet()){

			Song s = e.getKey();
			Date[] da = e.getValue();

			endDateSong.put(s, da[0]);
			
		}

		return endDateSong;
	}

	/**
	 * Vorbedingungen:
	 * @param s 	not null
	 * Nachbedingungen:
	 * 		Song wird in die Songliste aufgenommen
	 */
	public void setSong(Song s, Date d) {
		Date[] ar=new Date[2];
		ar[0]=d;
		ar[1]=null;

		songList.put(s,ar);
		
	}
	
	/**
	 * Nachbedingungen:
	 * @return alle ehemaligen Songs mit ihrem Enddatum
	 */
	public HashMap<Song,Date> getEndDateSongList() {
		HashMap<Song,Date> endDateSong=new HashMap<Song,Date>();
		for(Map.Entry<Song, Date[]> e : songList.entrySet()){

			Song s = e.getKey();
			Date[] da = e.getValue();

			endDateSong.put(s, da[1]);
			
		}

		return endDateSong;
	}

	/**
	 * Vorbedingungen:
	 * @param s 	not null
	 * @param d		not null, d >= releaseDate
	 * Nachbedingungen:
	 * 		Song wird mit Enddatum versehen
	 */
	public void setEndDateSongList(Song s, Date d) {
		Date[] ar=new Date[2];

		ar= songList.get(s);
		ar[1]=d;
		songList.put(s, ar);
	}
}