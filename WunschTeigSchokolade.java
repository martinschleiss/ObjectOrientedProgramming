
/**
 * Repraesentiert den Kundenwunsch Schokoladenteig
 */
public class WunschTeigSchokolade implements WunschTeig {

	/**
	 * liefert neue Instanz von Schokoladenteig
	 */
	@Override
	public Teig getTeig() {

		return new Schokoladenteig();
	}
	
	/**
	 * liefert String-Repraesentation der Klasse
	 */
	public String toString() {
		
		return "Schokolade";
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 * 
	 * Spezifiziert Schokoladenteig
	 */
	private class Schokoladenteig implements Teig {

		/**
		 * klont Instanz
		 * @return neue Instanz von Schokoladenteig
		 */
		public Teig clone() {
			
			return new Schokoladenteig();
		}
		
		/**
		 * liefert String-Repraesentation der Klasse
		 */
		public String toString() {
			
			return "Schokoladenteig";
		}
	}
}
