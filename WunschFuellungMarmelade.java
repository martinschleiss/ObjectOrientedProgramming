
public class WunschFuellungMarmelade implements WunschFuellung {

	@Override
	public Fuellung getFuellung() {

		return new FuellungMarmelade();
	}
	
	public String toString() {
		
		return "Marmelade";
	}
}