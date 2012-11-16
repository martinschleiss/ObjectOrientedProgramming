
public class Description implements Shorter {

	private int i;
	
	public Description(int i) {
		
		this.i = i;
	}
	
	public boolean shorter(Shorter other) {
		
		return this.i < other.getLength(); 
	}

	@Override
	public int getLength() {

		return i;
	}
	
	public String toString() {
		
		return "Wert: " + i;
	}
}
