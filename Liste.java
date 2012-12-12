/**
 * Nicht-generische, einfach-verkettete Liste zum Speichern von Traktoren und Bauernhoefen
 * Mit entsprechenden Getter-Methoden ist diese Liste fuer beliebige Typen erweiterbar
 */

public class Liste {

	private Node head;

	public Liste() {

		head = null;
	}

	/**
	 * Fuegt Objekt o der Liste hinzu
	 * @param o != null
	 */
	public void add(Object o) {

		head = new Node(o,head);
	}

	/**
	 * Entfernt erstes Vorkommen von Objekt o aus der Liste
	 * @param o != null
	 */
	public void remove(Object o) {

		if (head != null) {

			head = head.remove(o);
		}
	}

	/**
	 * Liefert Wahrheitswert zur Bestimmung, ob Objekt o in Liste enthalten
	 * @param o != null
	 * @return	true: wenn in Liste enthalten, false: sonst
	 */
	public boolean contains(Object o) {

		return head != null && head.contains(o);
	}

	/**
	 * Liefert Iterator ueber die Liste, die Ausgabefolge ist unbestimmt
	 * @return ListIterator, liefert Object bei Aufruf von next()
	 */
	public Iterator iterator() {

		return new ListIterator(head);
	}

	/**
	 * Liefert Traktor anhand der eindeutigen Seriennummer
	 * @param seriennummer > 0
	 * @return Traktor: wenn enthalten, null: sonst
	 */
	public Traktor getTraktor(int seriennummer){

		Iterator it = iterator();
		Object o;

		while(it.hasNext()){

			o = it.next();

			if (o instanceof Traktor) {
				
				Traktor t = (Traktor) o;
				
				if(t.serienNummer() == seriennummer){
					
					return t;
				}
			}
		}
		return null;
	}
	
	/**
	 * Liefert Bauernhof anhand des unveraenderlichen Namens
	 * @param name
	 * @return Bauernhof: wenn enthalten, null: sonst
	 */
	public Bauernhof getBauernhof(String name){

		Iterator it = iterator();
		Object o;

		while(it.hasNext()){
			
			o = it.next();

			if (o instanceof Bauernhof) {

				Bauernhof b = (Bauernhof) o;
				
				if(b.name().equals(name)){
					
					return b;
				}
			}
		}
		return null;
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

		/**
		 * Liefert Wahrheitswert zur Bestimmung, ob Objekt o in diesem oder einem Nachfolgerknoten enthalten
		 * @param o != null
		 * @return	true: wenn in diesem oder einem Nachfolgerknoten enthalten, false: sonst
		 */
		private boolean contains(Object o) {

			return this.o == o || (next != null && next.contains(o));
		}

		/**
		 * Entfernt das erste Vorkommen von Objekt o in diesem oder einem Nachfolgerknoten
		 * @param o != null
		 * @return next: wenn Objekt in diesem Knoten enthalten war, sonst this
		 */
		private Node remove(Object o) {

			if (this.o == o) {

				return next;

			} else if (next != null) {

				next = next.remove(o);
			}
			return this;
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

