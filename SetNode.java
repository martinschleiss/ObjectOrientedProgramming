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
	 * Entfernt Element aus verketteten Liste
	 * @param elem
	 * @return
	 */
	public SetNode<T> remove(T value) {
		
		if (this.value == value) {
			
			return next;
		
		} else if (next != null) {
			
			next = next.remove(value);
		}
		return this;
	}
	
	/**
	 * Fuegt Element als Nachfolger dieses Knotens ein
	 */
	public void insert(T value) {
		
		next = new SetNode<T>(value,next);
	}
}
