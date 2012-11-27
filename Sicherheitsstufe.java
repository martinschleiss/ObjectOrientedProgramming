import java.util.TreeMap;


public abstract class Sicherheitsstufe {
	
	public abstract String aufSoftwareBauarbeiter(SoftwareBauarbeiter s, Bauarbeiter a, TreeMap<Integer, Androide> liste,String out);
	public abstract String aufSoftwareGesellschafter(SoftwareGesellschafter s, Gesellschafter a, TreeMap<Integer, Androide> liste,String out);
	public abstract String aufSoftwareHilfskraft(SoftwareHilfskraft s, Hilfskraft a, TreeMap<Integer, Androide> liste,String out);
	public abstract String aufSoftwareKaempfer(SoftwareKaempfer s, Kaempfer a, TreeMap<Integer, Androide> liste,String out);
	public abstract String aufSoftwareLeibwaechter(SoftwareLeibwaechter s, Leibwaechter a, TreeMap<Integer, Androide> liste,String out);
	public abstract String aufSoftwareObjektbewacher(SoftwareObjektbewacher s, Objektbewacher a, TreeMap<Integer, Androide> liste,String out);
	public abstract String aufSoftwareServicetechniker(SoftwareServicetechniker s, Servicetechniker a, TreeMap<Integer, Androide> liste,String out);
	public abstract String aufSoftwareTransportarbeiter(SoftwareTransportarbeiter s, Transportarbeiter a, TreeMap<Integer, Androide> liste,String out);

}
