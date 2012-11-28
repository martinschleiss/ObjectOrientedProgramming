/**
 * Leichtgewichtiger, flinker Androide fuer Einsatz in Menschennaehe
 */
public abstract class Bediener extends Androide {

	/**
	 * Liefert String-Repraesentation des Androiden
	 */
	public String toString() {
		
		return "(Bediener), " + super.toString();
	}	
}
