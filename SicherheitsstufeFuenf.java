import java.util.ArrayList;


public class SicherheitsstufeFuenf extends Sicherheitsstufe {
	
	//TODO: Zusicherungen definieren @Martin
	
	public void aufSoftwareKaempfer(SoftwareKaempfer s, Androide a, ArrayList<Androide> liste) {
		a.fuegeAndroideZuListeHinzu(liste);
	}
	
	public void aufSoftwareHilfskraft(SoftwareHilfskraft s, Androide a, ArrayList<Androide> liste) {}	
	public void aufSoftwareGesellschafter(SoftwareGesellschafter s, Androide a, ArrayList<Androide> liste) {}
	public void aufSoftwareBauarbeiter(SoftwareBauarbeiter s, Androide a, ArrayList<Androide> liste) {}	
	public void aufSoftwareServicetechniker(SoftwareServicetechniker s, Androide a, ArrayList<Androide> liste) {}
	public void aufSoftwareTransportarbeiter(SoftwareTransportarbeiter s, Androide a, ArrayList<Androide> liste) {}
	public void aufSoftwareLeibwaechter(SoftwareLeibwaechter s, Androide a, ArrayList<Androide> liste) {}
	public void aufSoftwareObjektbewacher(SoftwareObjektbewacher s, Androide a, ArrayList<Androide> liste) {}
	
}