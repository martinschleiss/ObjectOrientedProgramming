
public class DoppelKeks<F extends Form, T extends Teig> extends Keks<F, T> {
	
	private Fuellung fu;
	public DoppelKeks(F f, T t, Fuellung fu) {
		super(f, t);
		this.fu=fu;
		
	}
	public String toString(){
		return "DoppelKeks:"+" "+this.getForm()+" "+this.getTeig()+" "+fu;
	}

}