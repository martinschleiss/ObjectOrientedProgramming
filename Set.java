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
	 * fuegt Element vor prev in Set ein. Ist prev nicht enthalten, wird value am Ende eingefuegt,
	 * wird fuer prev null uebergeben, wird das Element als erstes Element eingefuegt
	 * @param elem		wird eingefuegt, falls nicht in Set (wird mit == ueberprueft)
	 *
	public void insert(T value, T prev) {

		remove(value);
		SetNode<T> tmp = head;

		if (tmp == null) {

			insert(value);

		} else if (prev == null) {
			
			head = new SetNode<T>(value,head);
		
		} else {

			while (tmp.getNext() != null && tmp.getValue() != prev) {

				tmp = tmp.getNext();
			}
			tmp.insert(value);
		}
	}*/

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

		return new SetIterator<T>(head);
	}

	protected SetNode<T> getListHead() {

		return this.head;
	}
	
	public void setListHead(SetNode<T> elem) {
		this.head = elem;
	}
}
