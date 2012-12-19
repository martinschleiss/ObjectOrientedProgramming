
public class WunschTeigSchokolade implements WunschTeig {

	@Override
	public Teig getTeig() {

		return new Schokoladenteig();
	}
	
	public String toString() {
		
		return "Schokolade";
	}
	
	/**
	 * +++++++++++++++++++ INNER CLASS ++++++++++++++++
	 */
	
	private class Schokoladenteig implements Teig {

		public Teig clone() {
			
			return new Schokoladenteig();
		}
		
		public String toString() {
			
			return "Schokoladenteig";
		}
	}
}
