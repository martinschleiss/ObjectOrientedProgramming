
public class Keks <F extends Form, T extends Teig> {
	
	private F form;
	private T teig;
	
	public Keks(F form, T teig) {
		this.form =form;
		this.teig=teig;
		
	}
	public F getForm(){
		return form;
	}
	public T getTeig(){
		return teig;
	}
	public String toString(){
		return "Keks: "+form+" "+teig+" ";
	}

}