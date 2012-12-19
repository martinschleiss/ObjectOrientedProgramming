
/**
 * Repraesentiert den Kundenwunsch Marmelade-Fuellung
 */
public class WunschFuellungMarmelade implements WunschFuellung {

	/**
	 * liefert Marmeladenfuellung
	 */
	@Override
	public Fuellung getFuellung() {

		return new FuellungMarmelade();
	}
	
	/**
	 * liefert String-Repraesentation des Wunschs
	 */
	public String toString() {
		
		return "Marmelade";
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 * 
	 * Spezifiziert die Marmeladenfuellung
	 */
	private class FuellungMarmelade implements Fuellung {

		/**
		 * liefert String-Repraesentation des Wunschs
		 */
		public String toString(){
			
			return "Marmeladenfuellung";
		}
		
		/**
		 * klont Instanz
		 * @return neue Instanz von FuellungMarmelade
		 */
		public Fuellung clone() {
			
			return new FuellungMarmelade();
		}
	}
}