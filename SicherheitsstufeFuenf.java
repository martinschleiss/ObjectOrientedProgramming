import java.util.TreeMap;


public class SicherheitsstufeFuenf implements Sicherheitsstufe {
	
	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareKaempfer(Kaempfer a, TreeMap<Integer,Androide> liste) {

		return "Sicherheitsstufe ok, " + a.skin().vonKaempferInstalliert(a, liste);
	}
	
	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareLeibwaechter(Leibwaechter a, TreeMap<Integer,Androide> liste) {

		liste.remove(a.seriennummer());
		return "Sicherheitsstufe passt nicht. Androide wurde nicht eingefuegt";
	}

	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareObjektbewacher(Objektbewacher a, TreeMap<Integer,Androide> liste) {

		liste.remove(a.seriennummer());
		return "Sicherheitsstufe passt nicht. Androide wurde nicht eingefuegt";
	}


	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareBauarbeiter(Bauarbeiter a, TreeMap<Integer, Androide> liste) {

		liste.remove(a.seriennummer());
		return "Sicherheitsstufe passt nicht. Androide wurde nicht eingefuegt";
	}

	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareHilfskraft(Hilfskraft a, TreeMap<Integer, Androide> liste) {

		liste.remove(a.seriennummer());
		return "Sicherheitsstufe passt nicht. Androide wurde nicht eingefuegt";
	}

	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareServicetechniker(Servicetechniker a, TreeMap<Integer, Androide> liste) {

		liste.remove(a.seriennummer());
		return "Sicherheitsstufe passt nicht. Androide wurde nicht eingefuegt";
	}

	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareTransportarbeiter(Transportarbeiter a, TreeMap<Integer, Androide> liste) {

		liste.remove(a.seriennummer());
		return "Sicherheitsstufe passt nicht. Androide wurde nicht eingefuegt";
	}

	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String aufSoftwareGesellschafter(Gesellschafter a, TreeMap<Integer, Androide> liste) {

		liste.remove(a.seriennummer());
		return "Sicherheitsstufe passt nicht. Androide wurde nicht eingefuegt";
	}

	/**
	 * Vorbedingung: liste und a != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String installiertKit(Schwerarbeiter a, TreeMap<Integer, Androide> liste) {

		return "Fehler: Ungueltiger Programmzustand";
	}

	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {

		return "Sicherheitsstufe: 5";
	}
}
