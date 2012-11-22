
public abstract class Androide {
	
	private static int serial = 0;
	private final int serialNumber;
	
	public Androide() {
		serialNumber = serial++;
	}
	
	public final int getSerialNumber() {
		return serialNumber;
	}

}
