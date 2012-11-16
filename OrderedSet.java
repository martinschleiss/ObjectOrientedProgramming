
public class OrderedSet<T extends Shorter> extends Set<T> {

	public OrderedSet() {

		super();
	}

	public void insert(T value) {

		SetNode<T> tmp = super.getValue();
		
		while (tmp != null && tmp.getNext() != null && tmp.getValue().shorter(value)) {

			tmp = tmp.getNext();
		}

		if (tmp != null) {

			super.insert(value, tmp.getValue());
		
		} else {
		
			super.insert(value);
		}
	}

	public boolean shorter(T elem) {

		return true;
	}
}
