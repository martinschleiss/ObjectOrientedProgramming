
public class Doppelkeks implements Keks {
	
	private Keks boden;
	private Keks deckel;
	private Fuellung fuellung;
	
	public Doppelkeks(Keks boden, Keks deckel, Fuellung fuellung) {
		
		this.boden = boden;
		this.deckel = deckel;
		this.fuellung = fuellung;
	}
	
	public Keks clone() {
		
		return null;
	}
}