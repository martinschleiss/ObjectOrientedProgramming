
/**
 * Repraesentiert einen homogenen Teil einer Bestellung
 * beschreibt, wieviele und welche Kekse gebacken werden sollen
 * dient auch als Input fuer Backmaschinen
 */
public class PositionDoppelkeks extends Position {
	
	private WunschFuellung fuellung;
	
	/**
	 * Konstruktor
	 * @param anzahl	> 0
	 * @param teig		!= null
	 * @param form		!= null
	 * @param fuellung	!= null
	 */
	public PositionDoppelkeks(int anzahl, WunschTeig teig, WunschForm form, WunschFuellung fuellung) {
		
		super(anzahl, teig, form);
		this.fuellung = fuellung;
	}
	
	/**
	 * liefert eine Doppelbackmaschine
	 * @return neue Doppelbackmaschine
	 */
	@Override
	public Backmaschine getBackmaschine() {
		
		return new BackmaschineDoppelt();
	}
	
	/**
	 * liefert die passende Fuellung fuer den angegebenen Fuellungswunsch
	 * @return Fuellung, die dem Fuellungswunsch der Kekse entspricht
	 */
	public Fuellung getFuellung() {
		
		return fuellung.getFuellung();
	}
	
	/**
	 * liefert String-Repraesentation der PositionDoppelkeks
	 */
	public String toString() {
		
		return super.toString() + " mit \"" + fuellung + "\"-Fuellung";
	}
	
	/**
	 * Spezifiziert Keksart fuer toString()
	 * @return Name != ""
	 */
	protected String keks() {
		
		return "Doppelkeks(e)";
	}
}