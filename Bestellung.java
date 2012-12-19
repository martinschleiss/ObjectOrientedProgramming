import java.util.ArrayList;
import java.util.Iterator;

/**
 * Repraesentiert eine Keks-Bestellung fuer Baeckereien
 */
public class Bestellung {

	private ArrayList<Position> positionen;
	private Iterator<Position> it;

	public Bestellung() {

		positionen = new ArrayList<Position>();
		it = null;
	}

	/**
	 * Fuegt neue Position fuer einfache Kekse zur Bestellung hinzu
	 * @param anzahl	> 0
	 * @param teig		!= null
	 * @param form		!= null
	 */
	public void addPositionKeks(int anzahl, WunschTeig teig, WunschForm form) {

		if (anzahl > 0) {

			positionen.add(new Position(anzahl, teig, form));
		}
	}

	/**
	 * Fuegt neue Position fuer doppelte Kekse zur Bestellung hinzu
	 * @param anzahl	> 0
	 * @param teig		!= null
	 * @param form		!= null
	 * @param fuellung	!= null
	 */
	public void addPositionDoppelkeks(int anzahl, WunschTeig teig, WunschForm form, WunschFuellung fuellung) {

		if (anzahl > 0) {

			positionen.add(new PositionDoppelkeks(anzahl, teig, form, fuellung));
		}
	}

	/**
	 * gibt alle Positionen der Bestellung aus
	 */
	public void drucke() {

		System.out.println("+++++++++++++++++++ Bestellung +++++++++++++++++++\n");

		if (positionen.isEmpty()) {

			System.out.println("leere Bestellung");

		} else {

			for (Position p : positionen) {

				System.out.println(p);
			}
		}
		
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	/**
	 * Hilft beim Iterieren durch die Positionen mit next(), liefert Wahrheitswert, ob Ende der Liste erreicht
	 * @return true: naechste Position vorhanden (mit next()), sonst false (next() liefert null)
	 */
	public boolean hasNext() {

		if (it == null) {

			it = positionen.iterator();
		}

		return it.hasNext();
	}

	/**
	 * Liefert naechstes Element der Positionsliste
	 * @return naechstes Element, wenn vorhanden (hasNext() == true), null sonst (hasNext() == false)
	 */
	public Position next() {

		if (it == null) {

			it = positionen.iterator();
		}
		
		return it.next();
	}
}