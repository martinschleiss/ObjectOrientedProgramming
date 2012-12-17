
public class BackmaschineMond implements Backmaschine {

	@Override
	public Keks backe(Teig teig) {

		return new KeksMond(teig);
	}
}
