import java.util.ArrayList;


public class SicherheitsstufeVier extends Sicherheitsstufe {

	//TODO: Zusicherungen definieren @Martin
	
	public void aufSoftwareBauarbeiter(SoftwareBauarbeiter s, Androide a, ArrayList<Androide> liste) {
		//a.fuegeAndroideZuListeHinzu(liste);
		a.skin().vonSchwerarbeiterInstalliert(a, liste); //geht nicht aufgrund von ArrayList - HashMap madness
	}
	
	public void aufSoftwareServicetechniker(SoftwareServicetechniker s, Androide a, ArrayList<Androide> liste) {
		a.fuegeAndroideZuListeHinzu(liste);
	}
	
	public void aufSoftwareTransportarbeiter(SoftwareTransportarbeiter s, Androide a, ArrayList<Androide> liste) {
		a.fuegeAndroideZuListeHinzu(liste);
	}
	
	public void aufSoftwareLeibwaechter(SoftwareLeibwaechter s, Androide a, ArrayList<Androide> liste) {
		a.fuegeAndroideZuListeHinzu(liste);
	}
	
	public void aufSoftwareObjektbewacher(SoftwareObjektbewacher s, Androide a, ArrayList<Androide> liste) {
		a.fuegeAndroideZuListeHinzu(liste);
	}
	
	public void aufSoftwareGesellschafter(SoftwareGesellschafter s, Androide a, ArrayList<Androide> liste) {}
	public void aufSoftwareHilfskraft(SoftwareHilfskraft s, Androide a, ArrayList<Androide> liste) {}
	public void aufSoftwareKaempfer(SoftwareKaempfer s, Androide a, ArrayList<Androide> liste) {}
	
}