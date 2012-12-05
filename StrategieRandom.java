import java.util.Random;

/**
 *fuer schnelle Autos
 *
 */
public class StrategieRandom extends Strategie{

	private int state;
	Random generator;

	public StrategieRandom() {

		super();
		state = 0;
		generator = new Random();
	}

	public Feld naechstesManoever(Auto a) {

		int count = 0;
		int random = 0;
		Feld tmp = null;

		while ((tmp == null) && count < 5) {

			state = generator.nextInt(5);

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
			
			if (tmp == null) {
				
				random = generator.nextInt(4);
				
				switch (state) {
				case 0:		a.setAusrichtung(Auto.ausrichtung.N);
				break;
				case 1:		a.setAusrichtung(Auto.ausrichtung.O);
				break;
				case 2:		a.setAusrichtung(Auto.ausrichtung.S);
				break;
				case 3:		a.setAusrichtung(Auto.ausrichtung.W);	
				break;
				default:	a.setAusrichtung(Auto.ausrichtung.W);
				}
			}
		}
		
		if (tmp != null) {
			
		return tmp;

		} else {
					
			return a.aktuellesFeld();
		}
	}
}