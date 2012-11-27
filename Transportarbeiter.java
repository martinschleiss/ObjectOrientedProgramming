import java.util.TreeMap;


public class Transportarbeiter extends Schwerarbeiter {

	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */

	public void phaseEinsFuegeAndroidZuListeHinzu(TreeMap<Integer, Androide> liste) {
		software().vonTransportarbeiterInstalliert(this, liste);
	}
	
	public String toString() {
		
		return "Transportarbeiter " + super.toString();
	}	
}
