/**
 * Autodrom-Auto: Kann nach rechts und links lenken und ist langsamer als das schnelle Auto
 */
public class AutoBeweglich extends Auto {

	private int wartezeit; // > 0
	
	public AutoBeweglich(Fahrbahn f, Feld startfeld, ausrichtung a, Strategie s, int wartezeit) {

		super(f, startfeld, a, s);
		this.wartezeit = wartezeit;
	}

	/**
	 * Liefert fixe Dauer, die der Thread wartet.
	 * @return wartezeit > 0
	 */
	public final int wartezeit() {

		return wartezeit;
	}

	/**
	 * Liefert Feld, dass beim Linksfahren der jeweiligen Ausrichtung als naechstes kommen wuerde
	 * @return tmp - naechtes Feld, ist null wenn an den Rand gefahren
	 */
	public Feld lenkeLinks() {

		Feld tmp = null;
		
		if (getAusrichtung().equals(ausrichtung.N)) {

			tmp = aktuellesFeld().getW();
			setAusrichtung(ausrichtung.W);
			
		} else if (getAusrichtung().equals(ausrichtung.O)){

			tmp = aktuellesFeld().getN();
			setAusrichtung(ausrichtung.N);
			
		} else if (getAusrichtung().equals(ausrichtung.S)){

			tmp = aktuellesFeld().getO();
			setAusrichtung(ausrichtung.O);
			
		} else if (getAusrichtung().equals(ausrichtung.W)){
			
			tmp = aktuellesFeld().getS();
			setAusrichtung(ausrichtung.S);
		}
		
		return tmp;
	}

	/**
	 * Liefert Feld, dass beim Rechtsfahren der jeweiligen Ausrichtung als naechstes kommen wuerde
	 * @return tmp - naechtes Feld, ist null wenn an den Rand gefahren
	 */
	public Feld lenkeRechts() {

		Feld tmp = null;
		
		if (getAusrichtung().equals(ausrichtung.N)) {

			tmp = aktuellesFeld().getO();
			setAusrichtung(ausrichtung.O);
			
		} else if (getAusrichtung().equals(ausrichtung.O)){

			tmp = aktuellesFeld().getS();
			setAusrichtung(ausrichtung.S);
			
		} else if (getAusrichtung().equals(ausrichtung.S)){

			tmp = aktuellesFeld().getW();
			setAusrichtung(ausrichtung.W);
			
		} else if (getAusrichtung().equals(ausrichtung.W)){
			
			tmp = aktuellesFeld().getN();
			setAusrichtung(ausrichtung.N);
		}
		
			return tmp;
	}
}