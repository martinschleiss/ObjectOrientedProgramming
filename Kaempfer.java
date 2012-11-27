import java.util.TreeMap;


public class Kaempfer extends Beschuetzer {

	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */

	public void phaseEinsFuegeAndroidZuListeHinzu(TreeMap<Integer, Androide> liste) {
		software().vonKaempferInstalliert(this, liste);
	}
	
	public String toString() {
		
		return "Kaempfer " + super.toString();
	}	
}
