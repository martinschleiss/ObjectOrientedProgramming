import java.util.ArrayList;
import java.awt.Point;
public class Test {
	
	public static void main(String [] args) {
	
		Fahrbahn f = new Fahrbahn(10, 10);
		ArrayList<Auto<? extends Strategie>> testAutos = new ArrayList<Auto<? extends Strategie>>();
	
		for(int i = 0; i < 30; i++) {
			StrategieRandom sr = new StrategieRandom(Strategie.ausrichtung.NORD);
			Auto<StrategieRandom> a = new AutoSchnell<StrategieRandom>(f.feldAnPosition(new Point(0, 0)), sr, f);
			testAutos.add(a);
			f.autoZuFahrbahnHinzufuegen(a, new Point((int)Math.random() * 10,(int)Math.random() * 10));
		}
		for(int i = 0; i < 30; i++) {
			StrategieSchlangenLinien ss = new StrategieSchlangenLinien(Strategie.ausrichtung.SUED);
			Auto<StrategieSchlangenLinien> b = new AutoNormal<StrategieSchlangenLinien>(f.feldAnPosition(new Point(0, 0)), ss, f);
			testAutos.add(b);
			f.autoZuFahrbahnHinzufuegen(b, new Point((int)Math.random() * 10,(int)Math.random() * 10));
		}
		for(int i = 0; i < 30; i++) {
			StrategieLinkeWandEntlang slw = new StrategieLinkeWandEntlang(Strategie.ausrichtung.OST);
			Auto<StrategieLinkeWandEntlang> c = new AutoNormal<StrategieLinkeWandEntlang>(f.feldAnPosition(new Point(0, 0)), slw, f);
			testAutos.add(c);
			f.autoZuFahrbahnHinzufuegen(c, new Point((int)Math.random() * 10,(int)Math.random() * 10));
		}
		
		f.spawnAlleAutos();
		System.out.println(f.ergebnisse());
	}	
}