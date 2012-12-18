
public class KeksWeihnachtsmann implements Keks {
	
	private Teig teig;
	
	public KeksWeihnachtsmann(Teig teig) {
		
		this.teig = teig;
	}
	
	public Keks clone() {
		
		return new KeksWeihnachtsmann(teig);
	}
	
	public String toString() {
		
		return "Keks in Weichnachtsmann-Form aus " + teig;
	}
}