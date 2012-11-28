import java.util.TreeMap;


public class SicherheitsstufeDrei implements Sicherheitsstufe {
	
	public String aufSoftwareBauarbeiter(Bauarbeiter a, TreeMap<Integer,Androide> liste) {

		return "Sicherheitsstufe passt, " + a.skin().vonSchwerarbeiterInstalliert(a, liste);
	}
	
	public String aufSoftwareServicetechniker(Servicetechniker a, TreeMap<Integer,Androide> liste) {
		
		return "Sicherheitstufe passt, " + a.skin().vonSchwerarbeiterInstalliert(a, liste);
	}
	
	public String aufSoftwareTransportarbeiter(Transportarbeiter a, TreeMap<Integer,Androide> liste) {
		
		return "Sicherheitstufe passt, " + a.skin().vonSchwerarbeiterInstalliert(a, liste);
	}
	
	public String aufSoftwareGesellschafter(Gesellschafter a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareHilfskraft(Hilfskraft a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareKaempfer(Kaempfer a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareLeibwaechter(Leibwaechter a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	public String aufSoftwareObjektbewacher(Objektbewacher a, TreeMap<Integer,Androide> liste) {return "Sicherheitstufe passt nicht";}
	
	public String installiertKit(Schwerarbeiter a, TreeMap<Integer, Androide> liste) {
		
		return a.kit().vonStufe3Installiert(a, liste);	
	}
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Sicherheitsstufe: 3";
	}
}
