import java.util.TreeMap;


public class SicherheitsstufeFuenf extends Sicherheitsstufe {
	
	//TODO: Zusicherungen definieren @Martin
	
	public void aufSoftwareKaempfer(SoftwareKaempfer s, Androide a, TreeMap<Integer, Androide> liste) {
		a.fuegeAndroideZuListeHinzu(liste);
	}
	
	public void aufSoftwareHilfskraft(SoftwareHilfskraft s, Androide a, TreeMap<Integer, Androide> liste) {}	
	public void aufSoftwareGesellschafter(SoftwareGesellschafter s, Androide a, TreeMap<Integer, Androide> liste) {}
	public void aufSoftwareBauarbeiter(SoftwareBauarbeiter s, Androide a, TreeMap<Integer, Androide> liste) {}	
	public void aufSoftwareServicetechniker(SoftwareServicetechniker s, Androide a, TreeMap<Integer, Androide> liste) {}
	public void aufSoftwareTransportarbeiter(SoftwareTransportarbeiter s, Androide a, TreeMap<Integer, Androide> liste) {}
	public void aufSoftwareLeibwaechter(SoftwareLeibwaechter s, Androide a, TreeMap<Integer, Androide> liste) {}
	public void aufSoftwareObjektbewacher(SoftwareObjektbewacher s, Androide a, TreeMap<Integer, Androide> liste) {}
	
}
