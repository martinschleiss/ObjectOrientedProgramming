import java.util.TreeMap;


public class SicherheitsstufeZwei extends Sicherheitsstufe {
	
	public String aufSoftwareHilfskraft(SoftwareHilfskraft s, Hilfskraft a, TreeMap<Integer, Androide> liste,String out) {
		out+="Sicherheitstufe passt, ";
		return a.skin().vonBedienerInstalliert(a, liste,out);
		
	}
	
	public String aufSoftwareGesellschafter(SoftwareGesellschafter s, Gesellschafter a, TreeMap<Integer, Androide> liste,String out) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareBauarbeiter(SoftwareBauarbeiter s, Bauarbeiter a, TreeMap<Integer, Androide> liste,String out) {return "Sicherheitsstufe passt nicht";}	
	public String aufSoftwareServicetechniker(SoftwareServicetechniker s, Servicetechniker a, TreeMap<Integer, Androide> liste,String out) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareTransportarbeiter(SoftwareTransportarbeiter s, Transportarbeiter a, TreeMap<Integer, Androide> liste,String out) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareLeibwaechter(SoftwareLeibwaechter s, Leibwaechter a, TreeMap<Integer, Androide> liste,String out) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareObjektbewacher(SoftwareObjektbewacher s, Objektbewacher a, TreeMap<Integer, Androide> liste,String out) {return "Sicherheitsstufe passt nicht";}
	public String aufSoftwareKaempfer(SoftwareKaempfer s, Kaempfer a, TreeMap<Integer, Androide> liste,String out) {return "Sicherheitsstufe passt nicht";}
}
