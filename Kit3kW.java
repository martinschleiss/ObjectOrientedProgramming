import java.util.TreeMap;

/**
 * Eine Instanz von Kit ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass es - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public class Kit3kW extends Kit {

	public Kit3kW(String name, Androide a) {
		
		super(name + " (3kW)", a);
	}
	
	/**
	 * Vorbedingung: liste und a (Androide) != null
	 * Nachbedingung:
	 * 			a entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Misserfolg des Inserts
	 */
	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		liste.remove(b.seriennummer());
		return "Fehler: Leistungsueberschreitung";
	}

	/**
	 * Vorbedingung: liste und a (Androide) != null
	 * Nachbedingung:
	 * 			a entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg des Inserts
	 */
	public String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		liste.put(a.seriennummer(), a);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}

	/**
	 * Vorbedingung: liste und a (Androide) != null
	 * Nachbedingung:
	 * 			a entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg des Inserts
	 */
	public String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste) {
		
		liste.put(a.seriennummer(), a);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}
}
