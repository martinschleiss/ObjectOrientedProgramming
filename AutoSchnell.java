
public class AutoSchnell<T extends Strategie> extends Auto<T> {

	public AutoSchnell(Feld startFeld, T s) {
		super(startFeld, s);
	}
	
	public final int warteZeitInMillisekunden() {
		return 50;
	}
}
