import java.util.ArrayList;
import java.awt.Point;
public class Test {
	
	public static void main(String [] args) {
	
		Fahrbahn f = new Fahrbahn(400, 400);
		ArrayList<Auto<? extends Strategie>> testAutos = new ArrayList<Auto<? extends Strategie>>();
		
		for(int i = 0; i < 100; i++) {
			StrategieLinkeWandEntlang s = new StrategieLinkeWandEntlang(Strategie.ausrichtung.NORD);
			Auto<StrategieLinkeWandEntlang> a = new AutoNormal<StrategieLinkeWandEntlang>(f.feldAnPosition(new Point(0, 0)), s);
			testAutos.add(a);
			f.autoZuFahrbahnHinzufuegen(a, new Point(0,0));
		}
		
		//TODO Startcode nach Fahrbahn spawnAlleAutos() umbauen
		for(Auto<? extends Strategie> a: testAutos) {
			Thread t = new Thread(a);
			t.start();
		}
	}	
}