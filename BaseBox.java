public abstract class BaseBox implements Pict {

		private double width;		//Invariante: > 0
		private double height;		//Invariante: > 0

		public BaseBox(int width, int height, char content, char frame) throws IllegalArgumentException{

			if (frame == ' ') {
				throw new IllegalArgumentException("Kein Leerzeichen als Rahmen erlaubt");
			}

			this.width = width;
			this.height = height;
		}
		
		protected double getWidth() {
			
			return width;
		}
		protected double getHeight() {
			
			return height;
		}

		/**
		 * 0.1 <= factor <= 10.0; resize the picture	
		 */
		public void scale (double factor) {

			width *= factor;
			height *= factor;

		}

		/**
		 * returns the picture as String
		 */		
		public abstract String toString();
}
