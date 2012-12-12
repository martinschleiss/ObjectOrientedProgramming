/**
 * Duengestreuer als Erweiterung fuer Traktoren
 */

public class TraktorErweiterungDuengestreuer extends TraktorErweiterung {
	
	private double fassungskapazitaet; // > 0
	
	public TraktorErweiterungDuengestreuer(double fassungskapazitaet) {
		
		this.fassungskapazitaet=fassungskapazitaet;
	}
	
	/**
	 * Liefert Groesse des Ausmasses
	 * @return ausmass >= 0
	 */
	@Override
	public double erweiterungsAusmass() {
		
		return fassungskapazitaet;
	}
	
	/**
	 * Liefert String-Repraesentation der Klasse
	 */
	@Override
	public String toString(){
		
		return "Duengestreuer";
	}
}
