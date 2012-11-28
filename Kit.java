import java.util.TreeMap;

/**
 * Eine Instanz von Kit ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass es - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 * Visitormethoden werden von Skin aufgerufen und verweisen bei Erfolg direkt auf die Visitormethoden in Kit
 */
public abstract class Kit {
	
	private String name;
	private final int codierung; //= Seriennummer des Androiden, der mit dieser Komponente ausgestattet ist.
	
	public Kit(String name, Androide a) {
		
		this.name = name;
		codierung = a.seriennummer();
	}
	
	/**
	 * Vorbedingung: liste und b (Bediener) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonBedienerInstalliert(Bediener b, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Androide mit Sicherheitsstufe 3) != null
	 * Nachbedingung:
	 * 			a entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			a entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Androide mit Sicherheitsstufe 4) != null
	 * Nachbedingung:
	 * 			a entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			a entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Androide) != null
	 * Nachbedingung:
	 * 			a entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg des Inserts
	 */
	public String vonKaemperInstalliert(Kaempfer k, TreeMap<Integer, Androide> liste) {
		
		liste.put(k.seriennummer(), k);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Name: " + name + ", Codierung: " + codierung;
	}
}