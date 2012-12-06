
public class TraktorMitBiogasMotor extends Traktor {

	private double biogasVerbrauch;
	
	@Override
	public double bisherigerVerbrauch() {
		return biogasVerbrauch;
	}
	
	@Override
	public void erhoeheVerbrauch(double verbrauch) {
		biogasVerbrauch += verbrauch;
	}
}
