
public class AutoNormal<T extends Strategie> extends Auto<T> {
	
	public AutoNormal(Feld startFeld, T s) {
		super(startFeld, s);
	}
	
	public final int warteZeitInMillisekunden() {
		return 100;
	}
}
