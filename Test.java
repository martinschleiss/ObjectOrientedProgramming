import java.lang.reflect.Method;
@Gruppenmitglied("Martin")
public class Test {

	public static void main(String[] args) throws ClassNotFoundException {

		Bauernhof b = new Bauernhof("Hof");
		Liste liste=new Liste();
		liste.add(b);
		System.out.println("Drei Bauernhoefe erstellen.....");
		for(int i=1;i<4;i++){
			liste.add(new Bauernhof("Hof"+i));
		}
		System.out.println("\n6 Traktoren mit Erweiterung erstellen.....");
		Traktor t1 = new TraktorMitBiogasMotor();
		Traktor t2 = new TraktorMitDieselMotor();
		Traktor t3 = new TraktorMitDieselMotor();
		Traktor t4 = new TraktorMitDieselMotor();
		Traktor t5 = new TraktorMitBiogasMotor();
		Traktor t6 = new TraktorMitBiogasMotor();

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

		Bauernhof b1=liste.getBauernhof("Hof1");
		System.out.println(b1);

		System.out.println("\nTraktoren in Hof1, Hof2 und Hof3 hinzufuegen.....");
		b1.addTraktor(t1);
		b1.addTraktor(t2);
		b1.addTraktor(t3);
		b1.addTraktor(t4);
		b1.addTraktor(t5);
		b1.addTraktor(t6);

		Bauernhof b2=liste.getBauernhof("Hof2");
		b2.addTraktor(t1);
		b2.addTraktor(t2);
		b2.addTraktor(t3);
		b2.addTraktor(t4);
		b2.addTraktor(t5);
		b2.addTraktor(t6);

		Bauernhof b3=liste.getBauernhof("Hof3");
		b3.addTraktor(t1);
		b3.addTraktor(t2);
		b3.addTraktor(t3);
		b3.addTraktor(t4);
		b3.addTraktor(t5);
		b3.addTraktor(t6);

		System.out.println("\nVon Hof1 Traktor mit der Seriennummer 3 ausgeben: \n"+liste.getBauernhof("Hof1").getTraktor(3));
		System.out.println("\nVon Hof3 Traktor mit der Seriennummer 5 ausgeben: \n"+liste.getBauernhof("Hof3").getTraktor(5));
		System.out.println("\nAlle Traktoren von Hof 2 ausgeben:");
		Bauernhof b2Test=liste.getBauernhof("Hof2");
		Iterator lis=b2Test.iterator();

		while(lis.hasNext()){
			Traktor t=(Traktor)lis.next();
			System.out.println(t);
		}
		b2Test.removeTraktor(b2Test.getTraktor(0));
		b2Test.removeTraktor(b2Test.getTraktor(1));
		b2Test.removeTraktor(b2Test.getTraktor(2));

		System.out.println("\nTraktoren 0,1 und 2 von Hof 2 entfernen....");
		System.out.println("\nAlle Traktoren von Hof 2 nach Aenderung ausgeben:");
		Iterator lis1=b2Test.iterator();

		while(lis1.hasNext()){
			Traktor t=(Traktor)lis1.next();
			System.out.println(t);
		}
		System.out.println("\nVom Hof2, die Betriebsstunden von Traktor3 um 11 stunden erhoehen und ausgeben...");
		b2Test.erhoeheBetriebsstunden(b2Test.getTraktor(3), 11);

		Iterator lis2=b2Test.iterator();

		while(lis2.hasNext()){
			Traktor t=(Traktor)lis2.next();
			System.out.println(t);
		}
		System.out.println("\nBetriebsstunden und Verbrauch der Traktoren von Hof1 geaendert... ");

		Bauernhof b11=liste.getBauernhof("Hof1");
		b11.erhoeheBetriebsstunden(b11.getTraktor(0), 4);
		b11.erhoeheBetriebsstunden(b11.getTraktor(1), 6);
		b11.erhoeheBetriebsstunden(b11.getTraktor(2), 9);
		b11.erhoeheBetriebsstunden(b11.getTraktor(3), 12);
		b11.erhoeheBetriebsstunden(b11.getTraktor(4), 3);
		b11.erhoeheBetriebsstunden(b11.getTraktor(5), 7);

		b11.setBiogasVerbrauch(b11.getTraktor(0), 89);
		b11.setBiogasVerbrauch(b11.getTraktor(4), 70);
		b11.setBiogasVerbrauch(b11.getTraktor(5), 139);

		b11.setDieselVerbrauch(b11.getTraktor(1), 200);
		b11.setDieselVerbrauch(b11.getTraktor(2), 220);
		b11.setDieselVerbrauch(b11.getTraktor(3), 180);

		Iterator lis3=b11.iterator();

		while(lis3.hasNext()){
			Traktor t=(Traktor)lis3.next();
			System.out.println(t);
		}
		/*
		System.out.println("\nStatistiken ausgeben: ");
		System.out.println(b11.durchschnittArbeitstundenNachErweiterung(new TraktorErweiterungDrillmaschine(10)));
		System.out.println("Durchschnittliche Arbeitsstunden nach Motorart(Biogasmotor): "+b11.durchschnittArbeitstundenNachMotorart(new TraktorMitBiogasMotor()));
		System.out.println(b11.durchschnittDieselverbrauchNachErweiterung(new TraktorErweiterungDuengestreuer(500)));
		System.out.println(b11.durchschnittGasverbrauchNachErweiterung(new TraktorErweiterungDuengestreuer(500)));
		System.out.println(b11.anzahlMinMaxSaeschare(new TraktorMitBiogasMotor()));
		System.out.println(b11.durchschnittFassungsVermoegen(new TraktorMitDieselMotor()));




		System.out.println("\nBetriebsstunden und Verbrauch der Traktoren von Hof3 geaendert... ");

		Bauernhof b33=liste.getBauernhof("Hof3");

		b33.erhoeheBetriebsstunden(b33.getTraktor(0), 23);
		b33.erhoeheBetriebsstunden(b33.getTraktor(1), 5);
		b33.erhoeheBetriebsstunden(b33.getTraktor(2), 1);
		b33.erhoeheBetriebsstunden(b33.getTraktor(3), 13);
		b33.erhoeheBetriebsstunden(b33.getTraktor(4), 5);
		b33.erhoeheBetriebsstunden(b33.getTraktor(5), 9);

		b33.setBiogasVerbrauch(b33.getTraktor(0), 44);
		b33.setBiogasVerbrauch(b33.getTraktor(4), 76);
		b33.setBiogasVerbrauch(b33.getTraktor(5), 12);

		b33.setDieselVerbrauch(b33.getTraktor(1), 100);
		b33.setDieselVerbrauch(b33.getTraktor(2), 120);
		b33.setDieselVerbrauch(b33.getTraktor(3), 150);

		Iterator lis4=b33.iterator();

		while(lis4.hasNext()){
			Traktor t=(Traktor)lis4.next();
			System.out.println(t);
		}

		System.out.println("\nStatistiken ausgeben: ");
		System.out.println(b33.durchschnittArbeitstundenNachErweiterung(new TraktorErweiterungDrillmaschine(10)));
		System.out.println("Durchschnittliche Arbeitsstunden nach Motorart(Biogasmotor): "+b33.durchschnittArbeitstundenNachMotorart(new TraktorMitBiogasMotor()));
		System.out.println(b33.durchschnittDieselverbrauchNachErweiterung(new TraktorErweiterungDuengestreuer(500)));
		System.out.println(b33.durchschnittGasverbrauchNachErweiterung(new TraktorErweiterungDuengestreuer(500)));
		System.out.println(b33.anzahlMinMaxSaeschare(new TraktorMitBiogasMotor()));
		System.out.println(b33.durchschnittFassungsVermoegen(new TraktorMitDieselMotor()));
		System.out.println("\n");

		 */

		/**
		 * ++++++++++++++++++++ Ausgabe der Annotationen ++++++++++++++++++++
		 */

		/**
		 * Annotationen der Klassen & Methoden: (Durch fehlende Generizitaet nur unelegant, um keine Warnungen zu bekommen):
		 */
		
		System.out.println("\n\n\n");
			
		Gruppenmitglied g = Bauernhof.class.getAnnotation(Gruppenmitglied.class);
		Method[] methods = Bauernhof.class.getMethods();
		
		
		
		if (g != null) {

			System.out.println("Klasse: " + Bauernhof.class + ", Gruppenmitglied: " + g.value());
		} else {

			System.out.println("Klasse: " + Bauernhof.class + ", Gruppenmitglied: Nicht angegeben");
		}
		print(methods);
		
		
		
		g = Iterator.class.getAnnotation(Gruppenmitglied.class);
		if (g != null) {

			System.out.println("Klasse: " + Iterator.class + ", Gruppenmitglied: " + g.value());
		} else {

			System.out.println("Klasse: " + Iterator.class + ", Gruppenmitglied: Nicht angegeben");
		}
		methods = Iterator.class.getMethods();
		print(methods);
		
		
		
		g = Liste.class.getAnnotation(Gruppenmitglied.class);
		if (g != null) {

			System.out.println("Klasse: " + Liste.class + ", Gruppenmitglied: " + g.value());
		} else {

			System.out.println("Klasse: " + Liste.class + ", Gruppenmitglied: Nicht angegeben");
		}
		methods = Liste.class.getMethods();
		print(methods);
		
		
		
		
		g = Test.class.getAnnotation(Gruppenmitglied.class);
		if (g != null) {

			System.out.println("Klasse: " + Test.class + ", Gruppenmitglied: " + g.value());
		} else {

			System.out.println("Klasse: " + Test.class + ", Gruppenmitglied: Nicht angegeben");
		}
		methods = Test.class.getMethods();
		print(methods);
		
		
		
		g = Traktor.class.getAnnotation(Gruppenmitglied.class);
		if (g != null) {

			System.out.println("Klasse: " + Traktor.class + ", Gruppenmitglied: " + g.value());
		} else {

			System.out.println("Klasse: " + Traktor.class + ", Gruppenmitglied: Nicht angegeben");
		}
		methods = Traktor.class.getMethods();
		print(methods);
	}

	/**
	 * Ausgabe von Methoden-Annotationen
	 */
	private static void print(Method[] methods) {

		Gruppenmitglied g;

		System.out.println("\nMethoden der Klasse:\n");
		for (int i = 0; i < methods.length; i++) {

			g = methods[i].getAnnotation(Gruppenmitglied.class);

			if (g != null) {

				System.out.println("Methode: " + methods[i] + ",\tGruppenmitglied: " + g.value());

			} else {

				System.out.println("Methode: " + methods[i] + ",\tGruppenmitglied: Nicht angegeben");
			}
		}
		System.out.println("\n\n\n");
	}
}