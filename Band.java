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

	public void setJoinMemberList(Member m, Date d) {
		joinMemberList.put(m,d);
		setLeaveMemberList(m,null);
		
	}

	public HashMap<Member,Date> getLeaveMemberList() {
		return leaveMemberList;
	}

	public void setLeaveMemberList(Member m, Date d) {
		leaveMemberList.put(m, d);
	}

	public HashMap<Song,Date> getReleaseSongDateList() {
		return releaseSongDateList;
	}
	
	public void setReleaseSongDateList(Song s, Date d) {
		releaseSongDateList.put(s, d);
		setEndDateSongList(s, null);
	}

	public HashMap<Song,Date> getEndDateSongList() {
		return endDateSongList;
	}

	public void setEndDateSongList(Song s, Date d) {
		endDateSongList.put(s,d);
		
	}
}
