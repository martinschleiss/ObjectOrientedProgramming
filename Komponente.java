/**
 * Eine Instanz von Komponente ist Bestandteil genau eines Androiden. Zur Vereinfachung wird angenommen
 * dass sie - einmal hergestellt - nicht in einen anderen Androiden eingebaut werden kann.
 */
public abstract class Komponente {
	
	private String name;
	
	/**
	 * Seriennummer des Androiden, der mit dieser Komponente ausgestattet ist.
	 */
	private final int codierung;

	/**
	 * in kW, wird nicht als Verbrauch interpretiert (daher bei Sensor: 0)
	 */
	private int leistung;
	
	public Komponente(String name, int leistung, Androide a) {
		
		this.name = name;
		this.leistung = leistung;
		codierung = a.seriennummer();
	}
		
	public int leistung() {
		
		return leistung;
	}
	
	public String toString() {
		
		return name;
	}
}