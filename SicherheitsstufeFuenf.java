import java.util.TreeMap;


public class SicherheitsstufeFuenf extends Sicherheitsstufe {
	
	public String aufSoftwareKaempfer(Kaempfer a, TreeMap<Integer,Androide> liste) {

		return "Sicherheitstufe passt, " + a.skin().vonKaempferInstalliert(a, liste);
	}

	public String aufSoftwareLeibwaechter(Leibwaechter a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareObjektbewacher(Objektbewacher a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareBauarbeiter(Bauarbeiter a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareHilfskraft(Hilfskraft a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareServicetechniker(Servicetechniker a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareTransportarbeiter(Transportarbeiter a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareGesellschafter(Gesellschafter a, TreeMap<Integer, Androide> liste) {return "Sicherheitstufe passt nicht";}
	
	public String installiertKit(Schwerarbeiter a, TreeMap<Integer, Androide> liste) {
		
		return "Fehler: Ungueltiger Programmzustand";
	}
}
