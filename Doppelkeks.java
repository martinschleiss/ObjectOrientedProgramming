/**
 * Repraesentiert Doppelkeks
 */
public class Doppelkeks implements Keks {
	
	private Keks boden;
	private Keks deckel; //deckel.form == boden.form && deckel.teig == boden.teig
	private Fuellung fuellung;
	
	/**
	 * Konstruktor
	 * @param boden		!= null
	 * @param deckel	!= null
	 * @param fuellung	!= null
	 */
	public Doppelkeks(Keks boden, Keks deckel, Fuellung fuellung) {
		
		this.boden = boden;
		this.deckel = deckel;
		this.fuellung = fuellung;
	}
	
	/**
	 * Klont Keks, auch Referenzen werden geklont
	 * @return aequvivalentes Keks zu this
	 */
	public Keks clone() {
		
		return new Doppelkeks(boden.clone(), deckel.clone(), fuellung.clone());
	}
	
	/**
	 * liefert String-Repraesentation des Keks
	 */
	public String toString() {
		
		return "Doppelkeks aus 2mal: \"" + boden + "\" mit " + fuellung;
	}
}