
public class Description implements Shorter {
	
	/**
	 * NUR ZUM TEST, HAT NICHTS MIT AUFGABE ZU TUN UND KANN UEBERSCHRIEBEN WERDEN
	 */

	private Double i;
	
	public Description(Double i) {
		
		this.i = i;
	}
	
	public boolean shorter(Shorter other) {
		
		return this.i < other.getLength(); 
	}

	@Override
	public Double getLength() {

		return i;
	}
	
	public String toString() {
		
		return "Wert: " + i;
	}
}
