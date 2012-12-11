
public class TraktorErweiterungDuengestreuer extends TraktorErweiterung {
	
	private double fassungskapazitaet;
	
	public TraktorErweiterungDuengestreuer(double fassungskapazitaet){
		this.fassungskapazitaet=fassungskapazitaet;
	}
	
	/**
	 * Liefert Groesse des Ausmasses
	 * @return ausmass >= 0
	 * 			nur ganzzahlige Genauigkeit
	 */
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
