import java.util.TreeMap;


public class Hilfskraft extends Bediener {

	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */

	public String phaseEinsFuegeAndroidZuListeHinzu(TreeMap<Integer, Androide> liste) {
		return software().vonHilfskraftInstalliert(this, liste);
	}
	
	public String toString() {
		
		return "Hilfskraft " + super.toString();
	}	
}
