import java.util.ArrayList;

public class Test {
	
	public static void main(String args[]) {

		Androide a = new Bauarbeiter();
		Komponente k1 = new Aktor("Greifarm",1,a);
		Komponente k2 = new Sensor("Gyroskop",a);

		AndroidFactory f = new AndroidFactory();
		
		Sicherheitsstufe s = new SicherheitsstufeEins();
		Software software = new SoftwareBauarbeiter(a,s);
		Skin skin = new SkinHochfest(a);
		ArrayList<Komponente> k = new ArrayList<Komponente>();
		k.add(k1);
		k.add(k2);	
		
		f.create(a, k, skin, software);
		
		Shop sh=new Shop();
		System.out.println(sh.insert(a));
		
		
		//TODO: Androiden Software Tests verfassen @Martin
	}
}