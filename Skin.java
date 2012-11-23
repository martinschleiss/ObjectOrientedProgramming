/**
 * Eine Instanz von Skin ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass sie - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public abstract class Skin {

	private final int codierung; //= Seriennummer des Androiden, der mit dieser Skin ausgestattet ist.

	public Skin(Androide a) {
		
		codierung = a.seriennummer();
	}
}
