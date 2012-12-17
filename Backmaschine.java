
public class Backmaschine<F extends Form> {
	
	private F form;
	
	public Backmaschine(F form) {
		
		this.form = form;
	}
	
	public Keks<F, Muerbteig> backe(Muerbteig teig){
		
		return new Einfachkeks<F, Muerbteig>(form, teig);
	}
	
	public Keks<F, Schokoladenteig> backe(Schokoladenteig teig){
		
		return new Einfachkeks<F, Schokoladenteig>(form, teig);
	}
	
	public Keks<F, Zimtsternteig> backe(Zimtsternteig teig){
		
		return new Einfachkeks<F, Zimtsternteig>(form, teig);
	}
}
