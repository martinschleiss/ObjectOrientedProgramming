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
	 * Vorbedingung: liste und b (Bediener) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param b : der Bauarbeiter zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonBedienerInstalliert(Bediener b, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und s (Schwerarbeiter) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param g : der Gesellschafter zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonSchwerarbeiterInstalliert(Schwerarbeiter g, HashMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und b (Beschuetzer) duerfen nicht null sein.
	 * Nachbedingung: Androide kann zur Liste hinzugefuegt worden sein oder nicht.
	 * @param liste : die Liste zu der der Androide hinzugefuegt werden soll
	 * @param h : die Hilfskraft zu dem die Skin hinzugefuegt werden soll
	 */
	public abstract void vonBeschuetzer(Beschuetzer b, HashMap<Integer,Androide> liste);
	
	public String toString() {
		return "Skin: " + codierung;
	}
}
