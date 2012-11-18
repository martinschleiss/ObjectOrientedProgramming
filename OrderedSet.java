import java.util.Iterator;


public class OrderedSet<T extends Shorter> extends Set<T> {

	public OrderedSet() {

		super();
	}
	
	/**
	 * liefert Iterator des Sets, wobei nachfolgende Elemente entsprechend shorter 
	 * niemals kuerzer sind als vorangegangene
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
		SetNode<T> tmp;

		if (pos == null) {

			super.insert(value);

		} else {

			tmp = pos.getNext();

			if (tmp == null) {
				
				if (pos.getValue().shorter(value)) {
				
					super.insert(value);

				} else {
					
					super.setListHead(new SetNode<T>(value, pos));
				}
				
			} else {

				while (tmp.getNext() != null && tmp.getValue().shorter(value)) {

					pos = tmp;
					tmp = tmp.getNext();
				}
				pos.setNext(new SetNode<T>(value, tmp));
			}
		}
	}
}
