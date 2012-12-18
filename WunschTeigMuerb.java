
public class WunschTeigMuerb implements WunschTeig {

	@Override
	public Teig getTeig() {

		return new Muerbteig();
	}
}
