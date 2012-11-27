import java.util.TreeMap;


public class SoftwareObjektbewacher extends Software {

	public SoftwareObjektbewacher(Androide a, Sicherheitsstufe s) {
		super(a, s);
	}
	
	/**
	 * Vorbedingung: liste und s (Sicherheitsstufe) duerfen nicht null sein
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste: die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s: die korrespondierende Sicherheitsstufe zur aktuellen Software
	 */

	public String phaseZweiFuegeAndroidZuListeHinzu(TreeMap<Integer, Androide> liste, Sicherheitsstufe s,Objektbewacher o,String out) {
		return s.aufSoftwareObjektbewacher(this, o, liste,out);
	}
	
	/**
	 * Vorbedingung: liste und o (Objektbewacher) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param o : der Objektbewacher zu dem die Software hinzugefuegt worden ist
	 */
	
	public String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer, Androide> liste){ 
		String out="Software passt, ";
		return phaseZweiFuegeAndroidZuListeHinzu(liste, s,o,out);
	};
	
	/**
	 * Vorbedingung: liste und g (Gesellschafter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Software hinzugefuegt worden ist
	 */
	
	public String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer, Androide> liste){ return "Software passt nicht";};	
	
	/**
	 * Vorbedingung: liste und b (Bauarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Software hinzugefuegt worden ist
	 */
	
	public String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer, Androide> liste){return "Software passt nicht"; };
	
	/**
	 * Vorbedingung: liste und h (Hilfskraft) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Software hinzugefuegt worden ist
	 */
	
	public String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer, Androide> liste){return "Software passt nicht"; };
	
	/**
	 * Vorbedingung: liste und k (Kaempfer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param k : der Kaempfer zu dem die Software hinzugefuegt worden ist
	 */
	
	public String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer, Androide> liste){return "Software passt nicht"; };
	
	/**
	 * Vorbedingung: liste und l (Leibwaechter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param l : der Leibwaechter zu dem die Software hinzugefuegt worden ist
	 */
	
	public String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer, Androide> liste){ return "Software passt nicht";};	
	
	/**
	 * Vorbedingung: liste und s (Servicetechniker) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : der Servicetechniker zu dem die Software hinzugefuegt worden ist
	 */
	
	public String vonServicetechnikerInstalliert(Servicetechniker s, TreeMap<Integer, Androide> liste){ return "Software passt nicht";};
	
	/**
	 * Vorbedingung: liste und s (Sicherheitsstufe) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : die korrespondierende Sicherheitsstufe zur aktuellen Software
	 */
	
	public String vonTransportarbeiterInstalliert(Transportarbeiter t, TreeMap<Integer, Androide> liste){ return "Software passt nicht";};
}
