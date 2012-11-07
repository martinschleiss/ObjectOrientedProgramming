/**
 * @version 1.0
 */

import java.util.Date;

public class Song {
	
	private String name;
	/**
	 * Invariante: duration > 0
	 */
	private int duration;
	
	/**
	 * Invariante: releaseDate ist Datum aus Vergangenheit und releasedate < endDate, falls endDate gesetzt
	 */
	private Date releaseDate;
	private Date endDate;
	
	/**
	 * Vorbedingungen:
	 * @param duration		> 0 in sec
	 * @param releaseDate 	not null, muss Datum aus der Vergangenheit sein
	 * 
	 * Nachbedingungen:
	 * Objekt ist korrekt initialisiert.
	 */
	public Song(String name, int duration, Date releaseDate){
		this.name = name;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.endDate = null;
	}

	/**
	 * Nachbedingung:
	 * @return gespeichertes Releasedatum des Songs
	 */
	public Date getReleaseDate() {
		
		return releaseDate;
	}
	
	/**
	 * Nachbedingung: 
	 * @return liefert End-Datum, falls Song nicht mehr gespielt wird, ansonsten null
	 */
	public Date getEndDate() {
		
		return endDate;
	}
	
	/**
	 * Vorbedingung:
	 * @param endDate 	> releaseDate
	 * Nachbedingung: endDate wird gespeichert
	 * ANMERKUNG: (AUSGEBESSERT) enddate > releaseDate koennte hier tatsaechlich ueberprueft werden.
	 */
	public void setEndDate(Date endDate) {
		assert endDate.after(releaseDate) : "endDate muss nach releaseDate sein";
		this.endDate = endDate;
	}
	
	/**
	 * Lifert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Name: " + name + ", Duration: " + duration + ", Release Date: " + releaseDate + ", End Date: "+endDate;
	}
}
