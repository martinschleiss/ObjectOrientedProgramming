
public class AutoSchnell<T extends Strategie> extends Auto<T> {

	public AutoSchnell(Feld startFeld, T s, Fahrbahn fahrbahn) {
		super(startFeld, s, fahrbahn);
	}
	
	public final int warteZeitInMillisekunden() {
		return 50;
	}
}
