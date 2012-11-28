import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	
	public static void main(String args[]) {

		AndroidFactory f = new AndroidFactory();
		Shop sh=new Shop();
		
		System.out.println("Entwickle Bauarbeiter mit passenden Software, Sicherheitstufe 3,Kit3kW und hochfesten Skin");
		
		Androide a = new Bauarbeiter();
		
		/*Komponente k1 = new Aktor("Greifarm",1,a);
		Komponente k2 = new Sensor("Gyroskop",a);*/
		
		Sicherheitsstufe s = new SicherheitsstufeDrei();
		Software software1 = new SoftwareBauarbeiter(a,s);
		Skin skin = new SkinHochfest(a);
		Kit kit=new Kit3kW("Greifarm",a);
		f.create(a, kit, skin, software1);
		
		
		System.out.println("Ergebnis: "+sh.insert(a)+"\n");
	
		System.out.println("Software auf Kaempfer geaendert:");
		
		Software software2 = new SoftwareKaempfer(a,s);
		
		a.installSoftware(software2);
		
		System.out.println("Ergebnis: "+sh.insert(a)+"\n");
		
		System.out.println("Entwickle Gesellschafter mit passenden Software, Sicherheitstufe 1, Kit1kW und Senstitiven Skin");
		
		Androide b=new Gesellschafter();
		
		Sicherheitsstufe s3 = new SicherheitsstufeEins();
		Software software3 = new SoftwareGesellschafter(b,s3);
		Skin skin3 = new SkinSensitiv(b);
		Kit kit1=new Kit1kW("Greifarm",a);
	
		f.create(b, kit1, skin3, software3);
		System.out.println("Ergebnis: "+sh.insert(b)+"\n");
		
		System.out.println("Skin auf Gepanzert geaendert:");
		Skin skin4 = new SkinGepanzert(b);
	    b.installSkin(skin4);
		System.out.println("Ergebnis: "+sh.insert(b)+"\n");
	
		
		System.out.println("Entwickle Kaempfer mit passenden Software, Sicherheitstufe 5, Kit21kW und Gepanzerter Skin");
		
		
		Androide ka=new Kaempfer();
		Sicherheitsstufe s4 = new SicherheitsstufeFuenf();
		Software software4 = new SoftwareKaempfer(ka,s4);
		Skin skin5 = new SkinGepanzert(ka);
		Kit kit4=new Kit21kW("Greifarm",ka);
	
		f.create(ka, kit4, skin5, software4);
		System.out.println("Ergebnis: "+sh.insert(ka)+"\n");
		//System.out.println(sh.find(ka.seriennummer()));
		
		
		
		System.out.println("Entwickle Leibwaechter mit passenden Software, Sicherheitstufe 4, Kit21kW und Gepanzerter Skin");
		Androide le=new Leibwaechter();
		Sicherheitsstufe s5 = new SicherheitsstufeVier();
		Software software5 = new SoftwareLeibwaechter(le,s5);
		Skin skin6 = new SkinGepanzert(le);
		Kit kit5=new Kit21kW("Greifarm",le);
		f.create(le, kit5, skin6,software5);
		System.out.println("Ergebnis: "+sh.insert(le)+"\n");
		
		System.out.println("Android mit der Seriennummer 3 ausgeben: ");
		System.out.println(sh.find(ka.seriennummer()));
		
		
		System.out.println("-----------------------------------------------------------");
		
		System.out.println("Alle zum Verkauf moeglichen Androiden (ueber Iterator) :");
		
		Iterator<Androide> i=sh.iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}
}