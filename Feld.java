import java.util.ArrayList;
public class Feld {
	
	private ArrayList<Auto> autos;
	private final Fahrbahn f;
	
	public Feld(Fahrbahn f) {
		autos = new ArrayList<Auto>();
		this.f = f;
	}

	public void fuegeAutoHinzu(Auto a) {
		synchronized(this) {
			if(autos.contains(a) == false) {
				for(Auto i : autos) {
					Fahrbahn.adjazentesFeld adj = f.feldRelation(this, a.aktuellesFeld());
					i.angestoszenVonAdjazentemFeld(adj);
					a.aktuellesFeld().entferneAuto(a);
					a.wechsleZuFeld(this);
					autos.add(a);					
				}
				autos.add(a);
			}
		}
	}
	
	public void entferneAuto(Auto a) {
		synchronized(this) {
			if(autos.contains(a) == true) {
				autos.remove(a);
			}
		}		
	}
}
