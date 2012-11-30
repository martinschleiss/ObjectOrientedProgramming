import java.util.ArrayList;
import java.util.HashMap;

public class Feld {

	/**
	 * @GuardedBy("this")
	 */
	private ArrayList<Auto<? extends Strategie>> autos;
	private final Fahrbahn f;
	private Feld n;
	private Feld no;
	private Feld o;
	private Feld so;
	private Feld s;
	private Feld sw;
	private Feld w;
	private Feld nw;
	public enum adjazentesFeld {N, NO, O, SO, S, SW, W, NW};

	private boolean initialisiert;

	public Feld(Fahrbahn f) {
		autos = new ArrayList<Auto<? extends Strategie>>();
		this.f = f;
		this.initialisiert = false;
	}

	public void fuegeAutoHinzu(Auto<? extends Strategie> a) {
		adjazentesFeld adj = f.feldRelation(this, a.aktuellesFeld());
		a.aktuellesFeld().entferneAuto(a);
		a.wechsleZuFeld(this);
		synchronized(this) {
			if(autos.contains(a) == false) {				
				for(Auto<? extends Strategie> i : autos) {					
					i.angestoszenVonAdjazentemFeld(adj);										
				}
				autos.add(a);
			}
		}
	}

	public final void entferneAuto(Auto<? extends Strategie> a) {
		synchronized(this) {
			if(autos.contains(a) == true) {
				autos.remove(a);
			}
		}		
	}

	public final void setzeNachbarn(HashMap<adjazentesFeld, Feld> nachbarn) {

		if(initialisiert == false) {
			initialisiert = true;
			n = nachbarn.get(adjazentesFeld.N);
			no = nachbarn.get(adjazentesFeld.NO);
			o = nachbarn.get(adjazentesFeld.O);
			so = nachbarn.get(adjazentesFeld.SO);
			s = nachbarn.get(adjazentesFeld.S);
			sw = nachbarn.get(adjazentesFeld.SW);
			w = nachbarn.get(adjazentesFeld.W);
			nw = nachbarn.get(adjazentesFeld.NW);
		}

	}
	
	/*
	 *   1 2 3
	 *   4 A 5
	 *   6 7 8
	 * 
	 */	
	public Feld adjazentesFeld(adjazentesFeld n) {
		
		Feld ziel = null;
		
		
		if(n == adjazentesFeld.N) {
			ziel = this.n;
		} else if(n == adjazentesFeld.NO) {
			assert(false);
		} else if(n == adjazentesFeld.O) {
			ziel = this.o;			
		} else if(n == adjazentesFeld.SO) {
			assert(false);
		} else if(n == adjazentesFeld.S) {
			ziel = this.s;			
		} else if(n == adjazentesFeld.SW) {
			assert(false);
		} else if(n == adjazentesFeld.W) {
			ziel = this.w;
		} else {
			assert(false);
		}
		
		return ziel;
	}
}
