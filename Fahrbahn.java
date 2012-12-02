import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Point;

public class Fahrbahn {

	private int breite;
	private int hoehe;
	private final ArrayList<Feld> felder;

	public Fahrbahn(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;
		felder = new ArrayList<Feld>();
		for(int i = 0; i < (breite * hoehe); i++) {
			felder.add(new Feld());
		}
		int x = 0;
		int y = 0;
		for(int i = 0; i < felder.size(); i++) {
			x = i % breite;
			y = i / hoehe;

			HashMap<Feld.adjazentesFeld, Feld> nachbarn = new HashMap<Feld.adjazentesFeld, Feld>();
		
			//N
			if(y - 1 >= 0) {
				nachbarn.put(Feld.adjazentesFeld.N, felder.get(x + ((y - 1) * breite)));
				
			}
			//NO
			if(y-1 >=0 && x < breite-1){
				nachbarn.put(Feld.adjazentesFeld.NO, felder.get(x+1 + ((y - 1) * breite)));
				
			}

			//O
			if(x + 1 < breite) {
				nachbarn.put(Feld.adjazentesFeld.O, felder.get(x + 1 + (y * breite)));
				
			}			
			//SO

			if(x<breite-1&&y<hoehe-1){
				nachbarn.put(Feld.adjazentesFeld.SO, felder.get(x+1 + ((y + 1) * breite)));
				
			}
			//S
			if(y + 1 < hoehe) {
				nachbarn.put(Feld.adjazentesFeld.S, felder.get(x + ((y + 1) * breite)));
				
			}			
			//SW
			if(x-1 >= 0 && y < hoehe-1){
				nachbarn.put(Feld.adjazentesFeld.SW, felder.get(x-1 + ((y + 1) * breite)));
			}

			//W
			if(x - 1 >= 0) {
				nachbarn.put(Feld.adjazentesFeld.W, felder.get(x - 1 + ((y) * breite)));
				
			}
			//NW
			if(y-1 >= 0 && x-1 >= 0){
				nachbarn.put(Feld.adjazentesFeld.NW, felder.get(x-1 + ((y - 1) * breite)));
				
			}
			felder.get(i).setzeNachbarn(nachbarn);
		}
	}

	public final Feld feldAnPosition(Point p) {
		return felder.get(p.x + (breite * p.y));
	}	

	public final void autoZuFahrbahnHinzufuegen(Auto<? extends Strategie> a, Point p) {
		//Auto darf nur einmal existieren

		for(Feld f : felder) {
			f.entferneAuto(a);
		}

		Feld ziel = felder.get(p.x + (breite * p.y));
		ziel.fuegeAutoHinzu(a);
	}

	public final void spawnAlleAutos() {
		//Alle Autos anstarten - synchronized

	}

}
