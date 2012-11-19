import java.util.Iterator;

public class Set<T> implements Iterable<T> {

	private SetNode<T> head;
	private SetNode<T> last;

	public Set() {

		head = null;
		last = null;
	}

	/**
	 * fuegt Element in Set ein
	 * @param elem		wird eingefuegt, falls nicht bereits in Set (wird mit == ueberprueft)
	 */
	public void insert(T value) {

		remove(value);

		if (head == null) {

			head = new SetNode<T>(value,head);
			last = head;

		} else {

			last.insert(value);
			last = last.getNext();
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

	protected SetNode<T> getListHead() {

		return this.head;
	}
	
	public void setListHead(SetNode<T> elem) {
		this.head = elem;
	}
	
	/*################################################################################################################
	 * INNER CLASS
	 * ################################################################################################################
	 */
	
	/**
	 * Iteratorklasse von Set
	 * Ausgabefolge wird durch die Instanz von Set bestimmt
	 */
	private class SetIterator<S> implements Iterator<S> {

		private SetNode<S> node;
		private SetNode<S> prev;
		private SetNode<S> previousOfPrev;
		private Set<S> set;

		public SetIterator (Set<S> set) {
			this.set = set;
			node = this.set.getListHead();
			prev = null;
		}
		
		/**
		 * liefert true, wenn noch weitere Listenelemente nachfolgen, ansonsten false
		 */
		public boolean hasNext() {

			return node != null;
		}
		
		/**
		 * liefert das naechste Element, wobei nachfolgende Elemente entsprechend shorter niemals kuerzer sind als vorangegangene
		 */
		public S next() {
			
			if (node != null) {

				SetNode<S> result = node;
				if(previousOfPrev != null) {
					previousOfPrev = prev;
				}
				prev = node;
				node = node.getNext();

				return result.getValue();

			} else {

				return null;
			}

		}

		/**
		 * entfernt zuletzt zurueckgegebenes Element aus der Liste
		 */
		public void remove() throws IllegalStateException {
			
			if(prev == null) {
				throw new IllegalStateException();
			} else {
				if(previousOfPrev != null) {
					prev.setNext(null);
					prev = null;
					previousOfPrev.setNext(node);
				} else {
					prev = null;
					set.setListHead(node);
				}
			}
		}
	}
}
