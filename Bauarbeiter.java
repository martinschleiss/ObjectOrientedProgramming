import java.util.TreeMap;

public class Bauarbeiter extends Schwerarbeiter {

	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */
	public String phaseEinsFuegeAndroidZuListeHinzu(TreeMap<Integer, Androide> liste) {
		
		return software().vonBauarbeiterInstalliert(this, liste);
	}
	
	public String toString() {
		
		return "Bauarbeiter " + super.toString();
	}
}
