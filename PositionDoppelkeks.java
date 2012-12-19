
public class PositionDoppelkeks extends Position {
	
	private WunschFuellung fuellung;
	
	public PositionDoppelkeks(int anzahl, WunschTeig teig, WunschForm form, WunschFuellung fuellung) {
		
		super(anzahl, teig, form);
		this.fuellung = fuellung;
	}
	
	public Backmaschine getBackmaschine() {
		
		return new BackmaschineDoppelt();
	}
	
	public Fuellung getFuellung() {
		return fuellung.getFuellung();
	}
	
	public String toString() {
		
		return super.toString() + " mit \"" + fuellung + "\"-Fuellung";
	}
	
	protected String keks() {
		
		return "Doppelkeks(e)";
	}
}
