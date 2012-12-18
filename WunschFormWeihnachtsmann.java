
public class WunschFormWeihnachtsmann implements WunschForm {
	
	@Override
	public Backmaschine getBackmaschine() {

		return new BackmaschineWeihnachtsmann();
	}
	
	public String toString() {
		
		return "Weihnachtsmann";
	}
}
