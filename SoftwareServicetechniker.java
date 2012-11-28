import java.util.TreeMap;


public class SoftwareServicetechniker extends Software {

	public SoftwareServicetechniker(Androide a, Sicherheitsstufe s) {
		
		super(a, s);
	}
	
	public String vonServicetechnikerInstalliert(Servicetechniker s, TreeMap<Integer,Androide> liste) { 

		return "Software ok, " + sicherheitsstufe().aufSoftwareServicetechniker(s, liste);
	}

	public String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Software passt nicht.";
	}
	
	public String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	};

	public String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonTransportarbeiterInstalliert(Transportarbeiter t, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}

	public String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer,Androide> liste){
		
		return "Fehler: Software passt nicht.";
	}	
	public String toString(){
		return "Software Servicetechniker";
	}
}
