public class Test {

	public static void main(String[] args) {

		Bestellung b=new Bestellung();
		
		b.addKeks(5, new WeihnachtsmanForm(), new Muerbteig());
		b.addKeks(6, new MondForm(), new Schokoladenteig());
		b.addKeks(9, new MondForm(), new Zimtsternteig());
		b.addKeks(14, new WeihnachtsmanForm(), new Muerbteig(),new FuellungSchokolade());
		b.addKeks(19, new WeihnachtsmanForm(), new Muerbteig(),new FuellungMarmelade());
		System.out.println("Bestellung 1:");
		System.out.println(b.drucke());
		
		
		Baeckerei back=new Baeckerei();
		Keksdose kdose=back.setBestellung(b);
		System.out.println("\nKeksdose1:");
		
		kdose.inhalt();
		
		Bestellung b1=new Bestellung();
		
		b1.addKeks(6, new WeihnachtsmanForm(), new Muerbteig());
		b1.addKeks(8, new RundForm(), new Schokoladenteig());
		b1.addKeks(12, new MondForm(), new Zimtsternteig());
		b1.addKeks(3, new MondForm(), new Muerbteig());
		b1.addKeks(34, new WeihnachtsmanForm(), new Schokoladenteig());
		b1.addKeks(2, new RundForm(), new Zimtsternteig());
		b1.addKeks(14, new WeihnachtsmanForm(), new Zimtsternteig(),new FuellungMarmelade());
		b1.addKeks(19, new RundForm(), new Schokoladenteig(),new FuellungMarmelade());
		b1.addKeks(14, new WeihnachtsmanForm(), new Schokoladenteig(),new FuellungSchokolade());
		b1.addKeks(19, new MondForm(), new Muerbteig(),new FuellungSchokolade());
		System.out.println("\nBestellung 2:");
		System.out.println(b1.drucke());
		
		
		Baeckerei back1=new Baeckerei();
		Keksdose kdose1=back1.setBestellung(b1);
		System.out.println("\nKeksdose2:");
		
		kdose1.inhalt();
		
		
	}
	
}