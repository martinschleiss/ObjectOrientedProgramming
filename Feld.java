import java.util.ArrayList;
public class Feld {
	
	/**
	 * @GuardedBy("this")
	 */
	private ArrayList<Auto<? extends Strategie>> autos;
	private final Fahrbahn f;
	
	public Feld(Fahrbahn f) {
		autos = new ArrayList<Auto<? extends Strategie>>();
		this.f = f;
	}

	public void fuegeAutoHinzu(Auto<? extends Strategie> a) {
		Fahrbahn.adjazentesFeld adj = f.feldRelation(this, a.aktuellesFeld());
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
	
	private final void entferneAuto(Auto<? extends Strategie> a) {
		synchronized(this) {
			if(autos.contains(a) == true) {
				autos.remove(a);
			}
		}		
	}
}
