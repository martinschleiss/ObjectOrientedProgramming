import java.util.Iterator;

/**
 * Containerklasse zur Speicherung von frei waehlbaren Typen
 */
public class Set<T> implements Iterable<T> {

	private SetNode<T> head;
	private SetNode<T> last;

	public Set() {

		head = null;
		last = null;
	}

	/**
	 * fuegt Element in Set ein
	 * @param value		wird eingefuegt, falls nicht bereits in Set (wird mit == ueberprueft)
	 */
	public void insert(T value) {

		if (value != null) {
			remove(value); //ist ein Vorkommen in der Liste, wird es entfernt, um idente Duplikate zu vermeiden.

			if (head == null) {

				head = new SetNode<T>(value,head);
				last = head;

			} else {

				last.insert(value);
				last = last.getNext();
			}
		}
	}

	/**
	 * entfernt Element aus Set
	 * @param elem		wird entfernt, falls in Set (wird mit == ueberprueft)
	 */
	public void remove (T value) {

		if (head != null) {

			head = head.remove(value);
		}
	}

	/**
	 * liefert Iterator des Sets, Elementfolge des Iterators = Einfuegefolge des Sets
	 */
	public Iterator<T> iterator() {

		return new SetIterator<T>(this);
	}

	/**
	 * getter-Methode fuer den Listenkopf
	 */
	protected SetNode<T> getListHead() {

		return this.head;
	}

	/**
	 * setter-Methode fuer den Listenkopf
	 */
	protected void setListHead(SetNode<T> node) {

		this.head = node;
	}

	/*################################################################################################################
	 * INNER CLASS
	 * ################################################################################################################
	 */

	/**
	 * Iterator von Set
	 * Ausgabefolge ist unbestimmt, wird durch die Liste des Sets vorgegeben 
	 */
	private class SetIterator<S> implements Iterator<S> {

		private SetNode<S> next;
		private SetNode<S> current;
		private SetNode<S> prev;
		private Set<S> set;

		public SetIterator (Set<S> set) {

			this.set = set;
			next = set.getListHead();
			current = null;
			prev = null;
		}

		/**
		 * liefert true, wenn noch weitere Listenelemente nachfolgen, ansonsten false
		 */
		public boolean hasNext() {

			return next != null;
		}

		/**
		 * liefert das naechste Element der Liste
		 */
		public S next() {

			if (next != null) {

				SetNode<S> result = next;

				prev = current;
				current = next;
				next = next.getNext();

				return result.getValue();

			} else {

				return null;
			}
		}
		
		/**
		 * @param value wird direkt hinter den aktuellen Knoten des Iterators eingefuegt
		 */
		public void add(S value) {
			
			current.insert(value);
		}
		/**
		 * entfernt zuletzt zurueckgegebenes Element aus der Liste
		 * kann nur einmal pro next() aufgerufen werden.
		 */
		public void remove() throws IllegalStateException {

			if(current == null) {

				throw new IllegalStateException();

			} else {

				if(prev != null) {

					set.remove(current.getValue());
					current = null;
					prev = null;

				} else {

					set.setListHead(next);
					current = null;
				}
			}
		}
	}
}
