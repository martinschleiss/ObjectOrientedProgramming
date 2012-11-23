/**
 * Eine Instanz von Komponente ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass sie - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public abstract class Komponente {
	
	private String name;
	private final int codierung; //= Seriennummer des Androiden, der mit dieser Komponente ausgestattet ist.
	
	public Komponente(String name, Androide a) {
		
		this.name = name;
		codierung = a.getSeriennummer();
	}
		
	public String toString() {
		
		return name;
	}
}
