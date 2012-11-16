/**
 * Knoten einer einfach-verketteten, generischen Liste
 */
public class SetNode<T> {
	
	private T elem;
	private SetNode<T> next;
	
	SetNode (T elem, SetNode<T> next) {
		
		this.elem = elem;
		this.next = next;
	}
	
	/**
	 * getter-Methode
	 * @return gespeichertes Element
	 */
	public T getElem() {
		
		return this.elem;
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
	public SetNode<T> remove(T elem) {
		
		if (this.elem == elem) {
			
			return next;
		
		} else if (next != null) {
			
			next = next.remove(elem);
		}
		return this;
	}
}
