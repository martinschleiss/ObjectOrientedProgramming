import java.util.TreeMap;

/**
 * Eine Instanz von Kit ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass es - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public abstract class Kit {
	
	private String name;
	
	/**
	 * = Seriennummer des Androiden, der mit dieser Komponente ausgestattet ist.
	 */
	private final int codierung;
	
	public Kit(String name, Androide a) {
		
		this.name = name;
		codierung = a.seriennummer();
	}
	
	public abstract String vonBedienerInstalliert(Bediener b, TreeMap<Integer,Androide> liste);
			
	public abstract String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste);
	
	public abstract String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste);
	
	
	public String vonKaemperInstalliert(Kaempfer k, TreeMap<Integer, Androide> liste) {
		
		liste.put(k.seriennummer(), k);
		return "Kit ok";
	}
	
	public String toString() {
		
		return "Name: " + name + ", Seriennummer: " + codierung;
	}
}