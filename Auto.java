
public abstract class Auto implements Runnable{

	public static enum ausrichtung {N, O, S, W};
	private static int serialNumber = 1;
	private final Fahrbahn fahrbahn;
	private Feld f;
	private ausrichtung a;
	private final Strategie s;
	private final int number;
	
	/**
	 * @GuardedBy("this")
	 */
	private int punkte = 0;

	/**
	 * @GuardedBy("this")
	 */
	private int schritte;


	public Auto(Fahrbahn f, Feld startfeld, ausrichtung a, Strategie s) {
		
		this.fahrbahn = f;
		this.f = startfeld;
		this.a = a;
		this.s = s;
		this.schritte = 0;
		number = serialNumber++;
	}
	
	public int getPunkte(){
		return punkte;
	}
	
	public int getSchritte(){
		return schritte;
	}

	public void run() {

		while(true) {
			try {
				
				Feld ziel = s.naechstesManoever(this);
				ziel.fuegeAutoHinzu(this);

				if(schritte >= 50) {
					fahrbahn.stoppeSpiel();
				}

				Thread.sleep(this.wartezeit());
				
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
				return;
			}

			schritte++;
		}		
	}

	public abstract int wartezeit();

	public final void wechsleZuFeld(Feld ziel) {
		f = ziel;
	}

	public final Feld aktuellesFeld() {
		return f;
	}

	protected void setFeld(Feld f) {
		
		this.f = f;
	}
	
	public ausrichtung getAusrichtung() {
		
		return a;
	}

	protected void setAusrichtung(ausrichtung a) {
		
		this.a = a;
	}
	
	public Feld geradeaus() {
		
		Feld tmp = null;
		
		if (a.equals(ausrichtung.N)) {

			tmp = f.getN();
			
		} else if (a.equals(ausrichtung.O)){

			tmp = f.getO();
			
		} else if (a.equals(ausrichtung.S)){

			tmp = f.getS();
			
		} else if (a.equals(ausrichtung.W)){
			
			tmp = f.getW();
		}
		
		return tmp;
	}
	
	public Feld lenkeHalblinks() {

		Feld tmp = null;
		
		if (a.equals(ausrichtung.N)) {

			tmp = f.getNW();
			a = ausrichtung.W;
			
		} else if (a.equals(ausrichtung.O)){

			tmp = f.getNO();
			a = ausrichtung.N;
			
		} else if (a.equals(ausrichtung.S)){

			tmp = f.getSO();
			a = ausrichtung.O;
			
		} else if (a.equals(ausrichtung.W)){
			
			tmp = f.getSW();
			a = ausrichtung.S;
		}
		
		return tmp;
	}

	public Feld lenkeHalbrechts() {

		Feld tmp = null;
		
		if (a.equals(ausrichtung.N)) {

			tmp = f.getNO();
			a = ausrichtung.O;
			
		} else if (a.equals(ausrichtung.O)){

			tmp = f.getSO();
			a = ausrichtung.S;
			
		} else if (a.equals(ausrichtung.S)){

			tmp = f.getSW();
			a = ausrichtung.W;
			
		} else if (a.equals(ausrichtung.W)){
			
			tmp = f.getNW();
			a = ausrichtung.N;
		}
		
		return tmp;
	}
	
	public abstract Feld lenkeLinks();
	public abstract Feld lenkeRechts();
	
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

	public final void minusPunkt() {
		synchronized(this) {
			--punkte;
		}
	}
	public boolean isFrontal(ausrichtung o) {
		
		if (this.a == ausrichtung.N && o == ausrichtung.S) {
			
			return true;
			
		} else if (this.a == ausrichtung.O && o == ausrichtung.W) {
			
			return true;
			
		} else if (this.a == ausrichtung.S && o == ausrichtung.N) {
			
			return true;
		}else if (this.a == ausrichtung.W && o == ausrichtung.O) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
}
