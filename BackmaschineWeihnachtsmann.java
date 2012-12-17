
public class BackmaschineWeihnachtsmann implements Backmaschine {

	@Override
	public Keks backe(Teig teig) {

		return new KeksWeihnachtsmann(teig);
	}
}
