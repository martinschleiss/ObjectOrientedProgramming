import java.util.TreeMap;


public class SkinSensitiv extends Skin {
	
	public SkinSensitiv(Androide a) {
		super(a);
	}
	
	public String vonBedienerInstalliert(Bediener a, TreeMap<Integer,Androide> liste) {
		
		return "Skin ok, " + a.kit().vonBedienerInstalliert(a, liste);
	}
	
	public String vonSchwerarbeiterInstalliert(Schwerarbeiter g, TreeMap<Integer,Androide> liste) {
		
		return "Skin ok, "; //TODO: visitor mit sicherheitsstufe einbaun. 3 oder 4
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
	
		return "Skin Sensitiv, " + super.toString();
	}
}