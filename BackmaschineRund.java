
public class BackmaschineRund implements Backmaschine {

	@Override
	public Keks backe(Teig teig) {

		return new KeksRund(teig);
	}
}
