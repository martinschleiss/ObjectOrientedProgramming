public class Test {
	
	public static void main(String[] args) {
		
		Bauernhof b = new Bauernhof("Hof");
		
		Traktor t1 = new TraktorMitDieselMotor();
		Traktor t2 = new TraktorMitDieselMotor();
		Traktor t3 = new TraktorMitDieselMotor();
		Traktor t4 = new TraktorMitBiogasMotor();
		Traktor t5 = new TraktorMitBiogasMotor();
		Traktor t6 = new TraktorMitBiogasMotor();
		
		b.addTraktor(t1);
		System.out.println(b.containsTraktor(t1));//true
		System.out.println(b.containsTraktor(t2));//false
		b.removeTraktor(t1);
		System.out.println(b.containsTraktor(t1));//false
		
		TraktorErweiterung tErDrill1=new TraktorErweiterungDrillmaschine(300);
		TraktorErweiterung tErStreuer1=new TraktorErweiterungDuengestreuer(750.0);
		TraktorErweiterung tErDrill2=new TraktorErweiterungDrillmaschine(400);
		TraktorErweiterung tErStreuer2=new TraktorErweiterungDuengestreuer(500.5);
		
		t1.setzeTraktorErweiterung(tErStreuer1);
		t2.setzeTraktorErweiterung(tErStreuer1);
		t3.setzeTraktorErweiterung(tErDrill1);
		t4.setzeTraktorErweiterung(tErDrill2);
		t5.setzeTraktorErweiterung(tErStreuer2);
		t6.setzeTraktorErweiterung(tErDrill2);
		
		
		
		b.addTraktor(t1);
		b.addTraktor(t2);
		b.addTraktor(t3);
		b.addTraktor(t4);
		b.addTraktor(t5);
		b.addTraktor(t6);
		
		TraktorIterator it = b.iterator();
		
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}
		System.out.println(b.durchschnittArbeitstundenNachErweiterung(new TraktorErweiterungDrillmaschine(10)));
		System.out.println(b.durchschnittArbeitstundenNachMotorart(new TraktorMitBiogasMotor()));
		
	}
}