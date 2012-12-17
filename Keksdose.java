import java.util.ArrayList;
import java.util.Collection;


public class Keksdose {

	private ArrayList<Keks> kekse;

	public Keksdose() {

		kekse = new ArrayList<Keks>();
	}

	public void befuelle(Keks k) {

		kekse.add(k);
	}
	
	public void befuelle(Collection<Keks> c) {

		kekse.addAll(c);
	}

	public void inhalt() {

		for (Keks k : kekse) {

			System.out.println(k);
		}
	}
}