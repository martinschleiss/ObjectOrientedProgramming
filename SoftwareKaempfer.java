import java.util.TreeMap;


public class SoftwareKaempfer extends Software {

	public SoftwareKaempfer(Androide a, Sicherheitsstufe s) {
		
		super(a, s);
	}
	
	public String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste) { 

		return "Software ok, " + sicherheitsstufe().aufSoftwareKaempfer(k, liste);
	}

	public String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer,Androide> liste) {

		liste.remove(b.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}
	
	public String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer,Androide> liste){

		liste.remove(g.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	};

	public String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer,Androide> liste){

		liste.remove(h.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}

	public String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer,Androide> liste){

		liste.remove(l.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}

	public String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer,Androide> liste){

		liste.remove(o.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}

	public String vonServicetechnikerInstalliert(Servicetechniker s, TreeMap<Integer,Androide> liste){

		liste.remove(s.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}

	public String vonTransportarbeiterInstalliert(Transportarbeiter t, TreeMap<Integer,Androide> liste){

		liste.remove(t.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}
	public String toString(){
		
		return "Software Kaempfer" + super.toString();
	}
}
