import java.util.ArrayList;
import java.util.Iterator;

/**
 * Repraesentiert eine Baeckerei, die Bestellungen entgegennimmt und diese Eine nach der Anderen
 * einzeln abarbeitet und dabei Keksdosen liefert.
 */
public class Baeckerei {

	private ArrayList<Bestellung> bestellungen;

	public Baeckerei() {

		bestellungen = new ArrayList<Bestellung>();
	}

	/**
	 * Fuegt Bestellung zur Liste hinzu
	 * @param b != null
	 */
	public void addBestellung(Bestellung b) {

		bestellungen.add(b);
	}

	/**
	 * Liefert Keksdose der naechsten Bestellung in der Liste
	 * @return Keksdose mit Keksen laut Bestellung, leere Keksdose bei leerer Bestellung
	 */
	public Keksdose nextBestellung() {

		Iterator<Bestellung> it = bestellungen.iterator();
		
		Keksdose k = new Keksdose();
		Bestellung tmp;
		Backmaschine b;
		Position p;
		
		if (it.hasNext()) {
			
			tmp = it.next();
			
			while (tmp.hasNext()) {
				
				p = tmp.next();
				b = p.getBackmaschine();
				k.befuelle(b.backe(p));
			}
			
			it.remove();
		}
		
		return k;
		
		/*
		for(int i = 0; i < bestellungen.size(); i++) {

			Bestellung tmp = bestellungen.get(i);

			k = new Keksdose();
			Backmaschine b;
			Position p;

			while (tmp.hasNext()) {
				
				p = tmp.next();
				b = p.getBackmaschine();
				k.befuelle(b.backe(p));
			}
			
			bestellungen.remove(tmp);
		}
		return k;
		*/
	}
}
