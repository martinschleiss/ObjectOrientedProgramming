/**
 * Baisklasse repraesentiert Autodrom-Auto
 */
public abstract class Auto implements Runnable{

	public static enum ausrichtung {N, O, S, W};
	private static int serialNumber = 1;
	private final Fahrbahn fahrbahn;
	private Feld f;
	private ausrichtung a;
	private final Strategie s;
	private final int number;
	private int punkte; // >= 0
	private int schritte; // >= 0


	public Auto(Fahrbahn f, Feld startfeld, ausrichtung a, Strategie s) {
		
		this.fahrbahn = f;
		this.f = startfeld;
		this.a = a;
		this.s = s;
		this.schritte = 0;
		this.punkte = 0;
		number = serialNumber++;
	}

	/**
	 * versucht ein Manoever durchzufuehren und stoppt alle anderen Autos, wenn dieses Auto 10 Punkte erreicht,
	 * oder sich 50 Schritte bewegt hat 
	 */
	public void run() {

		while(true) {
			
			try {
				
				Feld ziel = s.naechstesManoever(this);
				ziel.fuegeAutoHinzu(this);

				if(punkte >= 10 || schritte >= 100) {
					
					fahrbahn.stoppeSpiel();
				}
				
				Thread.sleep(this.wartezeit());
				
			} catch (InterruptedException e) {
				//Thread.currentThread().interrupt();
				//System.out.println(e.getMessage());
				return; //stand so im Skritpum
			}
			schritte++;
		}		
	}
	
	/**
	 * Die Zeit, die Autos warten sollen unterscheidet sich je nach Geschwindigkeit
	 * @return wartezeit > 0 in Millisekunden
	 */
	public abstract int wartezeit();

	/**
	 * Setter-Methode fuer Feld
	 * @param ziel != null
	 */
	public final void wechsleZuFeld(Feld ziel) {
		f = ziel;
	}

	/**
	 * Getter-Methode fuer Feld
	 */
	public final Feld aktuellesFeld() {
		return f;
	}

	protected void setFeld(Feld f) {
		
		this.f = f;
	}
	
	/**
	 * Getter-Methode fuer Ausrichtung
	 */
	public ausrichtung getAusrichtung() {
		
		return a;
	}

	/**
	 * Setter-Methode fuer Ausrichtung
	 * @param a != null
	 */
	public void setAusrichtung(ausrichtung a) {
		
		this.a = a;
	}
	
	/**
	 * Liefert Feld, dass beim Geradeausfahren der jeweiligen Ausrichtung als naechstes kommen wuerde
	 * @return tmp - naechtes Feld, ist null wenn an den Rand gefahren
	 */
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
	
	/**
	 * Liefert Feld, dass beim Halblinksfahren der jeweiligen Ausrichtung als naechstes kommen wuerde
	 * @return tmp - naechtes Feld, ist null wenn an den Rand gefahren
	 */
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

	/**
	 * Liefert Feld, dass beim Halbrechtsfahren der jeweiligen Ausrichtung als naechstes kommen wuerde
	 * @return tmp - naechtes Feld, ist null wenn an den Rand gefahren
	 */
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
	
	/**
	 * Liefert Feld, dass beim Linksfahren der jeweiligen Ausrichtung als naechstes kommen wuerde
	 * @return tmp - naechtes Feld, ist null wenn an den Rand gefahren
	 */
	public abstract Feld lenkeLinks();
	
	/**
	 * Liefert Feld, dass beim Rechtsfahren der jeweiligen Ausrichtung als naechstes kommen wuerde
	 * @return tmp - naechtes Feld, ist null wenn an den Rand gefahren
	 */
	public abstract Feld lenkeRechts();

	/**
	 * Liefert "Seriennummer" des Autos
	 * @return number > 0
	 */
	public int uniqueNumber() {
		
		return number;
	}	

	/**
	 * Liefert aktuellen Punktestand
	 */
	public int getPunkte(){
		
		synchronized(this) {
		
			return punkte;
		}
	}
	
	/**
	 * Liefert aktuelle Schrittanzahl
	 */
	public int getSchritte(){
		
		synchronized(this) {
		
			return schritte;
		}
	}

	/**
	 * Addiert einen Punkt zum aktuellen Punktestand
	 */
	public final void plusPunkt() {
		
		synchronized(this) { 
		
			++punkte;
		}
	}

	/**
	 * Subtrahiert einen Punkt zum aktuellen Punktestand
	 */
	public final void minusPunkt() {
		
		synchronized(this) {
		
			--punkte;
		}
	}
	
	/**
	 * Dient zum berechnen, ob zwei Ausrichtungen frontal gegeneinander laufen
	 * @param o		!= null, Ausrichtung des anderen Autos
	 * @return		true, wenn Ausrichtungen entgegengesetzt, sonst false
	 */
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
