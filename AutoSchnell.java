
public class AutoSchnell<T extends Strategie> extends Auto<T> {

	public AutoSchnell(Fahrbahn fahrbahn, Feld startFeld, T s) {
		super(fahrbahn, startFeld, s);
	}
	
	public final int warteZeitInMillisekunden() {
		return 50;
	}
}
