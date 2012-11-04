/**
 * @version 1.0
 * @author Anil
 */

import java.util.Date;
import java.util.HashMap;


public class Band {

	private HashMap<Member,Date> joinMemberList; //Mitglieder und ihr Eintrittsdatum
	private HashMap<Member,Date> leaveMemberList; //Mitglieder und ihr Austrittsdatum
	private HashMap<Song,Date> releaseSongDateList; //Songs und ihr Eintrittsdatum
	private HashMap<Song,Date> endDateSongList;  //Songs und ihr Austrittsdatum
	
	
	public Band(){

		joinMemberList=new HashMap<Member,Date>();
		leaveMemberList=new HashMap<Member,Date>();
		releaseSongDateList=new HashMap<Song,Date>();
		endDateSongList=new HashMap<Song,Date>();
		
	}

	public HashMap<Member,Date> getJoinMemberList() {
		return joinMemberList;
	}

	/**
	 * Vorbedingungen:
	 * @param m not null, ist Mitglied, das in die Band aufgenommen werden soll
	 * 
	 * Nachbedingungen:
	 * 		Mitglied wird mit Datum in Liste der aktiven Mitglieder aufgenommen
	 * ANMERKUNG 1: Ich glaube, dass es fuer den Client nicht wichtig ist zu wissen, dass er auch in setLeaveMemberList aufgenommen wurde
	 * ANMERKUNG 2: ein besserer Methodenname waere addMember, das entspraeche genau der Funktion und waere eine bessere Zusicherung fuer den Client
	 */
	public void setJoinMemberList(Member m, Date d) {
		joinMemberList.put(m,d);
		setLeaveMemberList(m,null);
		
	}

	public HashMap<Member,Date> getLeaveMemberList() {
		return leaveMemberList;
	}

	/**
	 * Vorbedingungen:
	 * @param m not null, ist Mitglied, das aus der Band ausscheiden soll
	 * Nachbedingungen:
	 * 		Mitglied wird mit Datum in Liste der aktiven Mitglieder aufgenommen
	 * ANMERKUNG: ein besserer Methodenname waere retireMember, das entspraeche genau der Funktion und waere eine bessere Zusicherung fuer den Client
	 */
	public void setLeaveMemberList(Member m, Date d) {
		leaveMemberList.put(m, d);
	}

	public HashMap<Song,Date> getReleaseSongDateList() {
		return releaseSongDateList;
	}
	
	/**
	 * Vorbedingungen:
	 * @param s not null
	 * Nachbedingungen:
	 * 		Song wird in die Songliste aufgenommen
	 */
	public void setReleaseSongDateList(Song s, Date d) {
		releaseSongDateList.put(s, d);
		setEndDateSongList(s, null);
	}

	public HashMap<Song,Date> getEndDateSongList() {
		return endDateSongList;
	}

	/**
	 * Vorbedingungen:
	 * @param s not null
	 * @param d		d >= releaseDate
	 * Nachbedingungen:
	 * 		Song wird mit Enddatum versehen
	 */
	public void setEndDateSongList(Song s, Date d) {
		endDateSongList.put(s,d);
		
	}
}
