import java.util.TreeMap;

/**
 * Interface, wird von der Sicherheitsstufen von Software implementiert
 * Beschreibt Visitor-Methoden um die Konformitaet der Sicherheitsstufe mit dem Androiden zu ueberpruefen
 * Die Sicherheitsstufe wird nach der Software und vor Skin und Kit ueberprueft.
 * Visitormethoden werden von Software aufgerufen und verweisen bei Erfolg direkt auf die Visitormethoden in Skin, diese wiederum bei Erfolg auf Kit
 */
public interface Sicherheitsstufe {

	/**
	 * Vorbedingung: liste und a (Bauarbeiter) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareBauarbeiter(Bauarbeiter a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Gesellschafter) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareGesellschafter(Gesellschafter a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Hilfskraft) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareHilfskraft(Hilfskraft a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Kaempfer) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareKaempfer(Kaempfer a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Leibwaechter) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareLeibwaechter(Leibwaechter a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Objektbewacher) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareObjektbewacher(Objektbewacher a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Servicetechniker) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareServicetechniker(Servicetechniker a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Transportarbeiter) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String aufSoftwareTransportarbeiter(Transportarbeiter a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Schwerarbeiter) != null
	 * Nachbedingung:
	 * 			b entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			b entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public abstract String installiertKit(Schwerarbeiter a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString();
}
