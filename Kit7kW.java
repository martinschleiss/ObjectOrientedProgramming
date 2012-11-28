import java.util.TreeMap;

/**
 * Eine Instanz von Kit ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass es - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public class Kit7kW extends Kit {

	public Kit7kW(String name, Androide a) {
		
		super(name + " (7kW)", a);
	}

	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		liste.remove(b.seriennummer());
		return "Fehler: Leistungsueberschreitung";
	}

	public String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		liste.remove(a.seriennummer());
		return "Fehler: Leistungsueberschreitung";
	}

	public String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		liste.put(a.seriennummer(), a);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}
}
