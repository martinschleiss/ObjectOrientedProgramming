
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
	@Override
	public String toString() {
		
		return "Traktor (BiogasMotor), "+super.toString();
				
	}
}
