
public class WunschFormWeihnachtsmann implements WunschForm {
	
	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineWeihnachtsmann();
	}
}
