
public class Schokoladenteig implements Teig {

	public Teig clone() {
		
		return new Schokoladenteig();
	}
	
	public String toString() {
		
		return "Schokoladenteig";
	}
}