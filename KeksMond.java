
public class KeksMond implements Keks {
	
	private Teig teig;
	
	public KeksMond(Teig teig) {
		
		this.teig = teig;
	}
	
	public Keks clone() {
		
		return new KeksMond(teig.clone());
	}
	
	public String toString() {
		
		return "Keks in Mond-Form aus " + teig;
	}
}