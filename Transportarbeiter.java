import java.util.ArrayList;


public class Transportarbeiter extends Schwerarbeiter {

	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */

	public void phaseEinsFuegeAndroidZuListeHinzu(ArrayList<Androide> liste) {
		software.vonTransportarbeiterInstalliert(this, liste);
	}
}
