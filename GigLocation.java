/**
 * 
 * @author Anil
 *
 */

public class GigLocation extends Location{
	
	private int seatings;
	
	/**
	 * Vorbedingungen: 
	 * Vorbedinugungen des Superkonstruktors und	
	 * @param seatings 	> 0
	 * 
	 * Nachbedingung:
	 * Objekt wurde korrekt initialisiert.
	 */
	public GigLocation(int district, int size, int stageSize, int seatings){
		super(district, size, stageSize);
		this.setSeatings(seatings);
	}
	
	/**
	 * Nachbedingung:
	 * @return Anzahl der Sitzplaetze
	 */
	public int getSeatings() {
		return seatings;
	}

	/**
	 * Vorbedingung:
	 * @param seatings		> 0
	 * 
	 * Nachbedingung:
	 * seatings wurden gespeichert.
	 */
	public void setSeatings(int seatings) {
		this.seatings = seatings;
	}
	
	/**
	 * Nachbedingung:
	 * @return String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return super.toString() + ", Seatings: " + seatings;
	}
}
