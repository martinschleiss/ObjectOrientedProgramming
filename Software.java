/**
 * Eine Instanz dieser Software ist Bestandteil genau eines Androiden.
 */
public abstract class Software {
	
	private int sicherheitsstufe; // 1 <= sicherheitsstufe <= 5
	private final int codierung; //= Seriennummer des Androiden, der mit dieser Software ausgestattet ist.
	
	public Software(int sicherheitsstufe, Androide a) {
		
		//TODO sicherheitsstufe zur enum-klasse machen.
		
		this.sicherheitsstufe = sicherheitsstufe;
		codierung = a.seriennummer();
	}
}
