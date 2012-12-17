
public class Doppelkeks <F extends Form, T extends Teig> extends Keks<F, T> {
	
	private Einfachkeks<F,T> boden;
	private Einfachkeks<F,T> deckel;
	private Fuellung fuellung;
	
	public Doppelkeks(Einfachkeks<F,T> boden, Einfachkeks<F,T> deckel, Fuellung fuellung) {
		
		this.boden = boden;
		this.deckel = deckel;
		this.fuellung = fuellung;
	}
}