import java.util.ArrayList;
import java.awt.Point;

/**
 * Repraesentiert Fahrbahn aus einem rechteckigen Feld aus Feldern.
 * Von hier aus koennen Autos gespawnt, das Spiel begonnen und gestoppt werden und Ergebnisse ausgegeben werden.
 */

public class Fahrbahn {

	private int breite; // > 0
	//private int hoehe; // > 0
	private final ArrayList<Feld> felder;
	private ArrayList<Auto> autos;
	private final ThreadGroup group;
	private boolean running = false;

	public Fahrbahn(int breite, int hoehe) {
		this.breite = breite;
		//this.hoehe = hoehe;
		group = new ThreadGroup("Auto");
		autos = new ArrayList<Auto>();
		felder = new ArrayList<Feld>();
		for(int i = 0; i < (breite * hoehe); i++) {
			felder.add(new Feld());
		}

		int x = 0;
		int y = 0;
		Feld tmp = null;

		for(int i = 0; i < felder.size(); i++) {

			x = i % breite;
			y = i / hoehe;
			tmp = felder.get(i);

			//N
			if(y - 1 >= 0) {
				tmp.setN(felder.get(x + ((y - 1) * breite)));	
			}

			//NO
			if(y - 1 >=0 && x < breite - 1){
				tmp.setNO(felder.get(x + 1 + ((y - 1) * breite)));
			}

			//O
			if(x + 1 < breite) {
				tmp.setO(felder.get(x + 1 + (y * breite)));
			}

			//SO
			if(x < breite - 1 && y < hoehe - 1){
				tmp.setSO(felder.get(x+1 + ((y + 1) * breite)));
			}

			//S
			if(y + 1 < hoehe) {
				tmp.setS(felder.get(x + ((y + 1) * breite)));
			}

			//SW
			if(x-1 >= 0 && y < hoehe-1){
				tmp.setSW(felder.get(x-1 + ((y + 1) * breite)));
			}

			//W
			if(x - 1 >= 0) {
				tmp.setW(felder.get(x - 1 + ((y) * breite)));

			}

			//NW
			if(y-1 >= 0 && x-1 >= 0){
				tmp.setNW(felder.get(x-1 + ((y - 1) * breite)));
			}
		}
	}

	/**
	 * Liefert korrespondierendes Feld der Fahrbahn anhand der Koordinaten des Punktes
	 * @param p != null
	 * @return feld, wenn Point innerhalb der Fahrbahn, null sonst
	 */
	public final Feld feldAnPosition(Point p) {
		
		if (p.x + (breite * p.y) < felder.size()) {
		
			return felder.get(p.x + (breite * p.y));
		} else {
			
			return null;
		}
	}	

	/**
	 * Fuegt Auto der Fahrbahn duplikatfrei hinzu
	 * @param a != null, a nicht schon auf einem Feld der Fahrbahn sein
	 */
	public final void autoZuFahrbahnHinzufuegen(Auto a) {

		autos.remove(a);
		autos.add(a);

		Feld ziel = a.aktuellesFeld();
		ziel.fuegeAutoHinzu(a);
	}

	/**
	 * Startet den Betrieb des Autodroms und damit alle Autos
	 */
	public final void spawnAlleAutos() {

		for(Auto a: autos) {

			Thread t = new Thread(group, a);
			t.start();
		}
	}

	/**
	 * Stoppt Betrieb des Autodroms und damit alle Autos
	 * @throws InterruptedException
	 */
	public final void stoppeSpiel() throws InterruptedException {

		synchronized(this) {
			if(running == false) {
				group.interrupt();
				running = true;
					notifyAll();
			} else {
			
				throw new InterruptedException();
			}
		}
	}

	/**
	 * Liefert Ergebnisse der Fahrt
	 */
	public String ergebnisse() {
		String output = "";
		synchronized(this) {
			while(!running) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		for(Auto a: autos) {
			output += "Auto "+ a.uniqueNumber()+": Schritte: "+ a.getSchritte() +" Punkte: " + a.getPunkte();
			output += "\n";
		}
		return output;
	}
}
