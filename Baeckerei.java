import java.util.ArrayList;


public class Baeckerei {
	
	private ArrayList<Bestellung> bestellungen;

	public Baeckerei() {

		bestellungen = new ArrayList<Bestellung>();
	}

	public void addBestellung(Bestellung b) {
		
		bestellungen.add(b);
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
