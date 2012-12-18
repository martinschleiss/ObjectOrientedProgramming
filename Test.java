public class Test {

	public static void main(String[] args) {
		
		Bestellung b = new Bestellung();
		Baeckerei backstube = new Baeckerei();
		
		WunschTeig t = new WunschTeigMuerb();
		WunschForm f = new WunschFormRund();
		
		
		
		b.addPositionKeks(10, t, f);
		b.addPositionKeks(10, t, f);
		
		b.drucke();
		backstube.addBestellung(b);
		Keksdose d = backstube.nextBestellung();
		d.inhalt();
		
		
		
		
		/*
		Bestellung b=new Bestellung();

		b.addKeks(5, new WeihnachtsmanForm(), new MuerbTeig());
		b.addKeks(6, new MondForm(), new SchokoladenTeig());
		b.addKeks(9, new MondForm(), new ZimtsternTeig());
		b.addKeks(14, new WeihnachtsmanForm(), new MuerbTeig(),new FuellungSchokolade());
		b.addKeks(19, new WeihnachtsmanForm(), new MuerbTeig(),new FuellungMarmelade());
		System.out.println("Bestellung 1:");
		System.out.println(b.drucke());
		
		
		Baeckerei back=new Baeckerei();
		Keksdose kdose=back.setBestellung(b);
		System.out.println("\nKeksdose1:");
		
		kdose.inhalt();
		
		Bestellung b1=new Bestellung();
		
		b1.addKeks(6, new WeihnachtsmanForm(), new MuerbTeig());
		b1.addKeks(8, new FormRund(), new SchokoladenTeig());
		b1.addKeks(12, new MondForm(), new ZimtsternTeig());
		b1.addKeks(3, new MondForm(), new MuerbTeig());
		b1.addKeks(34, new WeihnachtsmanForm(), new SchokoladenTeig());
		b1.addKeks(2, new FormRund(), new ZimtsternTeig());
		b1.addKeks(14, new WeihnachtsmanForm(), new ZimtsternTeig(),new FuellungMarmelade());
		b1.addKeks(19, new FormRund(), new SchokoladenTeig(),new FuellungMarmelade());
		b1.addKeks(14, new WeihnachtsmanForm(), new SchokoladenTeig(),new FuellungSchokolade());
		b1.addKeks(19, new MondForm(), new MuerbTeig(),new FuellungSchokolade());
		System.out.println("\nBestellung 2:");
		System.out.println(b1.drucke());
		
		
		Baeckerei back1=new Baeckerei();
		Keksdose kdose1=back1.setBestellung(b1);
		System.out.println("\nKeksdose2:");
		
		kdose1.inhalt();
		
		*/
	}
	
}