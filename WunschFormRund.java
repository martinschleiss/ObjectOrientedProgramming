
public class WunschFormRund implements WunschForm {

	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineRund();
	}
}
