import java.util.TreeMap;

/**
 * Eine Instanz von Kit ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass es - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public abstract class Kit {
	
	private String name;
	private final int codierung; //= Seriennummer des Androiden, der mit dieser Komponente ausgestattet ist.
	
	public Kit(String name, Androide a) {
		
		this.name = name;
		codierung = a.seriennummer();
	}
	
	/**
	 * Vorbedingung: liste und b (Bediener) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonBedienerInstalliert(Bediener b, TreeMap<Integer,Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Androide mit Sicherheitsstufe 3) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonStufe3Installiert(Androide a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und a (Androide mit Sicherheitsstufe 4) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public abstract String vonStufe4Installiert(Androide a, TreeMap<Integer, Androide> liste);
	
	/**
	 * Vorbedingung: liste und k (Kaempfer) != null
	 * Nachbedingung: Entspricht der Androide der Verordnung, wird er der Liste hinzugefuegt.
	 */
	public String vonKaemperInstalliert(Kaempfer k, TreeMap<Integer, Androide> liste) {
		
		liste.put(k.seriennummer(), k);
		return "Kit ok";
	}
	
	/**
	 * Liefert String-Repraesentation des Objekts
	 */
	public String toString() {
		
		return "Name: " + name + ", Seriennummer: " + codierung;
	}
}