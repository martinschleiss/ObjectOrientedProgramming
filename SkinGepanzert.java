import java.util.TreeMap;


public class SkinGepanzert extends Skin {
	
	public SkinGepanzert(Androide a) {
		super(a);
	}
	
	/**
	 * Vorbedingung: liste und b (Bediener) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonBedienerInstalliert(Bediener b, TreeMap<Integer,Androide> liste) {
	//passt nicht
	}
	
	/**
	 * Vorbedingung: liste und s (Schwerarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonSchwerarbeiterInstalliert(Schwerarbeiter g, TreeMap<Integer,Androide> liste) {
	//passt	nicht
	}
	
	/**
	 * Vorbedingung: liste und b (Beschuetzer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Skin hinzugefuegt werden soll
	 */
	public void vonBeschuetzer(Beschuetzer b, TreeMap<Integer,Androide> liste) {
	//passt	
	}
}
