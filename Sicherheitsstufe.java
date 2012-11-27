import java.util.TreeMap;


public abstract class Sicherheitsstufe {
	
	public abstract String aufSoftwareBauarbeiter(Bauarbeiter a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareGesellschafter(Gesellschafter a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareHilfskraft(Hilfskraft a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareKaempfer(Kaempfer a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareLeibwaechter(Leibwaechter a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareObjektbewacher(Objektbewacher a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareServicetechniker(Servicetechniker a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareTransportarbeiter(Transportarbeiter a, TreeMap<Integer, Androide> liste);
	
	public abstract String installiertKit(Schwerarbeiter a, TreeMap<Integer, Androide> liste);
}
