
public class WunschTeigZimtstern implements WunschTeig {

	@Override
	public Teig getTeig() {

		return new Zimtsternteig();
	}
	
	public String toString() {
		
		return "Zimtstern";
	}
}
