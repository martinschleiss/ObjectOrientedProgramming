import java.util.TreeMap;


public class SoftwareLeibwaechter extends Software {

	public SoftwareLeibwaechter(Androide a, Sicherheitsstufe s) {
		
		super(a, s);
	}
	
	/**
	 * Fuer alle nachfolgenden Visitor-Methoden:
	 * Vorbedingung: liste und Android != null, Androide.software() != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	
	public String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer,Androide> liste) { 

		return "Software ok, " + sicherheitsstufe().aufSoftwareLeibwaechter(l, liste);
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

	public String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer,Androide> liste){

		liste.remove(o.seriennummer());
		return "Fehler: Software passt nicht. Androide wurde nicht eingefuegt";
	}

	public String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste){

		liste.remove(k.seriennummer());
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
		
		return "Software Leibwaechter" + super.toString();
	}
}
