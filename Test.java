public class Test {
	
	public static void main(String args[]) {

		AndroidFactory f = new AndroidFactory();
		Shop sh=new Shop();

		System.out.println("############################## Test 1.a ##############################\n");
		System.out.println("Erstelle Bauarbeiter mit Bauarbeiter-Software, Sicherheitstufe 3, einem 3kW-Kit und hochfestem Skin...\n");
		
		Androide a1 = new Bauarbeiter();
		Sicherheitsstufe s1 = new SicherheitsstufeDrei();
		Software software1 = new SoftwareBauarbeiter(a1,s1);
		Skin skin1 = new SkinHochfest(a1);
		Kit kit1 =new Kit3kW("Bauarbeiterkit",a1);
		f.create(a1, kit1, skin1, software1);
		System.out.println("Ergebnis:\n\n" + a1 +  "\n");
		
		System.out.println("\n############################## Test 1.b ##############################\n");
		System.out.println("Fuege Bauarbeiter in Shop ein... (Erwartet: Einfuegen funktioniert)\n");
		System.out.println("Ergebnis:\n\n" + sh.insert(a1) +  "\n");
		
		System.out.println("\n############################## Test 1.c ##############################\n");
		System.out.println("Aendere Software von Bauarbeiter auf Kaempfer-Software der Sicherheitsstufe 3...");
	
		software1 = new SoftwareKaempfer(a1,s1);
		a1.updateSoftware(software1);
		System.out.println("Ergebnis:\n\n" + a1 +  "\n");
		
		System.out.println("\n############################## Test 1.d ##############################\n");
		System.out.println("Fuege Bauarbeiter in Shop ein... (Erwartet: Einfuegen schlaegt fehl)\n");
		System.out.println("Ergebnis:\n\n" + sh.insert(a1) +  "\n");
			
		
		/*
		
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
		*/
	}
}