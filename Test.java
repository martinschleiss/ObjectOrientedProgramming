import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
public class Test {

	public static void main(String [] args) {
		
		System.out.println("Initialisiere Fahrbahnen und Strategien...");
		Random generator = new Random();
		Fahrbahn f1 = new Fahrbahn(10,10);
		Fahrbahn f2 = new Fahrbahn(50,50);
		Fahrbahn f3 = new Fahrbahn (100,100);
		
		Strategie random = new StrategieRandom();
		Strategie snake = new StrategieSchlangenLinien();

		ArrayList<Point> startpunkte = new ArrayList<Point>();
		ArrayList<Auto> autos = new ArrayList<Auto>();

		System.out.println("#################### Test 1: ####################");
		System.out.println("Feld: 10 x 10");
		System.out.println("Autos: 5 Bewegliche, 5 Schnelle - alle mit Random-Strategie");
		System.out.println("Initialisiere Fahrbahnen und Strategien...");
		for (int i = 0; i < 10; i++) {

			startpunkte.add(new Point(generator.nextInt(10),generator.nextInt(10)));
			System.out.println("Neuer Startpunkt: " + startpunkte.get(i));
		}

		for (int i = 0; i < 5; i++) {

			autos.add(new AutoBeweglich(f1,f1.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random));
		}

		for (int i = 5; i < 10; i++) {

			autos.add(new AutoSchnell(f1,f1.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random));
		}

		for (int i = 0; i < autos.size(); i++) {

			f1.autoZuFahrbahnHinzufuegen(autos.get(i));
		}

		f1.spawnAlleAutos();
		System.out.println(f1.ergebnisse());
		int counter=0;

		for(Auto i : autos) {		
			System.out.println("Auto "+counter+": Schritte: "+i.getSchritte()+" Punkte: " +i.getPunkte());
			counter++;
		}
	}	
}