
public class WunschTeigMuerb implements WunschTeig {

	@Override
	public Teig getTeig() {

		return new Muerbteig();
	}
	
	public String toString() {
		
		return "Muerb";
	}
}
