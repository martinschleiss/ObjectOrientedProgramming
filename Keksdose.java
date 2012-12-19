import java.util.ArrayList;

/**
 * Repraesentiert Keksdose, bietet Methoden zum Befuellen und Ausgeben des Inhalts
 */
public class Keksdose {

	private ArrayList<Keks> kekse;

	public Keksdose() {

		kekse = new ArrayList<Keks>();
	}

	/**
	 * Befuellt Dose mit uebergebenen Keks k
	 * @param k != null
	 */
	public void befuelle(Keks k) {

		kekse.add(k);
	}
	
	/**
	 * Befuellt Dose mit allen Keksen der uebergebenen Keksdose k
	 * Es muss sichergestellt werden, dass k nach dem Befuellen geloescht wird
	 * 		da sonst alle Kekse in k in 2 Keksdosen gleichzeitig sind
	 * @param k != null
	 */
	public void befuelle(Keksdose k) {
		
		kekse.addAll(k.getKekse());
	}
	
	/**
	 * liefert Liste mit allen Keksen der Keksdose
	 * @return ArayList<Keks> mit allen Keksen der Keksdose
	 */
	public ArrayList<Keks> getKekse() {
		
		return kekse;
	}

	/**
	 * gibt den Inhalt (alle Kekse) der Keksdose aus
	 */
	public void inhalt() {

		System.out.println("++++++++++++++++++++ Keksdose ++++++++++++++++++++\n");
		
		if (kekse.isEmpty()) {
			
			System.out.println("leere Keksdose");
		}
		
		for (Keks k : kekse) {
			
			System.out.println(k);
		}
		
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}