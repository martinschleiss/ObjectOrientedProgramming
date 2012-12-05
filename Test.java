import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
public class Test {

	public static void main(String [] args) {

		/*Fahrbahn f = new Fahrbahn(10, 10);
		ArrayList<Auto<? extends Strategie>> testAutos = new ArrayList<Auto<? extends Strategie>>();

		for(int i = 0; i < 2; i++) {
			StrategieRandom sr = new StrategieRandom(Strategie.ausrichtung.NORD);
			Auto<StrategieRandom> a = new AutoSchnell<StrategieRandom>(f.feldAnPosition(new Point(0, 0)), sr, f);
			testAutos.add(a);
			f.autoZuFahrbahnHinzufuegen(a, new Point((int)Math.random() * 10,(int)Math.random() * 10));
		}
		for(int i = 0; i < 2; i++) {
			StrategieSchlangenLinien ss = new StrategieSchlangenLinien(Strategie.ausrichtung.SUED);
			Auto<StrategieSchlangenLinien> b = new AutoBeweglich<StrategieSchlangenLinien>(f.feldAnPosition(new Point(0, 0)), ss, f);
			testAutos.add(b);
			f.autoZuFahrbahnHinzufuegen(b, new Point((int)Math.random() * 10,(int)Math.random() * 10));
		}
		for(int i = 0; i < 2; i++) {
			StrategieLinkeWandEntlang slw = new StrategieLinkeWandEntlang(Strategie.ausrichtung.OST);
			Auto<StrategieLinkeWandEntlang> c = new AutoBeweglich<StrategieLinkeWandEntlang>(f.feldAnPosition(new Point(0, 0)), slw, f);
			testAutos.add(c);
			f.autoZuFahrbahnHinzufuegen(c, new Point((int)Math.random() * 10,(int)Math.random() * 10));
		}

		f.spawnAlleAutos();
		System.out.println(f.ergebnisse());
		int counter=0;
		for(Auto<? extends Strategie> i : testAutos) {		
			System.out.println("Auto "+counter+": Schritte: "+i.getSchritte()+" Punkte: " +i.getPunkte());
			counter++;
		}*/
		
		Random generator = new Random();
		Fahrbahn f = new Fahrbahn(10, 10);

		Strategie random = new StrategieRandom();
		//Strategie snake = new StrategieSchlangenLinien();

		ArrayList<Point> startpunkte = new ArrayList<Point>();
		ArrayList<Auto> autos = new ArrayList<Auto>();

		for (int i = 0; i < 10; i++) {

			startpunkte.add(new Point(generator.nextInt(10),generator.nextInt(10)));
			System.out.println("Neuer Startpunkt: " + startpunkte.get(i));
		}

		for (int i = 0; i < 5; i++) {

			autos.add(new AutoBeweglich(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random));
		}

		for (int i = 5; i < 10; i++) {

			autos.add(new AutoBeweglich(f,f.feldAnPosition(startpunkte.get(i)),Auto.ausrichtung.N,random));
		}

		for (int i = 0; i < autos.size(); i++) {

			f.autoZuFahrbahnHinzufuegen(autos.get(i));
		}

		f.spawnAlleAutos();
		System.out.println(f.ergebnisse());

	}	
}