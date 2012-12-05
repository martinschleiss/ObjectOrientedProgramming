public class AutoBeweglich extends Auto {

	public AutoBeweglich(Fahrbahn f, Feld startfeld, ausrichtung a, Strategie s) {

		super(f, startfeld, a, s);
	}

	public final int wartezeit() {

		return 100;
	}

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