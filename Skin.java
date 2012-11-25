//import java.util.ArrayList;
import java.util.HashMap;

/**
 * Eine Instanz von Skin ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass sie - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public abstract class Skin {

	private final int codierung; //= Seriennummer des Androiden, der mit dieser Skin ausgestattet ist.

	public Skin(Androide a) {
		codierung = a.seriennummer();
	}
	
	/**
	 * Vorbedingung: liste und b (Bauarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonBauarbeiterInstalliert(Bauarbeiter b, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und g (Gesellschafter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonGesellschafterInstalliert(Gesellschafter g, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und h (Hilfskraft) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonHilfskraftInstalliert(Hilfskraft h, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und k (Kaempfer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param k : der Kaempfer zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonKaempferInstalliert(Kaempfer k, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und l (Leibwaechter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param l : der Leibwaechter zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonLeibwaechterInstalliert(Leibwaechter l, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und s (Servicetechniker) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param s : der Servicetechniker zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonServicetechnikerInstalliert(Servicetechniker s, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und o (Objektbewacher) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param o : der Objektbewacher zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonObjektbewacherInstalliert(Objektbewacher o ,HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und t (Transportarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param t : der Transportarbeiter zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonTransportarbeiterInstalliert(Transportarbeiter t, HashMap<Integer,Androide> liste);

	
	
	
	public String toString() {
		return "Skin: " + codierung;
	}
}
