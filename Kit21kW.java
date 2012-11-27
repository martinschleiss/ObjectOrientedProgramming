import java.util.TreeMap;


public class Kit21kW extends Kit {

	public Kit21kW(String name, int leistung, Androide a) {
		
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
