
public abstract class Strategie {
	
	private final Fahrbahn f;
	public enum ausrichtung {NORD, OST, SUED, WEST};
	
	public Strategie(Fahrbahn f, ausrichtung a) {
		this.f = f;
	}

	public abstract Feld naechstesFeld(Feld aktuell);
	
	public Fahrbahn fahrbahn() {
		return f;
	}
	
}
