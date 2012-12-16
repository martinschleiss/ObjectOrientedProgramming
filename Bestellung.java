import java.util.ArrayList;


public class Bestellung {

	private int anzahl;
	private Form form;
	private Teig teig;
	private Fuellung fuelle;
	private ArrayList<Bestellung> listeBestellungen;

	public Bestellung(){
		listeBestellungen=new ArrayList<Bestellung>();
	}
	// Konstruktor wenn einfache Kekse gefordert sind
	public Bestellung(int anzahl, Form form, Teig teig){
		this.anzahl=anzahl;
		this.form=form;
		this.teig=teig;
		this.fuelle=null;
	}
	// Konstruktor wenn doppelte Kekse gefordert sind
	public Bestellung(int anzahl, Form form, Teig teig, Fuellung fuelle){
		this.anzahl=anzahl;
		this.form=form;
		this.teig=teig;
		this.fuelle=fuelle;
	}
	public ArrayList<Bestellung> getBestellListe(){
		return listeBestellungen;
	}
	/**
	 * Getter-Methode fuer Fuellung
	 * @return Fuellung des Keks
	 */
	public Fuellung getFuellung(){
		return fuelle;
	}

	/**
	 * Getter-Methode fuer Form
	 * @return Form des Keks
	 */
	public Form getForm(){
		return form;
	}

	/**
	 * Getter-Methode fuer Anzahl
	 * @return Anzahl der Kekse
	 */
	public int getAnzahl(){
		return anzahl;
	}

	/**
	 * Getter-Methode fuer Teig
	 * @return Teig des Keks
	 */
	public Teig getTeig(){
		return teig;
	}


	/**
	 * fuegt neuen Wunsch zu der Bestellung (einfache Kekse)
	 * @param a anzahl der kekse
	 * @param f Form der Kekse
	 * @param t Teigart der kekse
	 */
	public void addKeks(int a, Form f, Teig t){
		listeBestellungen.add(new Bestellung(a,f,t));
	}

	/**
	 * fuegt neuen Wunsch zu der Bestellung (doppelte Kekse) 
	 * @param a anzahl der kekse
	 * @param f Form der Kekse
	 * @param t Teigart der kekse
	 * @param fu Fuellung der kekse
	 */
	public void addKeks(int a, Form f, Teig t, Fuellung fu){
		listeBestellungen.add(new Bestellung(a,f,t,fu));

	}


	/**
	 * 
	 * @return gibt alle Bestellungen zurueck
	 */
	public String drucke(){
		String out="";

		for(Bestellung liste:listeBestellungen){
			Bestellung bestellung=(Bestellung)liste;
			if(bestellung.getFuellung()==null){
				out +=bestellung.getAnzahl()+" "+bestellung.getForm()+" "+bestellung.getTeig()+"\n";
			}else{
				out +=bestellung.getAnzahl()+" "+bestellung.getForm()+" "+bestellung.getTeig()+" "+bestellung.getFuellung()+"\n";
			}
		}
		return out;
	}

}