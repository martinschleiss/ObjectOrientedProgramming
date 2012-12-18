
public class KeksRund implements Keks {

	private Teig teig;
	
	public KeksRund(Teig teig) {
		
		this.teig = teig;
	}
	
	public Keks clone() {
		
		return new KeksRund(teig);
	}
	
	public String toString() {
		
		return "Keks in Rund-Form aus " + teig;
	}
}
