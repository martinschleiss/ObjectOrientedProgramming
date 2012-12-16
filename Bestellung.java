
public class Bestellung {

	private Node head;

	private int anzahl;
	private Form form;
	private Teig teig;
	private Fuellung fuelle;

	public Bestellung(){

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

		head = new Node(new Bestellung(a,f,t),head);
	}

	/**
	 * fuegt neuen Wunsch zu der Bestellung (doppelte Kekse) 
	 * @param a anzahl der kekse
	 * @param f Form der Kekse
	 * @param t Teigart der kekse
	 * @param fu Fuellung der kekse
	 */
	public void addKeks(int a, Form f, Teig t, Fuellung fu){
		head = new Node(new Bestellung(a,f,t,fu),head);

	}
	public Iterator iterator() {

		return new ListIterator(head);
	}

	/**
	 * 
	 * @return gibt alle Bestellungen zurueck
	 */
	public String drucke(){
		String out="";

		Iterator liste=iterator();

		while(liste.hasNext()){
			Bestellung bestellung=(Bestellung)liste.next();
			if(bestellung.getFuellung()==null){
				out +=bestellung.getAnzahl()+" "+bestellung.getForm()+" "+bestellung.getTeig()+"\n";
			}else{
				out +=bestellung.getAnzahl()+" "+bestellung.getForm()+" "+bestellung.getTeig()+" "+bestellung.getFuellung()+"\n";
			}
		}
		return out;
	}

	/**
	 * ++++++++++++++++++++++++++++++ INNER CLASS ++++++++++++++++++++++++++++++
	 * 
	 * Ein Knoten speichert jeweils ein Element und eine Referenz zum Nachfolgerknoten
	 */

	private class Node {

		private Object o; // != null
		private Node next; //null, wenn Listenende

		private Node(Object o, Node next) {

			this.o = o;
			this.next = next;
		}

		/**
		 * Getter-Methode fuer Objekt
		 * @return gespeichertes Objekt != null
		 */
		private Object getObject() {

			return o;
		}
		/**
		 * Getter-Methode fuer Nachfolger-Knoten
		 * @return Nachfolgerknoten, null: wenn Listenende erreicht
		 */
		private Node getNext() {

			return next;
		}
	}


	/**
	 * ++++++++++++++++++++++++++++++ INNER CLASS ++++++++++++++++++++++++++++++
	 * 
	 * Listeniterator zum Iterieren der Liste, Ausgabefolge unbestimmt
	 */
	private class ListIterator implements Iterator{

		private Node current;

		private ListIterator(Node head) {

			current = head;
		}

		/**
		 * Liefert Wahrheitswert zur Bestimmstimmung, ob Listenende erreicht
		 * @return true: wenn Listenende erreicht, sonst: false
		 */
		public boolean hasNext() {

			return current != null;
		}

		/**
		 * Liefert naechstes Listenelement
		 * @return null: wenn Listenende erreicht, naechstes Listenelement: sonst
		 */
		public Object next() {

			if (current != null) {

				Node output = current;
				current = current.getNext();
				return output.getObject();

			} else {

				return null;
			}
		}
	}

}