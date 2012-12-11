/**
 * Basisklasse fuer Traktorerweiterungen bietet Methode zum Abfragen des Ausmasses (z.B. Fassungsvermoegen)
 */
public abstract class TraktorErweiterung {

	/**
	 * Liefert Groesse des Ausmasses
	 * @return ausmass >= 0
	 * 			kann je nach Unterklasse auch nur ganzzahlige Genauigkeit haben
	 */
	public abstract double erweiterungsAusmass();
}
