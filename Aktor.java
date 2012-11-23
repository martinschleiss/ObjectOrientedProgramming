
public class Aktor extends Komponente {

	private int leistung; //in kW

	public Aktor(String name, int leistung) {
		
		super(name + " (Aktor)");
		this.leistung = leistung;
	}
	
	public int leistung() {
		
		return leistung;
	}
}
