
public class AutoNormal<T extends Strategie> extends Auto<T> {
	
	public AutoNormal(Fahrbahn fahrbahn, Feld startFeld, T s) {
		super(fahrbahn, startFeld, s);
	}
	
	public final int warteZeitInMillisekunden() {
		return 100;
	}
}
