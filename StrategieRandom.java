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
		Feld tmp = null;

		while ((tmp == null) && count < 10) {

			state = generator.nextInt(5);

			switch (state) {
			case 0:		tmp = a.lenkeLinks(); System.out.println(tmp + "links");						
			break;
			case 1:		tmp = a.lenkeHalblinks(); System.out.println(tmp + "halblinks");	
			break;
			case 2:		tmp = a.geradeaus(); System.out.println(tmp + "gerade");	
			break;
			case 3:		tmp = a.lenkeHalbrechts(); System.out.println(tmp + "halbrechts");	
			break;
			case 4:		tmp = a.lenkeRechts(); System.out.println(tmp + "rechts");	
			break;
			default:	tmp = a.aktuellesFeld();
			}
			
			System.out.println("Versuch: " + count);
			
			count++;
		}
		if (tmp != null) {
		return tmp;
		} else {
			return a.aktuellesFeld();
		}
	}
}