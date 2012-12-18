import java.util.ArrayList;
import java.util.Collection;


public class Keksdose {

	private ArrayList<Keks> kekse;

	public Keksdose() {

		kekse = new ArrayList<Keks>();
	}

	/**
	 * 
	 * @param k der uebergebende Keks wird zur Liste(Keksdose) hinzugefuegt
	 */
	public void befuelle(Keks k) {

		kekse.add(k);
	}
	
	/**
	 * 
	 * @param c die Collection aus Keksen wird zur Liste(Keksdose) hinzugefuegt
	 */
	public void befuelle(Collection<Keks> c) {

		kekse.addAll(c);
	}

	/**
	 * gibt den Inhalt (alle Kekse) der Keksdose aus
	 */
	public void inhalt() {

		for (Keks k : kekse) {

			System.out.println(k);
		}
	}
}