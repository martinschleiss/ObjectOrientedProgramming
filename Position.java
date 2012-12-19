
public class Position {
	
	private int anzahl;
	private WunschTeig teig;
	private WunschForm form;
	
	public Position(int anzahl, WunschTeig teig, WunschForm form) {
		
		this.anzahl = anzahl;
		this.teig = teig;
		this.form = form;
	}
	
	public Backmaschine getBackmaschine() {
		
		return form.getBackmaschine();
	}
	
	public Teig getTeig() {
		
		return teig.getTeig();
	}
	
	public int getAnzahl() {
		return anzahl;
	}
	
	public WunschForm getForm() {
		return form;
	}
	
	public String toString() {
		
		return "Anzahl: "+ anzahl + "\t" + teig + "-" + keks() + " in \"" + form + "\"-Form";
	}
	
	protected String keks() {
		
		return "Keks(e)";
	}

}
