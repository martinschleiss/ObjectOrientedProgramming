
public class Einfachkeks <F extends Form, T extends Teig> extends Keks<F, T> {
	
	private F form;
	private T teig;
	
	public Einfachkeks(F form, T teig) {
		
		this.form =form;
		this.teig=teig;
	}
	
	public F getForm() {
		
		return form;
	}
	
	public T getTeig() {
		
		return teig;
	}
	
	public String toString() {
		
		return "Keks: " + form + ", " + teig;
	}
}