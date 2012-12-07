
public class TraktorErweiterungDuengestreuer extends TraktorErweiterung {
	
	private double fassungskapazitaet;
	
	public TraktorErweiterungDuengestreuer(double fassungskapazitaet){
		this.fassungskapazitaet=fassungskapazitaet;
	}
	
	public double erweiterungsAusmasz() {
		return fassungskapazitaet;
	}
	@Override
	public String toString(){
		return "Duengestreuer";
	}
}
