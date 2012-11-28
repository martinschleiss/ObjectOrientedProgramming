import java.util.TreeMap;


public class Transportarbeiter extends Schwerarbeiter {

	/**
	 * Vorbedingung: liste != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String insertWennGueltig(TreeMap<Integer, Androide> liste) {
		return software().vonTransportarbeiterInstalliert(this, liste);
	}
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Transportarbeiter " + super.toString();
	}	
}
