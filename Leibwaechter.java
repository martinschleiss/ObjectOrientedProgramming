import java.util.TreeMap;


public class Leibwaechter extends Beschuetzer {

	/**
	 * Vorbedingung: liste != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String insertWennGueltig(TreeMap<Integer, Androide> liste) {
		
		return software().vonLeibwaechterInstalliert(this, liste);
	}
	
	public String toString() {
		
		return "Leibwaechter " + super.toString();
	}	
}
