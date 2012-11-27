import java.util.TreeMap;


public class Kit1kW extends Kit {

	public Kit1kW(String name, int leistung, Androide a) {
		
		super(name + " (1kW)", a);
	}
	
	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		return "Kit ok";
	}

	public String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		return "Kit ok";
	}

	public String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste) {
		
		return "Kit ok";
	}
}
