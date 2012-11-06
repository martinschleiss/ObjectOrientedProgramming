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
		 * 			Vorbedinugungen des Superkonstruktors und	
		 * 				@param distanceToCenter > 0
		 * 				@param wallColor muss einer Farbe entsprechen
		 */
		public RehearsalLocation(int district, int size, int stageSize, int distanceToCenter,String wallColor){
			super(district, size, stageSize);
			this.setDistanceToCenter(distanceToCenter);
			this.setWallColor(wallColor);
		}
		
		public int getDistanceToCenter() {
			return distanceToCenter;
		}
		
		/**
		 * Vorbedingungen:
		 * @param distanceToCenter > 0
		 * 
		 * Nachbedingungen: distanceToCenter wird als neue Distanz gespeichert
		 */
		public void setDistanceToCenter(int distanceToCenter) {
			this.distanceToCenter = distanceToCenter;
		}

		public String getWallColor() {
			return wallColor;
		}

		/**
		 * Vorbedingungen:
		 * @param wallColor entspricht einer Farbe
		 * 
		 * Nachbedingungen: wallColor wird als neue Farbe gespeichert
		 */
		public void setWallColor(String wallColor) {
			this.wallColor = wallColor;
		}
		
		public String toString() {
			
			return super.toString() + ", Distance To Center: " + distanceToCenter +" Wall Color: "+wallColor;
		}
}
