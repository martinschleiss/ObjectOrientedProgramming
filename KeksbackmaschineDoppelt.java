
public class KeksbackmaschineDoppelt extends Keksbackmaschine {

	public Keks<? extends Form, ? extends Teig> keksFactory(Form form, Teig teig){
		return null;
	}
	
	public Keks<? extends Form, ? extends Teig> keksFactory(Keks<? extends Form, ? extends Teig> keks, Fuellung fuelle){
		
		return new DoppelKeks<Form, Teig>(keks.getForm(), keks.getTeig(), fuelle);
	}
}
