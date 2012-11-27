import java.util.TreeMap;


public class SkinGepanzert extends Skin {

	public SkinGepanzert(Androide a) {
		super(a);
	}

	public String vonBedienerInstalliert(Bediener a, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Skin passt nicht";
	}
	
	public String vonSchwerarbeiterInstalliert(Schwerarbeiter g, TreeMap<Integer,Androide> liste) {
		
		return "Fehler: Skin passt nicht";
	}
	
	public String vonObjektbewacherInstalliert(Objektbewacher a, TreeMap<Integer,Androide> liste) {

		return "Skin ok, " + a.kit().vonStufe4Installiert(a, liste);
	}
	
	public String vonLeibwaechterInstalliert(Leibwaechter a, TreeMap<Integer,Androide> liste) {

		return "Skin ok, " + a.kit().vonStufe4Installiert(a, liste);
	}
	
	public String vonKaempferInstalliert(Kaempfer a, TreeMap<Integer, Androide> liste) {
		
		return "Skin ok, " + a.kit().vonKaemperInstalliert(a, liste);
	}

	public String toString() {

		return "Skin Gepanzert, " + super.toString();
	}
}
