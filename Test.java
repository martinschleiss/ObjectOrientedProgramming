import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {

		Bauernhof b = new Bauernhof("Hof");

		Traktor t1 = new TraktorMitBiogasMotor();
		Traktor t2 = new TraktorMitDieselMotor();
		Traktor t3 = new TraktorMitDieselMotor();
		Traktor t4 = new TraktorMitDieselMotor();
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
		t3.setzeTraktorErweiterung(tErStreuer2);
		t4.setzeTraktorErweiterung(tErDrill2);
		t5.setzeTraktorErweiterung(tErDrill1);
		t6.setzeTraktorErweiterung(tErDrill2);



		b.addTraktor(t1);
		b.addTraktor(t2);
		b.addTraktor(t3);
		b.addTraktor(t4);
		b.addTraktor(t5);
		b.addTraktor(t6);

		b.erhoeheBetriebsstunden(t1, 3);
		b.erhoeheBetriebsstunden(t2, 2);
		b.erhoeheBetriebsstunden(t3, 6);
		b.erhoeheBetriebsstunden(t4, 5);
		b.erhoeheBetriebsstunden(t5, 8);
		b.erhoeheBetriebsstunden(t6, 10);

		b.setBiogasVerbrauch(t1, 10);
		b.setDieselVerbrauch(t2, 20);
		b.setDieselVerbrauch(t3, 25);
		b.setDieselVerbrauch(t4, 15);
		b.setBiogasVerbrauch(t5, 19);
		b.setBiogasVerbrauch(t6, 45);
		TraktorIterator it = b.iterator();

		while (it.hasNext()) {

			System.out.println(it.next());
		}

		System.out.println(b.durchschnittArbeitstundenNachErweiterung(new TraktorErweiterungDrillmaschine(10)));
		System.out.println(b.durchschnittArbeitstundenNachMotorart(new TraktorMitBiogasMotor()));
		System.out.println(b.durchschnittDieselverbrauchNachErweiterung(new TraktorErweiterungDuengestreuer(500)));
		System.out.println(b.durchschnittGasverbrauchNachErweiterung(new TraktorErweiterungDuengestreuer(500)));
		System.out.println(b.anzahlMinMaxSaeschare(new TraktorMitBiogasMotor()));
		System.out.println(b.durchschnittFassungsVermoegen(new TraktorMitDieselMotor()));


		
		/**
		 * ++++++++++++++++++++ Ausgabe der Annotationen ++++++++++++++++++++
		 */
		
		/**
		 * Annotationen der Klassen:
		 */

		//TODO: Mit allen Klassen - erst am Ende
		
		Gruppenmitglied g = Bauernhof.class.getAnnotation(Gruppenmitglied.class);
		if (g != null) {
			
			System.out.println("Klasse: " + Bauernhof.class + ", Annotation: " + g.value());
		} else {
			
			System.out.println("Klasse: " + Bauernhof.class + ", Annotation: null");
		}
		
		/**
		 * Annotationen der Methoden:
		 */
		
		//TODO: Mit den Methoden aller Klassen - erst am Ende
		
		Method[] methods = Bauernhof.class.getMethods();
		
		for (int i = 0; i < methods.length; i++) {
			
			g = methods[i].getAnnotation(Gruppenmitglied.class);
			
			if (g != null) {
				
				System.out.println("Methode: " + methods[i] + ",\tAnnotation: " + g.value());
				
			} else {
				
				System.out.println("Methode: " + methods[i] + ",\tAnnotation: null");
			}
		}
	}

}