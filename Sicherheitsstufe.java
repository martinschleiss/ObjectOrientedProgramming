import java.util.TreeMap;


public abstract class Sicherheitsstufe {
	
	//TODO: Zusicherungen definieren @Martin
	
	public abstract void aufSoftwareBauarbeiter(SoftwareBauarbeiter s, Androide a, TreeMap<Integer, Androide> liste);
	public abstract void aufSoftwareGesellschafter(SoftwareGesellschafter s, Androide a, TreeMap<Integer, Androide> liste);
	public abstract void aufSoftwareHilfskraft(SoftwareHilfskraft s, Androide a, TreeMap<Integer, Androide> liste);
	public abstract void aufSoftwareKaempfer(SoftwareKaempfer s, Androide a, TreeMap<Integer, Androide> liste);
	public abstract void aufSoftwareLeibwaechter(SoftwareLeibwaechter s, Androide a, TreeMap<Integer, Androide> liste);
	public abstract void aufSoftwareObjektbewacher(SoftwareObjektbewacher s, Androide a, TreeMap<Integer, Androide> liste);
	public abstract void aufSoftwareServicetechniker(SoftwareServicetechniker s, Androide a, TreeMap<Integer, Androide> liste);
	public abstract void aufSoftwareTransportarbeiter(SoftwareTransportarbeiter s, Androide a, TreeMap<Integer, Androide> liste);

}
