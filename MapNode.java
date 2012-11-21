
public class MapNode<T, O> extends SetNode<T>{

	private Set<O> objects;
	private MapNode<T,O> next;
	
	/**
	 * Konstruktor:	
	 * @param obj	darf auch null sein, Set behandelt diesen Fall
	 */
	MapNode(T value, O obj, MapNode<T, O> next) {

		super(value,null);
		objects = new Set<O>();
		objects.insert(obj);
		this.next = next;
	}
	
	/**
	 * Speichert Objekt im Knoten dessen Wert T entspricht
	 * @param obj	darf auch null sein
	 */
	public void add(T value, O obj) {
		
		if (super.getValue() == value) {
			
			objects.insert(obj);
		
		} else if (next != null) {
			
			next.add(value,obj);
		}
	}
	
	/**
	 * getter-Methode
	 * @return naechsten Knoten der Liste
	 */
	public MapNode<T,O> getNext() {

		return this.next;
	}
	
	public Set<O> getObjects() {
		
		return objects;
	}
	
	/**
	 * setter-Methode
	 * @param node	wird als naechstes Listenelement eingefuegt
	 * Vorbedingung: node.next muss this.next sein, damit die Liste zusammenhaengend bleibt
	 */

	public void setNext(MapNode<T,O> node) {

		assert (this.next == node.getNext()) : "Die next-Verweise der Knoten stimmen nicht ueberein";

		this.next = node;	
	}
	
	/**
	 * Fuegt Element als Nachfolger dieses Knotens ein
	 */
	public void insert(T value) {
		
		next = new MapNode<T,O>(value,null,next);
	}
	
	/**
	 * Fuegt Element als Nachfolger dieses Knotens ein
	 */
	public void insert(T value, O obj) {
		
		next = new MapNode<T, O>(value, obj, this.next);
	}
	
	/**
	 * Entfernt Element aus verketteten Liste
	 * @param value		wird entfernt, wenn Werte ident sind (wird mit "==" ueberprueft)
	 * Das idente Werte auf unterschiedliche Objekte verweisen koennen wird nicht beruecksichtigt
	 */
	public MapNode<T,O> remove(T value) {

		if (super.getValue() == value) {

			return next;

		} else if (next != null) {

			next = next.remove(value);
		}
		return this;
	}
}