
public class TraktorErweiterungDuengestreuer extends TraktorErweiterung {
	
	private double fassungskapazitaet;
	
	public TraktorErweiterungDuengestreuer(double fassungskapazitaet){
		this.fassungskapazitaet=fassungskapazitaet;
	}
	
	@Override
	public double erweiterungsAusmass() {
		return fassungskapazitaet;
	}
	@Override
	public String toString(){
		return "Duengestreuer";
	}
}
