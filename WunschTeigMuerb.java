
public class WunschTeigMuerb implements WunschTeig {

	@Override
	public Teig getTeig() {

		return new Muerbteig();
	}
	
	public String toString() {
		
		return "Muerb";
	}
	
	/**
	 * ++++++++++++++++++ INNER CLASS +++++++++++++++
	 */
	
	private class Muerbteig implements Teig {

		public Teig clone() {
			
			return new Muerbteig();
		}
		
		public String toString() {
			
			return "Muerbteig";
		}
	}
}
