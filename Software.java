/**
 * Eine Instanz dieser Software ist Bestandteil genau eines Androiden.
 */
public abstract class Software {
	
	private int sicherheitsstufe; // 1 <= sicherheitsstufe <= 5
	private final int codierung; //= Seriennummer des Androiden, der mit dieser Software ausgestattet ist.
	
	public Software(int sicherheitsstufe, Androide a) {
		
		assert (1 <= sicherheitsstufe && sicherheitsstufe <= 5) : "Ungueltige Sicherheitsstufe";
		
		this.sicherheitsstufe = sicherheitsstufe;
		codierung = a.getSeriennummer();
	}
}
