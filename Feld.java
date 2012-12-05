import java.util.ArrayList;

/**
 * Klasse Feld repraesentiert Teil einer Fahrbahn, auf dem sich mehrere Autos befinden koennen.
 * Ist mit umgebenden Feldern in einer 8er Nachbarschaft verkettet. Randfelder zeigen auf null, dort wo der Rand ist
 */
public class Feld {

	private ArrayList<Auto> autos;
	private Feld n;
	private Feld no;
	private Feld o;
	private Feld so;
	private Feld s;
	private Feld sw;
	private Feld w;
	private Feld nw;

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
	}

	/**
	 * Setter-Methoden fuer alle Felder der 8er-Nachbarschaft.
	 * @param n != null
	 */
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

	/**
	 * Getter-Methoden fuer alle Felder der 8er-Nachbarschaft
	 * @return Nachbarfeld des Feldes in der jeweiligen Richtung, null wenn Rand
	 */
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

	/**
	 * Fuegt Auto dem Feld duplikatfrei hinzu und berechnet Punkte fuer Zusammenstoesse anhand der Vorgaben
	 * @param a != null
	 */
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

	/**
	 * Entfernt Auto von Feld
	 */
	public final void entferneAuto(Auto a) {
		synchronized(this) {
				autos.remove(a);
			}	
	}
}
