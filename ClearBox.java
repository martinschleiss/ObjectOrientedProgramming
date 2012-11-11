public class ClearBox extends Box {
	
	private double ratio;
	
	public ClearBox(double width, double height) {
		
		super(width, height, ' ', '*');
		
		this.ratio = width/height;
	}
	
	public double getRatio() {
		
		return ratio;
	}
}