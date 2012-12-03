
public abstract class Auto<T extends Strategie> implements Runnable{

	private Feld f;
	/**
	 * @GuardedBy("this")
	 */
	private int punkte = 0;
	private final Strategie s;
	private int schritte;
	
	public Auto(Feld startFeld, T s) {
		this.f = startFeld;
		this.s = s;
		this.schritte = 0;
	}
	
	public void run() {
		
		while(true) {
			
			Feld ziel = s.naechstesFeld(aktuellesFeld());
			ziel.fuegeAutoHinzu(this);
			
			if(schritte >= 100) {
				System.out.println(schritte);
				return;
			}
			
			try {
				Thread.sleep(this.warteZeitInMillisekunden());
			} catch (InterruptedException e) {
				return;
			}
			
			schritte++;
		}		
	}
	
	public abstract int warteZeitInMillisekunden();
	
	public final void wechsleZuFeld(Feld ziel) {
		f = ziel;
	}
	
	public final Feld aktuellesFeld() {
		return f;
	}
	
	public void angestoszenVonAdjazentemFeld(Feld.adjazentesFeld n) {
		
	}
	
	public final void plusPunkt() {
		synchronized(this) { 
			++punkte;
		}
	}
	
	private final void minusPunkt() {
		synchronized(this) {
			--punkte;
		}
	}
}
