/**
 * Traktor mit Biogas-Motor
 */
@Gruppenmitglied("Anil")
public class TraktorMitBiogasMotor extends Traktor {

	private double biogasVerbrauch; // > 0
	
	/**
	 * Liefert bisherigen Verbrauch
	 * @return verbrauch > 0
	 */
	@Override
	public double bisherigerVerbrauch() {
		return biogasVerbrauch;
	}
	
	/**
	 * Veraendert Verbrauch um uebergebenen Wert
	 * @param 	verbrauch > 0 (erhoehen), < 0 (verringern)
	 */
	@Override
	public void erhoeheVerbrauch(double verbrauch) {
		biogasVerbrauch += verbrauch;
	}
	
	/**
	 * Liefert String-Repraesentation der Klasse
	 */
	@Override
	public String toString() {
		
		return "Traktor (BiogasMotor), "+super.toString();		
	}
}
