
public class KeksbackmaschineEinfach extends Keksbackmaschine {
	
	public Keks<? extends Form, ? extends Teig> keksFactory(Form form, Teig teig){
		return new Keks<Form, Teig>(form, teig);
	}
	
	public Keks<? extends Form, ? extends Teig> keksFactory(Keks<? extends Form, ? extends Teig> keks, Fuellung fuelle){
		return null;
	}
}
