import java.util.ArrayList;
import java.util.Iterator;


public class Bestellung {

	private ArrayList<Position> positionen;
	private Iterator<Position> it;
	private Position current;

	public Bestellung() {
		
		positionen = new ArrayList<Position>();
		it = null;
		current = null;
	}

	/**
	 * neuer Kekswunsch fuer einfache Kekse mit den folgenden parameter wird zur Liste hinzugefuegt
	 * @param anzahl Anzahl der gewuenschten Kekse
	 * @param teig	Teigart der gewuenschten Kekse
	 * @param form	die Form der gewuenschten Kekse
	 */
	public void addPositionKeks(int anzahl, WunschTeig teig, WunschForm form) {
		
		positionen.add(new Position(anzahl, teig, form));
	}
	
	/**
	 * neuer Kekswunsch fuer doppelte Kekse mit den folgenden parameter wird zur Liste hinzugefuegt
	 * @param anzahl Anzahl der gewuenschten Doppelkekse
	 * @param teig	Teigart der gewuenschten Doppelkekse
	 * @param form	die Form der gewuenschten Doppelkekse
	 *  @param fuellung	die Fuellung der gewuenschten Doppelkekse
	 */
	public void addPositionDoppelkeks(int anzahl, WunschTeig teig, WunschForm form, WunschFuellung fuellung) {
		
		positionen.add(new PositionDoppelkeks(anzahl, teig, form, fuellung));
	}
	
	/**
	 * gibt alle Positionen der Bestellung aus
	 */
	public void drucke() {
		
		for (Position p : positionen) {
			
			System.out.println(p);
		}
	}
	
	/**
	 * 
	 * @return false wenn es keinen naechsten Wunsch gibt True wenn es einen Naechsten gibt
	 */
	public boolean next() {
		
		if (it == null) {
			
			it = positionen.iterator();
		}
		
		if (it.hasNext()) {
			
			current = it.next();
			return true;
			
		} else {
			
			return false;
		}
	}
	
	/**
	 * 
	 * @return gibt die richtige Backmaschine entsprechend der aktuellen Position zurueck 
	 */
	public Backmaschine getCurrentBackmaschine() {
		
		if (current != null) {
			
			return current.getBackmaschine();
			
		} else {
			
			return null;
		}
	}
	
	
	public Position getCurrentPosition() {
		if (current != null) {
			
			return current;
			
		} else {
			
			return null;
		}
	}
}