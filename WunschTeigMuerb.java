
/**
 * Repraesentiert den Kundenwunsch Muerbteig
 */
public class WunschTeigMuerb implements WunschTeig {

	/**
	 * liefert neue Instanz von Muerbteig
	 */
	@Override
	public Teig getTeig() {

		return new Muerbteig();
	}
	
	/**
	 * liefert String-Repraesentation der Klasse
	 */
	public String toString() {
		
		return "Muerb";
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 * 
	 * Spezifiziert Muerbteig
	 */
	private class Muerbteig implements Teig {

		/**
		 * klont Instanz
		 * @return neue Instanz von Muerbteig
		 */
		public Teig clone() {
			
			return new Muerbteig();
		}
		
		/**
		 * liefert String-Repraesentation der Klasse
		 */
		public String toString() {
			
			return "Muerbteig";
		}
	}
}
