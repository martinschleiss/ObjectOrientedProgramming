
public class BackmaschineDoppelt {

	/**
	 * 
	 * @param boden die Keksart aus dem der Doppelkeks hergestellt werden soll
	 * @param fuelle die Fuellung des Doppelkeks
	 * @return Doppelkeks mit Deckel=Boden und entsprechender Fuellung
	 */
	public Doppelkeks backe(Keks boden, Fuellung fuelle) {
		
		Keks deckel = boden.clone();
		
		return new Doppelkeks(boden, deckel, fuelle);
	}
}
