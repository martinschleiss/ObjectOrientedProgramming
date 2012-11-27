import java.util.TreeMap;


public class Kit3kW extends Kit {

	public Kit3kW(String name, int leistung, Androide a) {
		
		super(name + " (3kW)", a);
	}
	
	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		return "Fehler: Leistungsueberschreitung";
	}

	public String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		return "Kit ok";
	}

	public String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste) {
		
		return "Kit ok";
	}
}
