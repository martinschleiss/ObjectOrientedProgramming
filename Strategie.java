
public abstract class Strategie {
	
	public enum ausrichtung {NORD, OST, SUED, WEST};
	
	public Strategie() {
	}

	public abstract Feld naechstesFeld(Feld aktuell);	
}
