import java.util.TreeMap;


public class Kit1kW extends Kit {

	public Kit1kW(String name, int leistung, Androide a) {
		
		super(name + " (1kW)", a);
	}
	
	public String vonBedienerInstalliert(Bediener b, TreeMap<Integer, Androide> liste) {

		liste.put(b.seriennummer(), b);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}

	public String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste) {

		liste.put(a.seriennummer(), a);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}

	public String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste) {
		
		liste.put(a.seriennummer(), a);
		return "Kit ok - Ueberpruefung erfolgreich. Androide wurde eingefuegt";
	}
}
