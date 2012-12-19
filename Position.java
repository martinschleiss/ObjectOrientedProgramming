
/**
 * Repraesentiert einen homogenen Teil einer Bestellung
 * beschreibt, wieviele und welche Kekse gebacken werden sollen
 * dient auch als Input fuer Backmaschinen
 */
public class Position {
	
	private int anzahl; // > 0
	private WunschTeig teig;
	private WunschForm form;
	
	/**
	 * Konstruktor
	 * @param anzahl	> 0
	 * @param teig		!= null
	 * @param form		!= null
	 */
	public Position(int anzahl, WunschTeig teig, WunschForm form) {
		
		this.anzahl = anzahl;
		this.teig = teig;
		this.form = form;
	}
	
	/**
	 * Liefert Anzahl der bestellten Kekse einer Position
	 * @return Anzahl > 0
	 */
	public int getAnzahl() {
	
		return anzahl;
	}
	
	/**
	 * liefert fuer die Wunschform passende Backmaschine
	 * @return Backmaschine, die der Wunschform der Kekse entspricht
	 */
	public Backmaschine getBackmaschine() {
		
		return form.getBackmaschine();
	}
	
	/**
	 * liefert den passenden Teig fuer den angegebenen Teigwunsch
	 * @return Teig, die der Teigwunsch der Kekse entspricht
	 */
	public Teig getTeig() {
		
		return teig.getTeig();
	}
	
	/**
	 * liefert die Wunschform der Kekse
	 * @return Wunschform, die im Konstruktor gesetzt wurde
	 */
	public WunschForm getForm() {
		return form;
	}
	
	/**
	 * liefert String-Repraesentation der Position
	 */
	public String toString() {
		
		return "Anzahl: "+ anzahl + "\t" + teig + "-" + keks() + " in \"" + form + "\"-Form";
	}
	
	/**
	 * Spezifiziert Keksart fuer toString()
	 * @return Name != ""
	 */
	protected String keks() {
		
		return "Keks(e)";
	}
}
