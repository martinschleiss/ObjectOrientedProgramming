
public class AutoNormal<T extends Strategie> extends Auto<T> {
	
	public AutoNormal(Feld startFeld, T s, Fahrbahn fahrbahn) {
		super(startFeld, s, fahrbahn);
	}
	
	public final int warteZeitInMillisekunden() {
		return 100;
	}
}
