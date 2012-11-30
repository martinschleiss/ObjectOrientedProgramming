
public class Auto implements Runnable{

	private Feld f;
	private final Fahrbahn fahrbahn;
	private enum ausrichtung {NORD, OST, SUED, WEST};
	private ausrichtung akutell;
	private int punkte = 0;
	
	public Auto(Fahrbahn fahrbahn, Feld startFeld) {
		this.fahrbahn = fahrbahn;
		this.f = startFeld;
		this.akutell = ausrichtung.NORD;
	}
	
	public void run() {
		
	}
	
	public final void wechsleZuFeld(Feld ziel) {
		f = ziel;
	}
	
	public final Feld aktuellesFeld() {
		return f;
	}
	
	public void angestoszenVonAdjazentemFeld(Fahrbahn.adjazentesFeld n) {
		
	}
	
	public final void plusPunkt() {
		++punkte;
	}
	
	private final void minusPunkt() {
		--punkte;
	}
}
