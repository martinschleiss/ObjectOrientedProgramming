import java.util.TreeMap;


public class SicherheitsstufeEins extends Sicherheitsstufe {

	public String aufSoftwareGesellschafter(Gesellschafter a, TreeMap<Integer,Androide> liste) {

		return "Sicherheitsstufe passt, " + a.skin().vonBedienerInstalliert(a, liste);
	}

	public String aufSoftwareHilfsKraft(Hilfskraft a, TreeMap<Integer,Androide> liste) {

		return "Sicherheitstufe passt, " + a.skin().vonBedienerInstalliert(a, liste);
	}

	public String aufSoftwareKaempfer(Kaempfer a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareLeibwaechter(Leibwaechter a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareObjektbewacher(Objektbewacher a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareBauarbeiter(Bauarbeiter a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareHilfskraft(Hilfskraft a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareServicetechniker(Servicetechniker a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareTransportarbeiter(Transportarbeiter a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	
	public String installiertKit(Schwerarbeiter a, TreeMap<Integer, Androide> liste) {
		
		return "Fehler: Ungueltiger Programmzustand";
	}
}
