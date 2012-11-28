import java.util.TreeMap;

/**
 * Eine Instanz von Kit ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass es - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public class Kit1kW extends Kit {

	public Kit1kW(String name, Androide a) {
		
		super(name + " (1kW)", a);
	}

	/**
	 * Vorbedingung: liste und a (Androide) != null
	 * Nachbedingung:
	 * 			a entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg des Inserts
	 */
	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		liste.put(b.seriennummer(), b);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
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
