import java.util.ArrayList;
import java.util.HashMap;

public class Feld {

	/**
	 * @GuardedBy("this")
	 */
	private ArrayList<Auto<? extends Strategie>> autos;
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

	public Feld() {
		autos = new ArrayList<Auto<? extends Strategie>>();
		this.initialisiert = false;
	}

	public void fuegeAutoHinzu(Auto<? extends Strategie> a) {
		//adjazentesFeld ursprung = feldRelation(a.aktuellesFeld());
		a.aktuellesFeld().entferneAuto(a);
		a.wechsleZuFeld(this);
		synchronized(this) {
			if(autos.contains(a) == false) {				
				for(Auto<? extends Strategie> i : autos) {					
					i.minusPunkt();
					a.plusPunkt();
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
			
		if(n == adjazentesFeld.N) {
			return this.n;
		} else if(n == adjazentesFeld.NO) {
			return this.no;
		} else if(n == adjazentesFeld.O) {
			return this.o;			
		} else if(n == adjazentesFeld.SO) {
			return this.so;
		} else if(n == adjazentesFeld.S) {
			return this.s;			
		} else if(n == adjazentesFeld.SW) {
			return this.sw;
		} else if(n == adjazentesFeld.W) {
			return this.w;
		} else {
			return this.nw;
		}
	}
	
	/**
	 * throws NichtAdjazentesFeldException
	 * @param mitte
	 * @param anderes
	 * @return
	 */	
/*	public adjazentesFeld feldRelation(Feld f) {
		if(f == n) {
			return adjazentesFeld.N;
		} else if(f == no) {
			return adjazentesFeld.NO;
		} else if(f == o) {
			return adjazentesFeld.O;
		} else if(f == so) {
			return adjazentesFeld.SO;
		} else if(f == s) {
			return adjazentesFeld.S;
		} else if(f == sw) {
			return adjazentesFeld.SW;
		} else if(f == w) {
			return adjazentesFeld.W;
		} else if(f == nw) {
			return adjazentesFeld.NW;
		} else {
			//TODO: throw exception
			
			
			return adjazentesFeld.N;
		}

	}*/
}
