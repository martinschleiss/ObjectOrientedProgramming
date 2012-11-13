public class ClearBox extends Box {
	
	private double ratio;
	
	public ClearBox(int width, int height) {
		
		super(width, height, ' ', '*');
		
		this.ratio = width/height;
	}
	
	/**
	 * Liefert Verhaeltnis Breite/Hoehe
	 * @return ratio	> 0
	 */
	public double getRatio() {
		
		return ratio;
	}
}