/**
 * 
 * @author Anil
 *
 */
	public class RehearsalLocation extends Location{
		
		private int distanceToCenter;
		private String wallColor;
		
		public RehearsalLocation(int district, int size, int stageSize, int distanceToCenter,String wallColor){
			super(district, size, stageSize);
			this.setDistanceToCenter(distanceToCenter);
			this.setWallColor(wallColor);
		}
		
		public int undefined(){
			return 0;
		}
		
		public int getDistanceToCenter() {
			return distanceToCenter;
		}
		//distanceToCenter>=0
		public void setDistanceToCenter(int distanceToCenter) {
			this.distanceToCenter = distanceToCenter;
		}

		public String getWallColor() {
			return wallColor;
		}

		public void setWallColor(String wallColor) {
			this.wallColor = wallColor;
		}
		
		public String toString() {
			
			return super.toString() + ", Distance To Center: " + distanceToCenter +" Wall Color: "+wallColor;
		}

		@Override
		public int compareTo(Location o) {
			// TODO Auto-generated method stub
			return 0;
		}


}
