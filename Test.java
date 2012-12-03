import java.util.ArrayList;
import java.awt.Point;
public class Test {
	
	public static void main(String [] args) {
	
		Fahrbahn f = new Fahrbahn(40, 40);
		ArrayList<Auto<? extends Strategie>> testAutos = new ArrayList<Auto<? extends Strategie>>();
		
		for(int i = 0; i < 10; i++) {
			StrategieRandom sr = new StrategieRandom(Strategie.ausrichtung.NORD);
			Auto<StrategieRandom> a = new AutoNormal<StrategieRandom>(f.feldAnPosition(new Point(0, 0)), sr);
			testAutos.add(a);
			f.autoZuFahrbahnHinzufuegen(a, new Point(0,0));
		}
		for(int i = 0; i < 10; i++) {
			StrategieSchlangenLinien ss = new StrategieSchlangenLinien(Strategie.ausrichtung.SUED);
			Auto<StrategieSchlangenLinien> b = new AutoNormal<StrategieSchlangenLinien>(f.feldAnPosition(new Point(0, 0)), ss);
			testAutos.add(b);
			f.autoZuFahrbahnHinzufuegen(b, new Point(0,0));
		}
		for(int i = 0; i < 10; i++) {
			StrategieLinkeWandEntlang slw = new StrategieLinkeWandEntlang(Strategie.ausrichtung.OST);
			Auto<StrategieLinkeWandEntlang> c = new AutoNormal<StrategieLinkeWandEntlang>(f.feldAnPosition(new Point(0, 0)), slw);
			testAutos.add(c);
			f.autoZuFahrbahnHinzufuegen(c, new Point(0,0));
		}
		
		//TODO Startcode nach Fahrbahn spawnAlleAutos() umbauen
		for(Auto<? extends Strategie> a: testAutos) {
			Thread t = new Thread(a);
			t.start();
		}
	}	
}