import java.lang.reflect.Method;
@Gruppenmitglied("Martin, Anil, Rafael") //auch mit String[] realisierbar
public class Test {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws ClassNotFoundException {

		int anzahlB = 20;
		int anzahlT = 100;

		Bauernhof b = new Bauernhof("Hof");
		Liste liste=new Liste();
		liste.add(b);
		System.out.println(anzahlB + " Bauernhoefe erstellen.....");
		for(int i=0;i<anzahlB;i++){
			liste.add(new Bauernhof("Hof"+i));
		}

		System.out.println("\n" + anzahlT + " Traktoren zu den Bauernhoefen hinzufuegen");

		for(int i=0; i < anzahlT; i++) {
			int j = ((int)(Math.random() * i)) % anzahlB;
			double ausmass = Math.random() * i;

			Bauernhof bauern = liste.getBauernhof("Hof"+ j);

			if(bauern != null && i % 2 == 0) {

				bauern.addTraktor(new TraktorMitBiogasMotor());
				bauern.getTraktor(i).setzeTraktorErweiterung(new TraktorErweiterungDrillmaschine((int) ausmass));
			} else if(bauern != null){
				bauern.addTraktor(new TraktorMitDieselMotor());
				bauern.getTraktor(i).setzeTraktorErweiterung(new TraktorErweiterungDuengestreuer(ausmass));
			}
		}

		System.out.println("\nEntferne Traktor i von Bauernhof x falls vorhanden");

		for(int i = 0; i < anzahlT; i++) {
			int x = ((int)(Math.random() * i)) % anzahlB;

			Bauernhof bauern = liste.getBauernhof("Hof"+x);
			if(bauern.getTraktor(i) != null) {
				bauern.removeTraktor(bauern.getTraktor(i));
				System.out.println("Traktor " + i + " entfernt");
			}
		}

		System.out.println("\nWechsle Traktorerweiterung fuer Traktor i von Bauernhof x falls vorhanden");

		for(int i = 0; i < anzahlT; i++) {
			int x = ((int)(Math.random() * i)) % anzahlB;
			double ausmass = Math.random() * i;

			Bauernhof bauern = liste.getBauernhof("Hof"+x);
			if(bauern.getTraktor(i) != null) {
				if(bauern.getTraktor(i).getErweiterung() instanceof TraktorErweiterungDrillmaschine)  {
					bauern.getTraktor(i).setzeTraktorErweiterung(new TraktorErweiterungDuengestreuer(ausmass));
					System.out.println("Traktor " + i + " nun mit TraktorErweiterungDuengestreuer");
				} else if(bauern.getTraktor(i).getErweiterung() instanceof TraktorErweiterungDuengestreuer) {
					bauern.getTraktor(i).setzeTraktorErweiterung(new TraktorErweiterungDrillmaschine((int) ausmass));
					System.out.println("Traktor " + i + " nun mit TraktorErweiterungDrillmaschine");
				}
			}
		}

		System.out.println("\nJeden Bauernhof und seine Traktoren ausgeben:\n");

		for(int i = 0; i < anzahlB; i++) {
			System.out.println("\nHof"+ i + " ausgeben: \n"+liste.getBauernhof("Hof"+i));
			Bauernhof bauern = liste.getBauernhof("Hof"+i);
			for(int j = 0; j < anzahlT; j++) {
				if(bauern.getTraktor(j) != null) {
					System.out.println("\tTraktor mit der Seriennummer " + j + " ausgeben: "+bauern.getTraktor(j));
				}
			}
		}
		
		System.out.println("========================================================================================================");
		
		Bauernhof b0 = liste.getBauernhof("Hof0");
		
		System.out.println("\nStatistiken Hof0 ausgeben:");
		System.out.println("\"keine Traktoren verfuegbar\" bedeutet: Division durch 0 verhindert.\n");
		System.out.println(b0.avgBetriebsstundenNachErweiterung());
		System.out.println("Durchschnittliche Arbeitsstunden nach Motorart(Biogasmotor): "+b0.avgBetriebsstundenNachMotorart());
		System.out.println(b0.avgDieselverbrauchNachErweiterung());
		System.out.println(b0.avgBiogasverbrauchNachErweiterung());
		System.out.println(b0.anzahlMinMaxSaeschare());
		System.out.println(b0.avgFassungsVermoegen());

		System.out.println("\nBetriebsstunden und Verbrauch der Traktoren von Hof0 geaendert... \n");
		
		Iterator traktoren = b0.iterator();

