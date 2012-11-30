
public abstract class Auto<T extends Strategie> implements Runnable{

	private Feld f;
	private final Fahrbahn fahrbahn;
	public enum ausrichtung {NORD, OST, SUED, WEST};
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
			Fahrbahn.adjazentesFeld a = s.naechstesFeld(aktuellesFeld(), this.akutell);
			Feld ziel = fahrbahn.adjazentesFeld(aktuellesFeld(), a);
			ziel.fuegeAutoHinzu(this);
			
			try {
				Thread.sleep(this.warteZeitInMillisekunden());
			} catch (InterruptedException e) {
				return;
			}
		}		
	}
	
	public abstract int warteZeitInMillisekunden();
	
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
