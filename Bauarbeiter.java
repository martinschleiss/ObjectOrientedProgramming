import java.util.ArrayList;
public class Bauarbeiter extends Schwerarbeiter {
	
	public void installSoftware(Software software) {
		super.installSoftware(software);
		
		
	}
	
	/**
	 * Vorbedingung: liste darf nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 */

	public void phaseEinsFuegeAndroidZuListeHinzu(ArrayList<Androide> liste) {
		software.vonBauarbeiterInstalliert(this, liste);
	}

}
