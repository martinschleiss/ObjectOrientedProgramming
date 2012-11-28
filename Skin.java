import java.util.TreeMap;

/**
 * Eine Instanz von Skin ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass sie - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 * Visitormethoden werden von Software aufgerufen und verweisen bei Erfolg direkt auf die Visitormethoden in Kit
 */
public abstract class Skin {

	private final int codierung; //= Seriennummer des Androiden, der mit dieser Skin ausgestattet ist.

	public Skin(Androide a) {
		
		codierung = a.seriennummer();
	}
	
	public abstract String vonBedienerInstalliert(Bediener a, TreeMap<Integer,Androide> liste);
	
	public abstract String vonSchwerarbeiterInstalliert(Schwerarbeiter g, TreeMap<Integer,Androide> liste);
	
	public abstract String vonObjektbewacherInstalliert(Objektbewacher a, TreeMap<Integer,Androide> liste);
	
	public abstract String vonLeibwaechterInstalliert(Leibwaechter a, TreeMap<Integer,Androide> liste);
	
	public abstract String vonKaempferInstalliert(Kaempfer a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Codierung: " + codierung;
	}
}