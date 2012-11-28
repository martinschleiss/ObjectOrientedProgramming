import java.util.TreeMap;


public class SicherheitsstufeZwei implements Sicherheitsstufe {

	public String aufSoftwareHilfskraft(Hilfskraft a, TreeMap<Integer, Androide> liste) {
		
		return "Sicherheitstufe passt, " + a.skin().vonBedienerInstalliert(a, liste);
	}
	
	public String aufSoftwareGesellschafter(Gesellschafter a, TreeMap<Integer, Androide> liste) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareBauarbeiter(Bauarbeiter a, TreeMap<Integer, Androide> liste) {return "Sicherheitsstufe passt nicht";}	
	public String aufSoftwareServicetechniker(Servicetechniker a, TreeMap<Integer, Androide> liste) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareTransportarbeiter(Transportarbeiter a, TreeMap<Integer, Androide> liste) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareLeibwaechter(Leibwaechter a, TreeMap<Integer, Androide> liste) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareObjektbewacher(Objektbewacher a, TreeMap<Integer, Androide> liste) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareKaempfer(Kaempfer a, TreeMap<Integer, Androide> liste) {return "Sicherheitsstufe passt nicht";}
	
	public String installiertKit(Schwerarbeiter a, TreeMap<Integer, Androide> liste) {
		
		return "Fehler: Ungueltiger Programmzustand";
	}
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Sicherheitsstufe: 2";
	}
}
