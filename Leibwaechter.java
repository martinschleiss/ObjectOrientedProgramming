import java.util.ArrayList;


public class Leibwaechter extends Beschuetzer {

	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */

	public void phaseEinsFuegeAndroidZuListeHinzu(ArrayList<Androide> liste) {
		software.vonLeibwaechterInstalliert(this, liste);
	}
}
