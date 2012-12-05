/**
 * fuer bewegliche Autos
 *
 */
public class StrategieSchlangenLinien extends Strategie{

	private int state;

	public StrategieSchlangenLinien() {

		super();
		state = 0;
	}

	public Feld naechstesManoever(Auto a) {

		int count = 0;
		Feld tmp = null;

		while ((tmp == null) && count < 5) {

			state = (state + 1) % 5;

			switch (state) {
			case 0:		tmp = a.lenkeLinks();						
			break;
			case 1:		tmp = a.lenkeHalblinks();
			break;
			case 2:		tmp = a.geradeaus();
			break;
			case 3:		tmp = a.lenkeHalbrechts();
			break;
			case 4:		tmp = a.lenkeRechts();
			break;
			default:	tmp = a.aktuellesFeld();
			}
			count++;
		}
		if (tmp != null) {
			return tmp;
		} else {
			return a.aktuellesFeld();
		}
	}
}


