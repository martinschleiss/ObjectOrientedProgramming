import java.util.TreeMap;

/**
 * Eine Instanz von Skin ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass sie - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public abstract class Skin {

	protected final int codierung; //= Seriennummer des Androiden, der mit dieser Skin ausgestattet ist.

	public Skin(Androide a) {
		codierung = a.seriennummer();
	}
	
	/**
	 * Vorbedingung: liste und b (Bediener) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Skin hinzugefuegt werden soll
	 * return: String Bediener passt zur Skin oder nicht
	 */
	public abstract String vonBedienerInstalliert(Bediener b, TreeMap<Integer,Androide> liste,String out);
	
	/**
	 * Vorbedingung: liste und s (Schwerarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Skin hinzugefuegt werden soll
	 *  return: Bediener passt zur Skin oder nicht
	 */
	public abstract String vonSchwerarbeiterInstalliert(Schwerarbeiter g, TreeMap<Integer,Androide> liste,String out);
	
	/**
	 * Vorbedingung: liste und b (Beschuetzer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Skin hinzugefuegt werden soll
	 *  return: Bediener passt zur Skin oder nicht
	 */
	public abstract String vonBeschuetzer(Beschuetzer b, TreeMap<Integer,Androide> liste,String out);
	
	public String toString() {
		return "Skin: ";
	}
}
