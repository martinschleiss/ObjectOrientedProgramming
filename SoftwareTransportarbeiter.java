import java.util.ArrayList;


public class SoftwareTransportarbeiter extends Software {

	public SoftwareTransportarbeiter(Androide a, Sicherheitsstufe s) {
		super(a, s);
	}
	
	/**
	 * Vorbedingung: liste und s (Sicherheitsstufe) duerfen nicht null sein
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste: die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s: die korrespondierende Sicherheitsstufe zur aktuellen Software
	 */

	public void phaseZweiFuegeAndroidZuListeHinzu(ArrayList<Androide> liste, Sicherheitsstufe s) {
		s.aufSoftwareTransportarbeiter(this, a, liste);
	}
	
	/**
	 * Vorbedingung: liste und s (Sicherheitsstufe) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : die korrespondierende Sicherheitsstufe zur aktuellen Software
	 */
	
	public void vonTransportarbeiterInstalliert(Transportarbeiter t, ArrayList<Androide> liste){ 
		phaseZweiFuegeAndroidZuListeHinzu(liste, s); 
	};
	
	/**
	 * Vorbedingung: liste und g (Gesellschafter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Software hinzugefuegt worden ist
	 */
	
	public void vonGesellschafterInstalliert(Gesellschafter g, ArrayList<Androide> liste){ };	
	
	/**
	 * Vorbedingung: liste und b (Bauarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Software hinzugefuegt worden ist
	 */
	
	public void vonBauarbeiterInstalliert(Bauarbeiter b, ArrayList<Androide> liste){ };
	
	/**
	 * Vorbedingung: liste und h (Hilfskraft) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Software hinzugefuegt worden ist
	 */
	
	public void vonHilfskraftInstalliert(Hilfskraft h, ArrayList<Androide> liste){ };
	
	/**
	 * Vorbedingung: liste und k (Kaempfer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param k : der Kaempfer zu dem die Software hinzugefuegt worden ist
	 */
	
	public void vonKaempferInstalliert(Kaempfer k, ArrayList<Androide> liste){ };
	
	/**
	 * Vorbedingung: liste und l (Leibwaechter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param l : der Leibwaechter zu dem die Software hinzugefuegt worden ist
	 */
	
	public void vonLeibwaechterInstalliert(Leibwaechter l, ArrayList<Androide> liste){ };
	
	/**
	 * Vorbedingung: liste und o (Objektbewacher) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param o : der Objektbewacher zu dem die Software hinzugefuegt worden ist
	 */
	public void vonObjektbewacherInstalliert(Objektbewacher o, ArrayList<Androide> liste){ };
	
	/**
	 * Vorbedingung: liste und s (Servicetechniker) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : der Servicetechniker zu dem die Software hinzugefuegt worden ist
	 */
	
	public void vonServicetechnikerInstalliert(Servicetechniker s, ArrayList<Androide> liste){ };
	
}
