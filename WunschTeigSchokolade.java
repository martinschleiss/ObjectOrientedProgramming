
public class WunschTeigSchokolade implements WunschTeig {

	@Override
	public Teig getTeig() {

		return new Schokoladenteig();
	}
}
