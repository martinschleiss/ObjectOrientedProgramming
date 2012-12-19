
public class BackmaschineMond implements Backmaschine {

	@Override
	public Keksdose backe(Position p) {

		Keksdose k = new Keksdose();
		
		for(int i = 0; i < p.getAnzahl(); i++) {
			k.befuelle(new KeksMond(p.getTeig()));
		}
		
		return k;
	}
	
	/**
	 * +++++++++++++++++++++ INNER CLASS ++++++++++++++++++++++++++
	 */
	
	private class KeksMond implements Keks {
		
		private Teig teig;
		
		public KeksMond(Teig teig) {
			
			this.teig = teig;
		}
		
		public Keks clone() {
			
			return new KeksMond(teig.clone());
		}
		
		public String toString() {
			
			return "Keks in Mond-Form aus " + teig;
		}
	}
}
