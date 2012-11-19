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
}
