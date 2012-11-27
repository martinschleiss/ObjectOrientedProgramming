import java.util.TreeMap;

/**
 * Eine Instanz von Kit ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass es - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public class Kit21kW extends Kit {

	public Kit21kW(String name, Androide a) {
		
		super(name + " (21kW)", a);
	}
	
	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		return "Fehler: Leistungsueberschreitung";
	}

	public String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		return "Fehler: Leistungsueberschreitung";
	}

	public String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		return "Fehler: Leistungsueberschreitung";
	}
}
