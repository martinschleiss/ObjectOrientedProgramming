import java.util.ArrayList;


public class Baeckerei {

	private ArrayList<Bestellung> bestellungen;
	//private Iterator<Bestellung> it;

	public Baeckerei() {

		bestellungen = new ArrayList<Bestellung>();
		//it = null;
	}

	/**
	 * 
	 * @param b neue bestellung die zur Liste hinzugefuegt werden soll
	 */
	public void addBestellung(Bestellung b) {

		bestellungen.add(b);
	}

	/**
	 * 
	 * @return liefert die naechste bestelllung aus der Liste
	 */
	public Keksdose nextBestellung() {

		/*if (it == null) {

			it = bestellungen.iterator();
		}*/
		
		Keksdose k=null;
		
		for(int i=0; i<bestellungen.size();i++){
			Bestellung tmp = bestellungen.get(i);

			k = new Keksdose();
			Backmaschine b;

			while (tmp.next()) {
				b = tmp.getCurrentBackmaschine();
				k.befuelle(b.backe(tmp.getCurrentPosition()));
			}
			bestellungen.remove(tmp);
		}
		return k;
		/*
		if (it.hasNext()) {
		
			
			Bestellung tmp = it.next();
			Keksdose k = new Keksdose();

			while (tmp.next()) {

				Backmaschine b = tmp.getCurrentPosition().getBackmaschine();
				k.befuelle(b.backe(tmp.getCurrentPosition()));
			}

			return k;

		} else {

			return null;
		}*/
		
	}
}
