import java.util.TreeMap;


public class Objektbewacher extends Beschuetzer {

	/**
	 * Vorbedingung: liste != null
	 * Nachbedingung:
	 * 			entspricht Verordnung: wird der Liste hinzugefuegt (oder ueberschrieben)
	 * 			entspricht nicht der Verordnung: wird aus Liste geloescht, falls in Liste
	 * @return Aufzeichnungen der Ueberpruefung und ueber Erfolg oder Misserfolg des Inserts
	 */
	public String insertWennGueltig(TreeMap<Integer, Androide> liste) {
		
		return software().vonObjektbewacherInstalliert(this, liste);
	}
	
	public String toString() {
		
		return "Objektbewacher " + super.toString();
	}	
}
