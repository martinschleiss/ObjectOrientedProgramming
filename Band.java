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

	public Band(){

		memberList=new HashMap<Member,Date[]>();
		songList=new HashMap<Song,Date[]>();

	}
	
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
	 * @param m not null, ist Mitglied, das in die Band aufgenommen werden soll
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
	 * @param m not null, ist Mitglied, das aus der Band ausscheiden soll
	 * Nachbedingungen:
	 * 		Mitglied wird mit Datum in Liste der aktiven Mitglieder aufgenommen
	 * ANMERKUNG: ein besserer Methodenname waere retireMember, das entspraeche genau der Funktion und waere eine bessere Zusicherung fuer den Client
	 */
	public void retireMember(Member m, Date d) {
		Date[] ar=new Date[2];

		ar= memberList.get(m);
		ar[1]=d;
		memberList.put(m, ar);
	}

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
	 * @param s not null
	 * Nachbedingungen:
	 * 		Song wird in die Songliste aufgenommen
	 */
	public void setSong(Song s, Date d) {
		Date[] ar=new Date[2];
		ar[0]=d;
		ar[1]=null;

		songList.put(s,ar);
		
	}

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
	 * @param s not null
	 * @param d		d >= releaseDate
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
