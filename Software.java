import java.util.TreeMap;

/**
 * Eine Instanz dieser Software ist Bestandteil genau eines Androiden.
 * Beschreibt Visitor-Methoden um die Konformitaet der Software mit dem Androiden zu ueberpruefen
 * Die Software wird als erstes ueberprueft.
 * Visitormethoden werden von Shop aufgerufen und verweisen bei Erfolg direkt auf die Visitormethoden in Sicherheitsstufe -> Skin -> Kit
 */
public abstract class Software {

	private final int codierung; //= Seriennummer des Androiden, der mit dieser Software ausgestattet ist.
	private final Sicherheitsstufe s; //darf laut Angabe nicht veraendert werden
	
	public Software(Androide a, Sicherheitsstufe s) {
		
		this.s = s;
		codierung = a.seriennummer();
	}
	
	public Sicherheitsstufe sicherheitsstufe() {
		
		return s;
	}
	
	/**
	 * Vorbedingung: liste und Bauarbeiter != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonBauarbeiterInstalliert(Bauarbeiter b, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und Gesellschafter != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonGesellschafterInstalliert(Gesellschafter g, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und Hilfskraft != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonHilfskraftInstalliert(Hilfskraft h, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und Kaempfer != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonKaempferInstalliert(Kaempfer k, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und Leibwaechter != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonLeibwaechterInstalliert(Leibwaechter l, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und Objektbewacher != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonObjektbewacherInstalliert(Objektbewacher o, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und Servicetechniker != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonServicetechnikerInstalliert(Servicetechniker s, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und Transportarbeiter != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String vonTransportarbeiterInstalliert(Transportarbeiter t, TreeMap<Integer,Androide> liste);
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Software, " + s.toString() + ", Codierung: " + codierung;
	}
}
