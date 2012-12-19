
public class BackmaschineWeihnachtsmann implements Backmaschine {

	@Override
	public Keksdose backe(Position p) {

		Keksdose k = new Keksdose();
		
		for(int i = 0; i < p.getAnzahl(); i++) {
			k.befuelle(new KeksWeihnachtsmann(p.getTeig()));
		}
		
		return k;
	}
	
	/**
	 * +++++++++++++ INNER CLASS +++++++++++++++
	 */
	
	private class KeksWeihnachtsmann implements Keks {
		
		private Teig teig;
		
		public KeksWeihnachtsmann(Teig teig) {
			
			this.teig = teig;
		}
		
		public Keks clone() {
			
			return new KeksWeihnachtsmann(teig);
		}
		
		public String toString() {
			
			return "Keks in Weichnachtsmann-Form aus " + teig;
		}
	}
}
