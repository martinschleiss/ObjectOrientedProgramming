
public class WunschTeigZimtstern implements WunschTeig {

	@Override
	public Teig getTeig() {

		return new Zimtsternteig();
	}
	
	public String toString() {
		
		return "Zimtstern";
	}
	
	/**
	 * ++++++++++++++++++++++++ INNER CLASS ++++++++++++++++++++
	 */
	
	private class Zimtsternteig implements Teig {

		public Teig clone() {
			
			return new Zimtsternteig();
		}
		
		public String toString() {
			
			return "Zimtsternteig";
		}
	}
}
