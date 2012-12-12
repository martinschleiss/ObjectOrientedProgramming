/**
 * Traktor mit Diesel-Motor
 */
@Gruppenmitglied("Anil")
public class TraktorMitDieselMotor extends Traktor {

	private int dieselVerbrauch; // > 0

	/**
	 * Liefert bisherigen Verbrauch
	 * @return verbrauch, nur in ganzzahliger Genauigkeit
	 */
	@Override
	public double bisherigerVerbrauch() {
		return dieselVerbrauch;
	}
	
	/**
	 * Veraendert Verbrauch um uebergebenen Wert
	 * @param 	verbrauch > 0 (erhoehen), < 0 (verringern)
	 * 			wird auf ganzzahligen Wert standardmaessig gerundet
	 */
	@Override
	public void erhoeheVerbrauch(double verbrauch) {
		dieselVerbrauch += (int)verbrauch;
	}
	
	/**
	 * Liefert String-Repraesentation der Klasse
	 */
	@Override
	public String toString() {
		
		return "Traktor (DieselMotor), "+super.toString();		
	}
}
