
public class Auto<T extends Strategie> implements Runnable{

	private Feld f;
	private final Fahrbahn fahrbahn;
	private enum ausrichtung {NORD, OST, SUED, WEST};
	private ausrichtung akutell;
	private int punkte = 0;
	private final Strategie s;
	
	public Auto(Fahrbahn fahrbahn, Feld startFeld, T s) {
		this.fahrbahn = fahrbahn;
		this.f = startFeld;
		this.akutell = ausrichtung.NORD;
		this.s = s;
	}
	
	public void run() {
		
		while(true) {
			Fahrbahn.adjazentesFeld a = s.naechstesFeld(aktuellesFeld());
			Feld ziel = fahrbahn.adjazentesFeld(aktuellesFeld(), a);
			ziel.fuegeAutoHinzu(this);
		}		
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
