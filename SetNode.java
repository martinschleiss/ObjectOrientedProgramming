/**
 * Knoten einer einfach-verketteten, generischen Liste
 */
public class SetNode<T> {

	private T value;
	private SetNode<T> next;

	SetNode (T value, SetNode<T> next) {

		this.value = value;
		this.next = next;
	}

	/**
	 * getter-Methode
	 * @return gespeichertes Element
	 */
	public T getValue() {

		return this.value;
	}

	/**
	 * getter-Methode
	 * @return naechsten Knoten der Liste
	 */
	public SetNode<T> getNext() {

		return this.next;
	}

	/**
	 * setter-Methode f
	 * @param elem	wird als naechstes Listenelement eingefuegt
	 * Vorbedingung: node.next muss this.next sein, damit die Liste zusammenhaengend bleibt
	 */

	public void setNext(SetNode<T> node) {

		assert (this.next == node.getNext()) : "Die next-Verweise der Knoten stimmen nicht ueberein";

		this.next = node;	
	}

	/**
	 * Fuegt Element als Nachfolger dieses Knotens ein
	 */
	public void insert(T value) {

		next = new SetNode<T>(value,next);
	}
	
	/**
	 * Entfernt Element aus verketteten Liste
	 * @param value		wird entfernt, wenn Werte ident sind (wird mit "==" ueberprueft)
	 */
	public SetNode<T> remove(T value) {

		if (this.value == value) {

			return next;

		} else if (next != null) {

			next = next.remove(value);
		}
		return this;
	}
}
