
public abstract class Auto<T extends Strategie> implements Runnable{

	private Feld f;
	/**
	 * @GuardedBy("this")
	 */
	private int punkte = 0;
	private final Strategie s;
	private static int serialNumber = 1;
	private final int number;

	/**
	 * GuardedBy("this")
	 */
	private int schritte;
	private final Fahrbahn fahrbahn;

	public Auto(Feld startFeld, T s, Fahrbahn fahrbahn) {
		this.f = startFeld;
		this.s = s;
		this.schritte = 0;
		this.fahrbahn = fahrbahn;
		number = serialNumber++;
	}

	public void run() {

		while(true) {
			try {
				Feld ziel = s.naechstesFeld(aktuellesFeld());
				ziel.fuegeAutoHinzu(this);

				if(schritte >= 50) {
					fahrbahn.stoppeSpiel();
					System.out.println(schritte);
					return;
				}

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

	public String getaetigteSchritte() {
		synchronized(this) {
			return number + ": " + schritte;
		}
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
