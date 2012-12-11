
public class TraktorMitDieselMotor extends Traktor {

	private int dieselVerbrauch;

	@Override
	public double bisherigerVerbrauch() {
		return dieselVerbrauch;
	}
	
	@Override
	public void erhoeheVerbrauch(double verbrauch) {
		dieselVerbrauch += (int)verbrauch;
	}
	@Override
	public String toString() {
		
		return "Traktor (DieselMotor), "+super.toString();
				
	}
}
