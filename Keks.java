
public class Keks <F extends Form, T extends Teig> {
	
	private F form;
	private T teig;
	
	public Keks(F form, T teig) {
		this.form =form;
		this.teig=teig;
	}

}