/**
 * @version 1.0
 */

import java.util.Date;

public class Song {
	
	private String name;
	private int duration;
	private Date releaseDate;
	private Date endDate;
	
	public Song(String name, int duration, Date releaseDate){
		this.name = name;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.endDate = null; //wird zu diesem Zeitpunkt noch nicht festgelegt
	}

	public Date getReleaseDate() {
		
		return releaseDate;
	}

	public Date getEndDate() {
		
		return endDate;
	}

	public void setEndDate(Date endDate) {
		
		this.endDate = endDate;
	}
	
	public String toString() {
		
		return "Name: " + name + ", Duration: " + duration + ", Release Date: " + releaseDate + ", End Date: "+endDate;
	}
}
