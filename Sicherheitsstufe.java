import java.util.ArrayList;
public abstract class Sicherheitsstufe {
	
	//TODO: Zusicherungen definieren @Martin
	
	public abstract void aufSoftwareBauarbeiter(SoftwareBauarbeiter s, Androide a, ArrayList<Androide> liste);
	public abstract void aufSoftwareGesellschafter(SoftwareGesellschafter s, Androide a, ArrayList<Androide> liste);
	public abstract void aufSoftwareHilfskraft(SoftwareHilfskraft s, Androide a, ArrayList<Androide> liste);
	public abstract void aufSoftwareKaempfer(SoftwareKaempfer s, Androide a, ArrayList<Androide> liste);
	public abstract void aufSoftwareLeibwaechter(SoftwareLeibwaechter s, Androide a, ArrayList<Androide> liste);
	public abstract void aufSoftwareObjektbewacher(SoftwareObjektbewacher s, Androide a, ArrayList<Androide> liste);
	public abstract void aufSoftwareServicetechniker(SoftwareServicetechniker s, Androide a, ArrayList<Androide> liste);
	public abstract void aufSoftwareTransportarbeiter(SoftwareTransportarbeiter s, Androide a, ArrayList<Androide> liste);

}