		while(traktoren.hasNext()) {
			Object o = traktoren.next();
			if(o instanceof Traktor) {
				Traktor t = (Traktor) o;
				int x = (int) (Math.random() * anzahlB);
				b0.erhoeheBetriebsstunden(t, x);
			}
		}
		
		traktoren = b0.iterator();

		while(traktoren.hasNext()) {
			Object o = traktoren.next();
			if(o instanceof Traktor) {
				Traktor t = (Traktor) o;
				if(t.serienNummer() % 2 == 0) {
					int x = (int) (Math.random() * anzahlB);
					b0.setBiogasVerbrauch(t, x);
				}
			}
		}
		
		traktoren = b0.iterator();

		while(traktoren.hasNext()) {
			Object o = traktoren.next();
			if(o instanceof Traktor) {
				Traktor t = (Traktor) o;
				if(t.serienNummer() % 2 == 1) {
					int x = (int) (Math.random() * anzahlB);
					b0.setDieselVerbrauch(t, x);
				}
			}
		}

		Iterator lis4=b0.iterator();

		while(lis4.hasNext()){
			Traktor t=(Traktor)lis4.next();
			System.out.println(t);
		}

		System.out.println("\nStatistiken ausgeben:");
		System.out.println("\"keine Traktoren verfuegbar\" bedeutet: Division durch 0 verhindert.\n");
		System.out.println(b0.avgBetriebsstundenNachErweiterung());
		System.out.println(b0.avgBetriebsstundenNachMotorart());
		System.out.println(b0.avgDieselverbrauchNachErweiterung());
		System.out.println(b0.avgBiogasverbrauchNachErweiterung());
		System.out.println(b0.anzahlMinMaxSaeschare());
		System.out.println(b0.avgFassungsVermoegen());
		System.out.println("========================================================================================================");
		
		System.out.println("\nStatistik fuer leeren Bauernhof:");
		System.out.println("\"keine Traktoren verfuegbar\" bedeutet: Division durch 0 verhindert.\n");
		
		Bauernhof bLeer = new Bauernhof("Leer");
		System.out.println("\nStatistiken ausgeben: \n");
		System.out.println(bLeer.avgBetriebsstundenNachErweiterung());
		System.out.println("Durchschnittliche Arbeitsstunden nach Motorart(Biogasmotor): "+bLeer.avgBetriebsstundenNachMotorart());
		System.out.println(bLeer.avgDieselverbrauchNachErweiterung());
		System.out.println(bLeer.avgBiogasverbrauchNachErweiterung());
		System.out.println(bLeer.anzahlMinMaxSaeschare());
		System.out.println(bLeer.avgFassungsVermoegen());
		/*

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
>>>>>>> 8a19da305f968a6e2ae804a62aefeb9fce3ef7c9



		/**
		 * ++++++++++++++++++++ Ausgabe der Annotationen ++++++++++++++++++++
		 */

		/**
		 * Annotationen der Klassen & Methoden: (Warnungen durch fehlende Generizitaet mit Annotationen unterdrueckt):
		 */

		System.out.println("\n\nAusgabe der Annotationen fuer Klassen und Methoden:\n");
		Liste annoList = new Liste();

		annoList.add(Bauernhof.class);
		annoList.add(Iterator.class);
		annoList.add(Liste.class);
		annoList.add(Test.class);
		annoList.add(Traktor.class);
		annoList.add(TraktorErweiterung.class);
		annoList.add(TraktorErweiterungDrillmaschine.class);
		annoList.add(TraktorErweiterungDuengestreuer.class);
		annoList.add(TraktorMitBiogasMotor.class);
		annoList.add(TraktorMitDieselMotor.class);

		Iterator annoIt = annoList.iterator();
		Object o;
		Gruppenmitglied g;
		Class c;
		Method[] methods;

		while(annoIt.hasNext()) {

			o = annoIt.next();

			if (o instanceof Class) {

				c = (Class) o;
				g = (Gruppenmitglied) c.getAnnotation(Gruppenmitglied.class);
				methods = c.getMethods();
				print(c.getName(),g);
				print(methods);
			}

		}
	}

	/**
	 * Ausgabe von Klassen-Annotationen
	 */
	@Gruppenmitglied("Rafael")
	private static void print(String s, Gruppenmitglied g) {

		if (g != null) {

			System.out.println("Klasse: " + s + ", Gruppenmitglied: " + g.value() + "\n");

		} else {

			System.out.println("Klasse: " + s + ", Gruppenmitglied: Nicht angegeben\n");
		}
	}

	/**
	 * Ausgabe von Methoden-Annotationen
	 */
	@Gruppenmitglied("Rafael")
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
		System.out.println("\n========================================================================================================\n");
	}
}