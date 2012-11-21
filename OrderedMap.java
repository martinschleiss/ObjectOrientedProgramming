public class OrderedMap<T extends Shorter<T>, O> extends OrderedSet<T>{

	private MapNode<T,O> head;

	public OrderedMap() {

		super();
		head = null;
	}

	/**
	 * Fuegt Element in Set ein. Die Elemente werden auf die Weise gespeichert, dass der Nachfolger nicht kuerzer als sein Vorgaenger ist
	 * (zeitliche Dauern sind z.B. aufsteigend sortiert)
	 */
	public void insert(T value) {

		insert(value, null);
	}

	/**
	 * Fuegt Element in Set ein. Die Elemente werden auf die Weise gespeichert, dass der Nachfolger nicht kuerzer als sein Vorgaenger ist
	 * (zeitliche Dauern sind z.B. aufsteigend sortiert)
	 * @param obj	Objekt wird im neuen Knoten von value gespeichert
	 */
	//TODO: insert ist noch nicht sortiert, von orderedset kopieren
	public void insert(T value, O obj) {

		remove(value);

		MapNode<T,O> pos = head;
		MapNode<T,O> posNext;

		if (pos == null) {

			head = new MapNode<T,O>(value, obj, pos);

		} else {

			if (value.shorter(pos.getValue())) {

				head = new MapNode<T,O>(value, obj, pos);

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

						posNext.setNext(new MapNode<T,O>(value,obj,posNext.getNext()));

					} else {

						pos.setNext(new MapNode<T,O>(value, obj, posNext));
					}
				}
			}
		}
	}

	public void add(T value, O obj) {

		head.add(value,obj);
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
	 * liefert Iterator des Sets, wobei nachfolgende Elemente entsprechend shorter 
	 * niemals kuerzer sind als vorangegangene
	 */
	public OrderedMapIterator<T,O> iterator() {

		return new OrderedMapIterator<T,O>(this);
	}
	public MapNode<T,O> getMapHead() {

		return head;
	}
}
