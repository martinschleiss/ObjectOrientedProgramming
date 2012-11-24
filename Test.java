public class Test {
	
	public static void main(String args[]) {

		Androide a = new Bauarbeiter();
		Komponente k1 = new Aktor("Greifarm",1,a);
		Komponente k2 = new Sensor("Gyroskop",a);
		
		System.out.println(k1);
		System.out.println(k2);
		
		//TODO: Androiden Software Tests verfassen @Martin
	}
}