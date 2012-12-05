/**
 * Basisklasse fuer Strategien bietet Methode zum erzeugen eines Manoevers fuer Autos nach einem gewissen Schema (Zufall, Schlangenlinien)
 */

public abstract class Strategie {
	
	public Strategie() {

	}
	
	/**
	 * erzeugt ein gueltiges Manoever fuer das jeweils uebergebene Auto
	 * Bewegliche Autos duerfen nach links, halblinks, geradeaus, halbrechts und rechts lenken
	 * Bei Schnellen Autos duerfen nach halblinks, geradeaus und halbrechts lenken. rechts und links liefern null
	 * 
	 * @param a		!= null
	 * @return naechstes Feld fuer Auto a
	 */
	public abstract Feld naechstesManoever(Auto a);	
}
