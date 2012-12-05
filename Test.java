import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
public class Test {

	public static void main(String [] args) {
		
		System.out.println("Initialisiere Fahrbahnen und Strategien...");
		System.out.println("Stopp jeweils bei entweder 10 Punkten oder 100 Schritten...");
		Random generator = new Random();
		int rand;
		Fahrbahn f = new Fahrbahn(5,5);
		
		Strategie random = new StrategieRandom();
		Strategie snake = new StrategieSchlangenLinien();

		ArrayList<Point> startpunkte = new ArrayList<Point>();
		ArrayList<Auto> autos = new ArrayList<Auto>();

		System.out.println("#################### Test 1: ####################");
		System.out.println("Feld: 5 x 5");
		System.out.println("Autos: 3 Bewegliche (Wartezeit: 20ms), 1 Schnelles (Wartezeit: 10ms) - alle mit Random-Strategie");
		System.out.println("Erzeuge zufaellige Startpunkte...");
		for (int i = 0; i < 4; i++) {

			startpunkte.add(new Point(generator.nextInt(5),generator.nextInt(5)));
		}
		for (int i = 0; i < 3; i++) {

			autos.add(new AutoBeweglich(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random,20));
		}
		for (int i = 3; i < 4; i++) {

			autos.add(new AutoSchnell(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.O,random,10));

		}
		for (int i = 0; i < autos.size(); i++) {

			f.autoZuFahrbahnHinzufuegen(autos.get(i));
		}
		System.out.println("Starte...");
		f.spawnAlleAutos();
		System.out.println("Ergebnisse:\n" + f.ergebnisse());
		
		
		
		System.out.println("#################### Test 2: ####################");
		System.out.println("Feld: 10 x 10");
		System.out.println("Autos: 10 Bewegliche (Wartezeit: 15ms), 10 Schnelles (Wartezeit: 7ms) - alle mit Schlangenlinien-Strategie");
		System.out.println("Erzeuge zufaellige Startpunkte...");
		
		f = new Fahrbahn(10,10);
		startpunkte.clear();
		autos.clear();
		
		for (int i = 0; i < 20; i++) {

			startpunkte.add(new Point(generator.nextInt(10),generator.nextInt(10)));
		}
		for (int i = 0; i < 10; i++) {

			autos.add(new AutoBeweglich(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,snake,15));
		}
		for (int i = 20; i < 20; i++) {

			autos.add(new AutoSchnell(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.O,snake,7));
		}
		for (int i = 0; i < autos.size(); i++) {

			f.autoZuFahrbahnHinzufuegen(autos.get(i));
		}
		System.out.println("Starte...");
		f.spawnAlleAutos();
		System.out.println("Ergebnisse:\n" + f.ergebnisse());
		
		
		
		System.out.println("#################### Test 3: ####################");
		System.out.println("Feld: 25 x 25");
		System.out.println("Autos: 5 Bewegliche (Wartezeit: 10ms), 45 Schnelle (Wartezeit: 5ms)");
		System.out.println("Strategie: Bewegliche: Schlangenlinien, Schnelle: Random");
		System.out.println("Initialisiere Fahrbahnen und Strategien...");
		
		f = new Fahrbahn(25,25);
		startpunkte.clear();
		autos.clear();
		
		for (int i = 0; i < 50; i++) {

			startpunkte.add(new Point(generator.nextInt(25),generator.nextInt(25)));
		}
		for (int i = 0; i < 5; i++) {

			autos.add(new AutoBeweglich(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,snake,10));
		}

		for (int i = 5; i < 50; i++) {

			autos.add(new AutoSchnell(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random,5));

		}

		for (int i = 0; i < autos.size(); i++) {

			f.autoZuFahrbahnHinzufuegen(autos.get(i));
		}
		System.out.println("Starte...");
		f.spawnAlleAutos();
		System.out.println("Ergebnisse:\n" + f.ergebnisse());

		
		
		System.out.println("#################### Test 4: ####################");
		System.out.println("Feld: 50 x 50");
		System.out.println("Autos: 50 Bewegliche (Wartezeit: 7ms), 50 Schnelle (Wartezeit: 3ms)");
		System.out.println("Strategie: Durch Zufall gewaehlte Strategie (Schlangenlinien oder Random) fuer jedes Auto");
		System.out.println("Initialisiere Fahrbahnen und Strategien...");
		
		f = new Fahrbahn(50,50);
		startpunkte.clear();
		autos.clear();
		
		for (int i = 0; i < 100; i++) {
			
			startpunkte.add(new Point(generator.nextInt(50),generator.nextInt(50)));
		}
		for (int i = 0; i < 50; i++) {

			rand = generator.nextInt(2);
			
			if (rand == 0) {
				autos.add(new AutoBeweglich(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,snake,7));
			} else {
				autos.add(new AutoBeweglich(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random,7));
			}
		}

		for (int i = 50; i < 100; i++) {

			rand = generator.nextInt(2);
			
			if (rand == 0) {
				autos.add(new AutoSchnell(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,snake,3));
			} else {
				autos.add(new AutoSchnell(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random,3));
			}

		}

		for (int i = 0; i < autos.size(); i++) {

			f.autoZuFahrbahnHinzufuegen(autos.get(i));
		}
		System.out.println("Starte...");
		f.spawnAlleAutos();
		System.out.println("Ergebnisse:\n" + f.ergebnisse());
	}	
}