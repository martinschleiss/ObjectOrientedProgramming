
public class BackmaschineRund implements Backmaschine {

	@Override
	public Keksdose backe(Position p) {

		Keksdose k = new Keksdose();
		
		for(int i = 0; i < p.getAnzahl(); i++) {
			k.befuelle(new KeksRund(p.getTeig()));
		}
		
		return k;
	}
	
	/**
	 * ++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 */
	
	private class KeksRund implements Keks {

		private Teig teig;
		
		public KeksRund(Teig teig) {
			
			this.teig = teig;
		}
		
		public Keks clone() {
			
			return new KeksRund(teig);
		}
		
		public String toString() {
			
			return "Keks in Rund-Form aus " + teig;
		}
	}
}
