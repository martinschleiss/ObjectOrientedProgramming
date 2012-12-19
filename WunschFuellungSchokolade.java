
/**
 * Repraesentiert den Kundenwunsch Schokoladen-Fuellung
 */
public class WunschFuellungSchokolade implements WunschFuellung {

	/**
	 * liefert Schokoladenfuellung
	 */
	@Override
	public Fuellung getFuellung() {
		
		return new FuellungSchokolade();
	}
	
	/**
	 * liefert String-Repraesentation des Wunschs
	 */
	public String toString() {
		
		return "Schokolade";
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 * 
	 * Spezifiziert die Marmeladenfuellung
	 */
	private class FuellungSchokolade implements Fuellung {

		/**
		 * liefert String-Repraesentation des Wunschs
		 */
		public String toString(){
			
			return "Schokoladenfuellung";
		}
		
		/**
		 * klont Instanz
		 * @return neue Instanz von FuellungSchokolade
		 */
		public Fuellung clone() {
			
			return new FuellungSchokolade();
		}
	}
}