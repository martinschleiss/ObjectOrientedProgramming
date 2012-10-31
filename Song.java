/**
 * @version 1.0
 */

import java.util.Date;

public class Song {
	
	private String name;
	private int duration;
	private Date releaseDate;
	private Date endDate;
	
	/**
	 * Vorbedingungen:
	 * @param duration	> 0 in sec
	 * @param releaseDate darf nicht in der Zukunft liegen
	 */
	public Song(String name, int duration, Date releaseDate){
		this.name = name;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.endDate = null;
	}

	// releaseDate muss vor endDate sein
	public Date getReleaseDate() {
		
		return releaseDate;
	}
	//Nachbedingung: liefert End-Datum, falls Song nicht mehr gespielt wird, ansonsten null
	public Date getEndDate() {
		
		return endDate;
	}
	
	/**
	 * Vorbedingung:
	 * @param endDate 	> releaseDate
	 * Nachbedingung: endDate wird gespeichert
	 * ANMERKUNG: enddate > releaseDate koennte hier tatsaechlich ueberprueft werden.
	 */
	public void setEndDate(Date endDate) {
		
		this.endDate = endDate;
	}
	
	public String toString() {
		
		return "Name: " + name + ", Duration: " + duration + ", Release Date: " + releaseDate + ", End Date: "+endDate;
	}
}
