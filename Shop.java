import java.util.Iterator;
import java.util.TreeMap;
public class Shop {
	
	private TreeMap<Integer, Androide> liste = new TreeMap<Integer, Androide>();

	
	public String insert(Androide a) { //retourniert Fehlercode bzw Erfolgsmeldung
		//a.insertWennVerordnungErfuellt(liste);
		//a.fuegeAndroideZuListeHinzu(liste);
		return "";
	}
	
	public String find(int key) {
		
		if (liste.get(key) != null) {
			
			return liste.get(key).toString();
		
		} else {
			
			return null;
		}
	}
	
	public Iterator<Androide> iterator() {
		
		return new ShopIterator<Androide>(liste);
	}
	
	private class ShopIterator<T> implements Iterator<T> {

		private TreeMap<Integer,T> list;
		private T value;
		private Integer currentKey;
		
		public ShopIterator(TreeMap<Integer,T> list) {
			
			this.list = list;
			currentKey = list.firstKey();
			value = list.get(currentKey);
			
		}
		@Override
		public boolean hasNext() {

			return value != null;
		}

		@Override
		public T next() {

			currentKey = list.higherKey(currentKey);
			
			if (currentKey != null) {
				
				value = list.get(currentKey);
			
				return value; 
			}
			
			return null;
		}

		@Override
		public void remove() {
			
			list.remove(currentKey);
		}
	}
}
