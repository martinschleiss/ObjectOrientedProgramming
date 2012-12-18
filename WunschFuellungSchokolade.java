
public class WunschFuellungSchokolade implements WunschFuellung {

	@Override
	public Fuellung getFuellung() {
		
		return new FuellungSchokolade();
	}
	
	public String toString() {
		
		return "Schokolade";
	}
}