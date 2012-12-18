import java.util.ArrayList;
import java.util.Iterator;


public class Baeckerei {

	private ArrayList<Bestellung> bestellungen;
	private Iterator<Bestellung> it;

	public Baeckerei() {

		bestellungen = new ArrayList<Bestellung>();
		it = null;
	}

	public void addBestellung(Bestellung b) {

		bestellungen.add(b);
	}

	public Keksdose nextBestellung() {

		if (it == null) {

			it = bestellungen.iterator();
		}

		if (it.hasNext()) {

			Bestellung tmp = it.next();

			Keksdose k = new Keksdose();
			Backmaschine b;

			while (tmp.hasNext()) {

				b = tmp.getCurrentBackmaschine();
				k.befuelle(b.backe(tmp.getCurrentTeig()));
				tmp.next();
			}

			return k;

		} else {

			return null;
		}
	}




	/*
	public Keksdose naechsteBestellung(){

		ArrayList<Bestellung> listen=b.getBestellListe();

		for(Bestellung liste : listen){
			Bestellung bestellung=(Bestellung)liste;

			if(bestellung.getFuellung()==null){// einfache Kekse
				Keksbackmaschine kMaschine=new KeksbackmaschineEinfach();
				keksListe.add(kMaschine.keksFactory(bestellung.getForm(), bestellung.getTeig()));
			}else{// DoppelKekse
				Keksbackmaschine kMaschine=new KeksbackmaschineDoppelt();
				keksListe.add(kMaschine.keksFactory(new Keks<Form,Teig>(bestellung.getForm(), bestellung.getTeig()),bestellung.getFuellung()));
			}
		}

		Keksdose kd=new Keksdose();
		kd.befuelle(keksListe);
		return kd;
	}
	 */
}
