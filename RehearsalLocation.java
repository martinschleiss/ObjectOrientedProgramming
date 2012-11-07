/**
 * 
 * @author Anil
 *
 */
	public class RehearsalLocation extends Location{
		
		private int distanceToCenter;
		private String wallColor;
		
		/**
		 * Vorbedingungen: 
		 * Vorbedinugungen des Superkonstruktors und	
		 * @param distanceToCenter 	> 0, in Meter
		 * @param wallColor 		muss einer Farbe entsprechen
		 * 
		 * Nachbedingung:
		 * Objekt wurde korrekt initialisiert.
		 */
		public RehearsalLocation(int district, int size, int stageSize, int distanceToCenter,String wallColor){
			super(district, size, stageSize);
			this.setDistanceToCenter(distanceToCenter);
			this.setWallColor(wallColor);
		}
		
		/**
		 * Nachbedingung:
		 * @return Abstand zum Zentrum in Meter
		 */
		public int getDistanceToCenter() {
			return distanceToCenter;
		}
		
		/**
		 * Vorbedingungen:
		 * @param distanceToCenter > 0, in Meter
		 * 
		 * Nachbedingungen: distanceToCenter wird als neue Distanz gespeichert
		 */
		public void setDistanceToCenter(int distanceToCenter) {
			this.distanceToCenter = distanceToCenter;
		}
		
		/**
		 * Nachbedingung:
		 * @return Wandfarbe
		 */

		public String getWallColor() {
			return wallColor;
		}

		/**
		 * Vorbedingungen:
		 * @param wallColor 	entspricht einer Farbe
		 * 
		 * Nachbedingungen: wallColor wird gespeichert
		 */
		public void setWallColor(String wallColor) {
			this.wallColor = wallColor;
		}
		
		/**
		 * Nachbedingung:
		 * @return String-Repraesentation des Objekts
		 */
		public String toString() {
			
			return super.toString() + ", Distance To Center: " + distanceToCenter +" Wall Color: "+wallColor;
		}
}
