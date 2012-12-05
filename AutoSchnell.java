public class AutoSchnell extends Auto {

	public AutoSchnell(Fahrbahn f, Feld startfeld, ausrichtung a, Strategie s) {

		super(f, startfeld, a, s);
	}

	public final int wartezeit() {

		return 50;
	}

	public Feld lenkeLinks() {
		
		return null;
	}

	public Feld lenkeRechts() {
		
		return null;
	}
}