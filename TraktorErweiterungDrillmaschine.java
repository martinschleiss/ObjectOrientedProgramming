/**
 * Drillmaschine als Erweiterung fuer Traktoren
 */
@Gruppenmitglied("Martin")
public class TraktorErweiterungDrillmaschine extends TraktorErweiterung {

	private int saeschare; // > 0
	
	public TraktorErweiterungDrillmaschine(int saeschare) {
	
		this.saeschare=saeschare;
	}
	
	/**
	 * Liefert Groesse des Ausmasses
	 * @return ausmass >= 0
	 * 			nur ganzzahlige Genauigkeit
	 */
	@Override
	public double erweiterungsAusmass() {
		
		return saeschare;
	}
	
	/**
	 * Liefert String-Repraesentation der Klasse
	 */
	@Override
	public String toString(){
		
		return "Drillmaschine";
	}
}
