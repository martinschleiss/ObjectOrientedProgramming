import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Repeated<P> implements Pict{

	private ArrayList<P> list;
	private int width;		// > 0
	private int height;	// > 0
	private double scaleFactor = 1; // > 0
	private int boxHeight;	// > 0
	private int boxWidth;	// > 0

	/**
	 * (height*width) == list.size()
	 */
	public Repeated(ArrayList<P> list, int height, int width) throws InputMismatchException {
		
		if ( height*width != list.size() ) {
			
			throw new InputMismatchException("Groesse stimmt nicht mit Anzahl der Elemente ueberein");
		}
		
		this.height = height;
		this.width = width;
		this.list = list;
		this.boxHeight = getMaximumBoxHeight(this.list);
		this.boxWidth = getMaximumBoxWidth(this.list);
	}
	
	/**
	 * 0.1 <= factor <= 10.0; resize the picture	
	 */
	public void scale(double factor) {
		this.scaleFactor *= factor;
	}
	
	private int getMaximumBoxHeight(ArrayList<?> l) {
		int maximum = 0;
		
		for(Object elem : l) {
			int temp = 0;
			String s = elem.toString();
			Scanner scan = new Scanner(s);
			while(scan.hasNext()) {
				scan.nextLine();
				temp++;
			}
			
			if(temp > maximum) {
				maximum = temp;
			}
		}
		
		return maximum;
	}
	
	private int getMaximumBoxWidth(ArrayList<?> l) {
		int maximum = 0;
		
		for(Object elem : l) {
			String s = elem.toString();
			Scanner scan = new Scanner(s);
			String current = "";
			while(scan.hasNext()) {
				current = scan.nextLine();
				if(current.length() > maximum) {
					maximum = current.length();
				}
			}			
		}
		
		return maximum;
	}
	
	private String getStringForPictAtLine(Object p, int line) {
		String value = "";
		Scanner scan = new Scanner (p.toString());
		int count = 0;
		while(scan.hasNext()) {
			value = scan.nextLine();
			if(line == count) {
				break;
			}
			count++;
		}
		
		if(value.equals("")) {
			for(int i = 0; i < boxWidth; i++) {
				value += " ";
			}
		} else {
			while(value.length() < boxWidth) {
				value += " ";
			}
		}
		
		return value;
	}
	
    // returns the picture as String
	
	
	//TODO Methode funktioniert noch nicht fuer Freebox, liefert ewig lange wurst, zeilen werden wiederholt ausgegeben.
	//und liefert boxes doppelt untereinander
	
	
	public String toString() {
		String s = "";
		
		for(int h = 0; h < height * scaleFactor; h++) {		
			
			for(int w = 0; w < width * scaleFactor; w++) {	
				
				for(int bh = 0; bh < boxHeight; bh++ ) {
					
					for(int box = 0; box < width * scaleFactor; box++) {
						s += getStringForPictAtLine(list.get(box % width + h % height), bh);
					}		
					if(!(h == height - 1 && w == width - 1 && bh == boxHeight -1 )) {
<<<<<<< HEAD
						s+= "\n";
=======
						s += "\n";
>>>>>>> 92704ab54e0d89afbbd929d29f4ae685216e2bb4
					}
				}				
			}			
		}
		
		return s;
	}
<<<<<<< HEAD
//TODO: Loeschen, wenn nicht mehr gebraucht.
	/*
	private String help(){

		String aus;
		int h=0;
		int b=1;

		for(int t=0;t<height;t++){
			for(int u=0;u<width;u++){
				aus=array[t][u].toString();
				int z=aus.indexOf("\n");
				int r=aus.lastIndexOf("\n");
				if(z>b){
					b=z;
				}
				if(r>h){
					h=r;
				}
			}
		}
		h=h/b;
		String [] subString= new String[h];
		for(int q=0;q<h;q++){
			subString[q]="";
		}
		String ausgabe="";
		int help=0;
		for(int t=0;t<height;t++){
			for(int u=0;u<width;u++){
				String objOut=array[t][u].toString();
				int z=objOut.indexOf("\n");
				int h1=objOut.lastIndexOf("\n");
				h1=h1/z;
				if(h1>=h){
					for(int r=0;r<h;r++){
						if(z<b){
							subString[r] +=objOut.substring(help,z+help )+" ";
							int safe=z;
							for(;safe<b;safe++){
								subString[r] +="-";
							}
							help=help+z+1;
						}else{
							subString[r] +=objOut.substring(help,b+help )+" ";
							help=help+1+b;
						}
					}
					help=0;
				}else{
					for(int r=0;r<h1;r++){
						if(z<b){
							subString[r] +=objOut.substring(help,z+help )+" ";
							int safe=z;
							for(;safe<b;safe++){
								subString[r] +="-";
							}
							help=help+z+1;
						}else{
							subString[r] +=objOut.substring(help,b+help )+" ";
							help=help+1+b;
						}
					}
					help=0;
					for(;h1<h;h1++){
						for(int l=0;l<b+1;l++){
							subString[h1] +="-";
						}
					}
				}
			}
			for(int w=0;w<h;w++){

				ausgabe += subString[w]+"\n";
			}
			for(int q=0;q<h;q++){
				subString[q]="";
			}
		}
		return ausgabe;
	}

	public String toString(){
		String ausgabe="";
		
	}*/
=======
>>>>>>> 92704ab54e0d89afbbd929d29f4ae685216e2bb4
}
