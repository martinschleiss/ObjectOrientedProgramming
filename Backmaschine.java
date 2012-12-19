/**
 * Beschreibt Backmaschinen, die eine Position entgegennehmen (eine Position beschreibt Anzahl, Form und eine optionale Fuellung)
 * und liefert eine Keksdose, die die Kekse enthaelt, die in der Position gewuenscht waren oder eine leere Keksdose, wenn die Backmaschine
 * die in der Position geforderten Kekse nicht backen kann.
 */
public interface Backmaschine {
	
	/**
	 * Liefert eine Keksdose entsprechend der Position p
	 * @param p != null
	 * @return	Keksdose: gefuellt mit in p geforderten Keksen, wenn die Backmaschine
	 * 			die geforderten Kekse backen kann, sonst: leere Keksdose
	 */
	public Keksdose backe(Position p);
}
