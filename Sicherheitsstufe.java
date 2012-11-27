import java.util.TreeMap;


public abstract class Sicherheitsstufe {
	
	//TODO: Zusicherungen definieren @Martin
	
	public abstract String aufSoftwareBauarbeiter(Androide a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareGesellschafter(Androide a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareHilfskraft(Androide a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareKaempfer(Androide a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareLeibwaechter(Androide a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareObjektbewacher(Androide a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareServicetechniker(Androide a, TreeMap<Integer, Androide> liste);
	public abstract String aufSoftwareTransportarbeiter(Androide a, TreeMap<Integer, Androide> liste);

}
