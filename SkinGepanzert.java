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
	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer,Androide> liste,String out) {
		out +="Skin passt nicht, ";
		return out;
		//passt nicht
		//weiter zu Komponenten
	}
	
	/**
	 * Vorbedingung: liste und s (Schwerarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Skin hinzugefuegt werden soll
	 */
	public String vonSchwerarbeiterInstalliert(Schwerarbeiter g, TreeMap<Integer,Androide> liste,String out) {
		out +="Skin passt nicht, ";
		return out;
		//weiter zu Komponenten
	}
	
	/**
	 * Vorbedingung: liste und b (Beschuetzer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Skin hinzugefuegt werden soll
	 */
	public String vonBeschuetzer(Beschuetzer b, TreeMap<Integer,Androide> liste,String out) {
		out +="Skin passt, ";
		return out;
		//weiter zu Komponenten
	}
	
	@Override
	public String toString() {
		return super.toString()+"SkinGepanzert "+"SRN: "+codierung;
	}
}
