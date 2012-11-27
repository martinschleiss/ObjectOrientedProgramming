import java.util.TreeMap;


public class SoftwareGesellschafter extends Software {

	public SoftwareGesellschafter(Androide a, Sicherheitsstufe s) {
		
		super(a, s);
	}
	
	public String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer,Androide> liste) { 

		return "Software ok, " + sicherheitsstufe().aufSoftwareGesellschafter(g, liste);
	}

	public String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Software passt nicht.";
	}
	
	public String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	};

	public String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonServicetechnikerInstalliert(Servicetechniker s, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonTransportarbeiterInstalliert(Transportarbeiter t, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}
}
