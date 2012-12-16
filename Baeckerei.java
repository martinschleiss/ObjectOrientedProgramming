import java.util.ArrayList;


public class Baeckerei {
	
	private ArrayList<Keks<? extends Form, ? extends Teig>> keksListe;

	public Baeckerei() {

		keksListe = new ArrayList<Keks<? extends Form, ? extends Teig>>();
	}
	/**
	 * 
	 * @param b Bestellung darf nicht null sein
	 * @return Keksdose mit den Keksen von der Bestellung
	 */
	
	public Keksdose setBestellung(Bestellung b){
		
		Iterator liste=b.iterator();
		
		while(liste.hasNext()){
			Bestellung bestellung=(Bestellung)liste.next();
			
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
}
