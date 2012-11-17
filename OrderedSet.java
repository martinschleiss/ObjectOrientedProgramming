
public class OrderedSet<T extends Shorter> extends Set<T> {

	public OrderedSet() {

		super();
	}

	/**
	 * Fuegt Element in Set ein. Die Elemente werden auf die Weise gespeichert, dass der Nachfolger nicht kuerzer als sein Vorgaenger ist
	 * (zeitliche Dauern sind z.B. aufsteigend sortiert)
	 */
	public void insert(T value) {

		SetNode<T> pos = super.getListHead();
		SetNode<T> tmp;

		if (pos == null) {

			super.insert(value);

		} else {

			tmp = pos.getNext();

			if (tmp == null) {
				
				if (pos.getValue().shorter(value)) {
				
					super.insert(value);

				} else {
					
					super.insert(value,null);
				}
				
			} else {

				while (tmp.getNext() != null && tmp.getValue().shorter(value)) {

					pos = pos.getNext();
					tmp = tmp.getNext();
				}

				super.insert(value, pos.getValue());
			}
		}
	}
}
