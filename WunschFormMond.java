
public class WunschFormMond implements WunschForm {

	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineMond();
	}
	
	public String toString() {
		
		return "Mond";
	}
}
