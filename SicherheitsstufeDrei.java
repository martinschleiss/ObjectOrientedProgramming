import java.util.TreeMap;


public class SicherheitsstufeDrei extends Sicherheitsstufe {
	
	//TODO: Zusicherungen definieren @Martin
	
	public String aufSoftwareBauarbeiter(Androide a, TreeMap<Integer,Androide> liste) {
		
		return "Sicherheitsstufe ok, " + a.skin().vonBauarbeiterInstalliert(a, liste);
	}
	
	public String aufSoftwareServicetechniker(Androide a, TreeMap<Integer,Androide> liste) {

		return "Sicherheitsstufe ok, " + a.skin().vonServiceTechnikerInstalliert(a, liste);
	}
	
	public String aufSoftwareTransportarbeiter(Androide a, TreeMap<Integer,Androide> liste) {

		return "Sicherheitsstufe ok, " + a.skin().vonTransportArbeiterInstalliert(a, liste);
	}
	
	public String aufSoftwareGesellschafter(Androide a, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Sicherheitsstufe passt nicht.";
	}
	public String aufSoftwareHilfskraft(Androide a, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Sicherheitsstufe passt nicht.";
	}
	public String aufSoftwareKaempfer(Androide a, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Sicherheitsstufe passt nicht.";
	}
	public String aufSoftwareLeibwaechter(Androide a, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Sicherheitsstufe passt nicht.";
	}
	public String aufSoftwareObjektbewacher(Androide a, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Sicherheitsstufe passt nicht.";
	}
}
