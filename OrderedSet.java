import java.util.Iterator;

/**
 * Containerklasse zur Speicherung von Typen, die Shorter implementieren. Diese Klasse muss sicherstellen, dass der zurueckgelieferte Iterator die vorgegebene
 * Ausgabefolge einhalten muss. Diese besagt, dass ausgegebene Elemente entsprechend Shorter niemals kuerzer als vorangegangene sein duerfen.
 */
public class OrderedSet<T extends Shorter<? super T>> extends Set<T> {

	public OrderedSet() {

		super();
	}

	/**
	 * liefert Iterator des Sets, wobei nachfolgende Elemente entsprechend shorter 
	 * niemals kuerzer sind als vorangegangene sein duerfen
	 */
	public Iterator<T> iterator() {

		return new OrderedSetIterator<T>(this);
	}

	/**
	 * Fuegt Element in Set ein. Die Elemente werden auf die Weise gespeichert, dass der Nachfolger nicht kuerzer als sein Vorgaenger ist
	 * (zeitliche Dauern sind z.B. aufsteigend sortiert)
	 */
	public void insert(T value) {

		remove(value);

		SetNode<T> pos = super.getListHead();
		SetNode<T> posNext;

		if (pos == null) {

			super.setListHead(new SetNode<T>(value,pos));;

		} else {

			if (value.shorter(pos.getValue())) {

				super.setListHead(new SetNode<T>(value, pos));

			} else {

				posNext = pos.getNext();

				if (posNext == null) {

					pos.insert(value);

				} else {

					while (posNext.getNext() != null && posNext.getValue().shorter(value)) {

						pos = posNext;
						posNext = posNext.getNext();
					}

					if (posNext.getNext() == null && posNext.getValue().shorter(value)) {
						
						posNext.setNext(new SetNode<T>(value,posNext.getNext()));
						
					} else {
						
						pos.setNext(new SetNode<T>(value, posNext));

					}
				}
			}
		}
	}
	/*################################################################################################################
	 * INNER CLASS
	 * ################################################################################################################
	 */

	/**
	 * Iterator von OrderedSet (entspricht dem Iterator von Set ohne die add(S value) Methode
	 * Invariante: Der Iterator veraendert die Ordnung die durch Shorter hergestellt wurde nicht.
	 */
	private class OrderedSetIterator<S extends Shorter<? super S>> implements Iterator<S> {

		private SetNode<S> next;
		private SetNode<S> current;
		private SetNode<S> prev;
		private OrderedSet<S> set;

		public OrderedSetIterator (OrderedSet<S> set) {

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
		 * liefert das naechste Element, wobei nachfolgende Elemente entsprechend shorter niemals kuerzer sind als vorangegangene
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
