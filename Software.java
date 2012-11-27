import java.util.TreeMap;

/**
 * Eine Instanz dieser Software ist Bestandteil genau eines Androiden.
 */
public abstract class Software {
	
	//TODO: Codierung implementieren @Martin
	
	//private final int codierung; //= Seriennummer des Androiden, der mit dieser Software ausgestattet ist.
	protected Androide a;
	protected Sicherheitsstufe s;
	
	public Software(Androide a, Sicherheitsstufe s) {
		this.a = a;
		this.s = s;
		//codierung = a.seriennummer();
	}

	/**
	 * Vorbedingung: liste und b (Bauarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Software hinzugefuegt worden ist
	 */

	public abstract String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und g (Gesellschafter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Software hinzugefuegt worden ist
	 */
	public abstract String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und h (Hilfskraft) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Software hinzugefuegt worden ist
	 */
	public abstract String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und k (Kaempfer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param k : der Kaempfer zu dem die Software hinzugefuegt worden ist
	 */
	public abstract String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und l (Leibwaechter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param l : der Leibwaechter zu dem die Software hinzugefuegt worden ist
	 */
	public abstract String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und o (Objektbewacher) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param o : der Objektbewacher zu dem die Software hinzugefuegt worden ist
	 */
	public abstract String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und s (Servicetechniker) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : der Servicetechniker zu dem die Software hinzugefuegt worden ist
	 */
	public abstract String vonServicetechnikerInstalliert(Servicetechniker s, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und t (Transportarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param t : der Transportarbeiter zu dem die Software hinzugefuegt worden ist
	 */
	public abstract String vonTransportarbeiterInstalliert(Transportarbeiter t, TreeMap<Integer,Androide> liste);		

	/**
	 * Vorbedingung: liste und s (Sicherheitsstufe) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : die korrespondierende Sicherheitsstufe zur aktuellen Software
	 */
	//public abstract void phaseZweiFuegeAndroidZuListeHinzu(TreeMap<Integer,Androide> liste, Sicherheitsstufe s);
	
}
