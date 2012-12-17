
public class BackmaschineDoppelt {

	public Doppelkeks backe(Keks boden, Fuellung fuelle) {
		
		Keks deckel = boden.clone();
		
		return new Doppelkeks(boden, deckel, fuelle);
	}
}
