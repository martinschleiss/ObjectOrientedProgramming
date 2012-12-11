
public class TraktorErweiterungDrillmaschine extends TraktorErweiterung {

	private int saeschare;
	public TraktorErweiterungDrillmaschine(int saeschare) {
		this.saeschare=saeschare;
	}
	
	@Override
	public double erweiterungsAusmass() {
		return saeschare;
	}
	@Override
	public String toString(){
		return "Drillmaschine";
	}
}
