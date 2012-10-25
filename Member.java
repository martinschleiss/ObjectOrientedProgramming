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
	
	public Member (String name, String tel, String instrument, Date memberFrom){
		this.name = name;
		this.tel = tel;
		this.instrument = instrument;
		songs = new ArrayList<Song>();
		informedAbout = new ArrayList<Request>();
	}

	public ArrayList<Song> getSongs(){
		return songs;
		
	}
	
	public void setSong(Song s){
		songs.add(s);
	}
	
    public void removeSong(Song s){
    	
    	songs.remove(s);
    	
    }
	
	public void inform(Request r, String furtherInfo) {
		
	//hier koennte code fuer das versenden einer mail mit dem Text furtherInfo stehen.
	informedAbout.add(r);
	}
	
	public boolean respond(Request r, boolean b, String s) {
		
		if (informedAbout.contains(r)) {
			
			r.respond(this, b, s);
			return true;
		}
		r.respond(this,b,s);
		return false;
		
	}
	
	public String toString() {
		
		return name;
	}
}
