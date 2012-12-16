public class Test {

	public static void main(String[] args) {
		Form f=new WeihnachtsmanForm();
		Teig t=new Schokoladenteig();
		Keks<Form, Teig> keks=new Keks<Form, Teig>(f, t); 
		
		
		
	}
	
}