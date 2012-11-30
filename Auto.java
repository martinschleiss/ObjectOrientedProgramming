
public class Auto implements Runnable{

	private Feld f;
	private final Fahrbahn fahrbahn;
	private enum ausrichtung {NORD, OST, SUED, WEST};
	
	public Auto(Fahrbahn fahrbahn, Feld startFeld) {
		this.fahrbahn = fahrbahn;
		this.f = startFeld;
	}
	
	public void run() {
		
	}
	
	public void wechsleZuFeld(Feld ziel) {
		
	}
	
	public Feld aktuellesFeld() {
		return f;
	}
	
	public void angestoszenVonAdjazentemFeld(Fahrbahn.adjazentesFeld n) {
		
	}
	
	public void plusPunkt() {
	
	}
	
	public void minusPunkt() {
		
	}
}
