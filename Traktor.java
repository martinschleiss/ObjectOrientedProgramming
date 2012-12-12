/**
 * Basisklasse fuer Traktoren
 */

public abstract class Traktor {
	
	private static int serie = 0;
	private final int seriennummer; //eindeutig
	private int betriebsstunden; // > 0
	private TraktorErweiterung erweiterung;
	
	public Traktor() {
		
		seriennummer = serie++;
	}
	
	/**
	 * Liefert die eindeutige Seriennummer des Traktors
	 * @return seriennummer > 0
	 */
	public int serienNummer() {
	
		return seriennummer;
	}
	
	/**
	 * Getter-Methode fuer die Traktorerweiterung
	 * @return erweiterung, auch null
	 */
	public TraktorErweiterung getErweiterung() {
		
		return erweiterung;
	}
	
	/**
	 * Setter-Methode fuer die Traktorerweiterung
	 * @param e != null
	 */
	public void setzeTraktorErweiterung(TraktorErweiterung e) {
		
		erweiterung = e;
	}
	
	/**
	 * Getter-Methode fuer die Betriebsstunden
	 * @return betriebsstunden > 0
	 */
	public int betriebsstunden() {
	
		return betriebsstunden;
	}
	
	/**
	 * Methode zum Erhoehen der Betriebsstunden
	 * @param stunden > 0
	 */
	public void erhoeheBetriebsstundenUm(int stunden) {
		
		betriebsstunden += stunden;
	}
	
	/**
	 * Liefert das in den Erweiterungen spezifizierte Ausmass (wie Fassvermoegen) der jeweiligen Erweiterung
	 * @return ausmass > 0
	 */
	public double erweiterungsAusmass() {
		
		return erweiterung.erweiterungsAusmass();
	}

	/**
	 * Liefert bisherigen Verbrauch
	 * @return verbrauch, kann je nach Unterklasse auch nur ganzzahlige Genauigkeit besitzen
	 */
	abstract double bisherigerVerbrauch();
	
	/**
	 * Veraendert Verbrauch um uebergebenen Wert
	 * @param 	verbrauch > 0 (erhoehen), < 0 (verringern)
	 * 			wird in Unterklassen mit nur ganzzahliger Genauigkeit standardmaessig gerundet
	 */
	abstract void erhoeheVerbrauch(double verbrauch);
	
	/**
	 * Liefert String-Repraesentation der Klasse
	 */
	public String toString() {
		
		return "Nr: " + seriennummer + ", Betriebsstunden: " + betriebsstunden+ " Erweiterung: "+erweiterung+" "+erweiterungsAusmass();
	}
}
