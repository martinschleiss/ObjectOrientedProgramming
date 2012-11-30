
public abstract class Strategie {
	
	private final Fahrbahn f;
	
	public Strategie(Fahrbahn f) {
		this.f = f;
	}

	public abstract Fahrbahn.adjazentesFeld naechstesFeld(Feld aktuell, Auto.ausrichtung a);
	
}
