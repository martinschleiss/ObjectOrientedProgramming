public class Test {

	public static void main(String[] args) {
		
		System.out.println("Bestellung 1: ");
		Bestellung b1 = new Bestellung();
		Baeckerei backstube = new Baeckerei();
		
		WunschTeig t1 = new WunschTeigMuerb();
		WunschTeig t2 = new WunschTeigSchokolade();
		WunschTeig t3 = new WunschTeigZimtstern();
		
		
		WunschForm f1 = new WunschFormRund();
		WunschForm f2 = new WunschFormWeihnachtsmann();
		WunschForm f3 = new WunschFormMond();
		
		WunschFuellung fl1=new WunschFuellungMarmelade();
		WunschFuellung fl2=new WunschFuellungMarmelade();
		
		
		b1.addPositionKeks(10, t1, f1);
		b1.addPositionKeks(5, t2, f2);
		b1.addPositionKeks(10, t3, f3);
		b1.addPositionKeks(5, t1, f2);
		b1.addPositionKeks(10, t2, f3);
		b1.addPositionKeks(5, t3, f1);
		
		b1.addPositionDoppelkeks(8, t1, f1, fl1);
		b1.addPositionDoppelkeks(8, t2, f2, fl2);
		b1.addPositionDoppelkeks(8, t3, f3, fl1);
		
		b1.drucke();
		backstube.addBestellung(b1);
		Keksdose d = backstube.nextBestellung();
		System.out.println("\nKeksdose zu Bestellung 1: ");
		d.inhalt();
		
		Bestellung b2 = new Bestellung();
		b2.addPositionKeks(12, t2, f1);
		b2.addPositionKeks(7, t3, f2);
		b2.addPositionKeks(10, t1, f3);
		
		b2.addPositionDoppelkeks(9, t3, f1, fl2);
		b2.addPositionDoppelkeks(6, t1, f2, fl1);
		b2.addPositionDoppelkeks(7, t2, f3, fl2);
		
		System.out.println("\nBestellung 2: ");
		b2.drucke();
		backstube.addBestellung(b2);
		Keksdose d1 = backstube.nextBestellung();
		System.out.println("\nKeksdose zu Bestellung 2: ");
		d1.inhalt();
		
		Bestellung b3 = new Bestellung();
		b3.addPositionKeks(5, t1, f2);
		b3.addPositionKeks(9, t3, f3);
		b3.addPositionKeks(11, t2, f1);
		
		b3.addPositionDoppelkeks(3, t2, f2, fl2);
		b3.addPositionDoppelkeks(6, t3, f3, fl1);
		b3.addPositionDoppelkeks(12, t1, f1, fl1);
		
		System.out.println("\nBestellung 3: ");
		b3.drucke();
		backstube.addBestellung(b3);
		Keksdose d2 = backstube.nextBestellung();
		System.out.println("\nKeksdose zu Bestellung 3: ");
		d2.inhalt();
		
		
		
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