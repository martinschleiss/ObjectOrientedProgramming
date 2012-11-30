import java.util.ArrayList;
import java.awt.Point;
public class Fahrbahn {
	
	private final int breite;
	private final int hoehe;
	private final ArrayList<Feld> felder;
	public enum adjazentesFeld {N, NO, O, SO, S, SW, W, NW};
	
	public Fahrbahn(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;
		felder = new ArrayList<Feld>();
		for(int i = 0; i < (breite * hoehe); i++) {
			felder.add(new Feld(this));
		}
		
	}
	
	/*
	 *   1 2 3
	 *   4 A 5
	 *   6 7 8
	 * 
	 */	
	public Feld adjazentesFeld(Feld f, adjazentesFeld n) {
		return null;
	}
	
	/**
	 * throws NichtAdjazentesFeldException
	 * @param mitte
	 * @param anderes
	 * @return
	 */
	public adjazentesFeld feldRelation(Feld mitte, Feld anderes) {
		return adjazentesFeld.N;
	}
	
	public final void autoZuFahrbahnHinzufuegen(Auto a, Point p) {
		//Auto darf nur einmal existieren
	}
	
	public final void spawnAlleAutos() {
		//Alle Autos anstarten - synchronized
	}

}
