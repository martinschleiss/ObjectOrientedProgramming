import java.util.TreeMap;


public class Kit7kW extends Kit {

	public Kit7kW(String name, int leistung, Androide a) {
		
		super(name + " (7kW)", a);
	}

	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		return "Fehler: Leistungsueberschreitung";
	}

	public String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		return "Fehler: Leistungsueberschreitung";
	}

	public String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste) {
		
		liste.put(a.seriennummer(), a);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}
}
