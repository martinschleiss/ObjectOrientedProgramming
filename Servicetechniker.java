import java.util.TreeMap;


public class Servicetechniker extends Schwerarbeiter {

	/**
	 * Vorbedingung: liste != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String insertWennGueltig(TreeMap<Integer, Androide> liste) {
		
		return software().vonServicetechnikerInstalliert(this, liste);
	}
	
	public String toString() {
		
		return "Servicetechniker " + super.toString();
	}
}
