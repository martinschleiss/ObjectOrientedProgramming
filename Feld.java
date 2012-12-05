import java.util.ArrayList;
import java.util.HashMap;

public class Feld {

	/**
	 * @GuardedBy("this")
	 */
	private ArrayList<Auto> autos;
	private Feld n;
	private Feld no;
	private Feld o;
	private Feld so;
	private Feld s;
	private Feld sw;
	private Feld w;
	private Feld nw;
	public enum adjazentesFeld {N, NO, O, SO, S, SW, W, NW};

	//private boolean initialisiert;

	public Feld() {
		autos = new ArrayList<Auto>();
		n = null;
		no = null;
		o = null;
		so = null;
		s = null;
		sw = null;
		w = null;
		nw = null;
		//this.initialisiert = false;
	}

	public void fuegeAutoHinzu(Auto a) {

		a.aktuellesFeld().entferneAuto(a);
		a.wechsleZuFeld(this);
		
		synchronized(this) {
		
			if (!autos.contains(a)) {
				
				for(Auto i : autos) {
					
					if (a.isFrontal(i.getAusrichtung())) {
					
						i.plusPunkt();
						a.plusPunkt();
						
					} else {
						
						i.minusPunkt();
					}
				}
				autos.add(a);
			}
		}
	}

	public final void entferneAuto(Auto a) {
		synchronized(this) {
				autos.remove(a);
			}	
	}
/*
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

	}*/
	
	/*
	 *   1 2 3
	 *   4 A 5
	 *   6 7 8
	 * 
	 */	
	/*public Feld adjazentesFeld(adjazentesFeld n) {
			
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
	}*/
	
	public void setN(Feld n) {

		this.n = n;
	}
	public void setNO(Feld n) {

		this.no = n;
	}
	public void setO(Feld n) {

		this.o = n;
	}
	public void setSO(Feld n) {

		this.so = n;
	}
	public void setS(Feld n) {

		this.s = n;
	}
	public void setSW(Feld n) {

		this.sw = n;
	}
	public void setW(Feld n) {

		this.w = n;
	}
	public void setNW(Feld n) {

		this.nw = n;
	}

	public Feld getN() {

		return n;
	}
	public Feld getNO() {

		return no;
	}
	public Feld getO() {

		return o;
	}
	public Feld getSO() {

		return so;
	}
	public Feld getS() {

		return s;
	}
	public Feld getSW() {

		return sw;
	}
	public Feld getW() {

		return w;
	}
	public Feld getNW() {

		return nw;
	}
}
