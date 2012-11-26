import java.util.HashMap;


public class SkinSensitiv extends Skin {
	
	public SkinSensitiv(Androide a) {
		super(a);
	}
	
	/**
	 * Vorbedingung: liste und b (Bediener) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonBedienerInstalliert(Bediener b, HashMap<Integer,Androide> liste) {
	//passt
	}
	
	/**
	 * Vorbedingung: liste und s (Schwerarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonSchwerarbeiterInstalliert(Schwerarbeiter g, HashMap<Integer,Androide> liste) {
	//passt	- jetzt AktorenCheck
	}
	
	/**
	 * Vorbedingung: liste und b (Beschuetzer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonBeschuetzer(Beschuetzer b, HashMap<Integer,Androide> liste) {
	//passt	
	}
}
