import java.util.ArrayList;
import java.util.Collection;


public class Keksdose {

	private ArrayList<Keks<? extends Form, ? extends Teig>> kekse;

	public Keksdose() {

		kekse = new ArrayList<Keks<? extends Form, ? extends Teig>>();
	}

	public void befuelle(Collection<Keks<? extends Form, ? extends Teig>> c) {

		kekse.addAll(c);
	}

	public void inhalt() {

		for (Keks<? extends Form, ? extends Teig> k : kekse) {

			System.out.println(k);
		}
	}
}