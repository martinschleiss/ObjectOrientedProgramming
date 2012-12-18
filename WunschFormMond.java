
public class WunschFormMond implements WunschForm {

	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineMond();
	}
}
