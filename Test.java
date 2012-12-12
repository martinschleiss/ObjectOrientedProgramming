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