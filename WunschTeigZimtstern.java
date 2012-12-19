
/**
 * Repraesentiert den Kundenwunsch Zimtsternteig
 */
public class WunschTeigZimtstern implements WunschTeig {

	/**
	 * liefert neue Instanz von Zimtsternteig
	 */
	@Override
	public Teig getTeig() {

		return new Zimtsternteig();
	}
	
	/**
	 * liefert String-Repraesentation der Klasse
	 */
	public String toString() {
		
		return "Zimtstern";
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 * 
	 * Spezifiziert Zimtsternteig
	 */
	private class Zimtsternteig implements Teig {

		/**
		 * klont Instanz
		 * @return neue Instanz von Zimtsternteig
		 */
		public Teig clone() {
			
			return new Zimtsternteig();
		}
		
		/**
		 * liefert String-Repraesentation der Klasse
		 */
		public String toString() {
			
			return "Zimtsternteig";
		}
	}
}
