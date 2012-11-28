import java.util.TreeMap;


public class SoftwareHilfskraft extends Software {

	public SoftwareHilfskraft(Androide a, Sicherheitsstufe s) {
		
		super(a, s);
	}
	
	public String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer,Androide> liste) { 

		return "Software ok, " + sicherheitsstufe().aufSoftwareHilfskraft(h, liste);
	}

	public String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer,Androide> liste) {

		liste.remove(b.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}
	
	public String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer,Androide> liste){

		liste.remove(g.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	};

	public String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste){

		liste.remove(k.seriennummer());
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
		
		return "Hilfskraft-" + super.toString();
	}
}
