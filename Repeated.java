import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Repeated<P> implements Pict{

	private	P[][] array;
	private int width;
	private int height;
	private String picture;
	private boolean check; 

	/**
	 * (height*width) == list.size();
	 */
	public Repeated(ArrayList<P> list, int height, int width) throws InputMismatchException {
		
		if ( height*width != list.size() ) {
			
			throw new InputMismatchException("Groesse stimmt nicht mit Anzahl der Elemente ueberein");
		}
		
		this.height=height;
		this.width=width;
		this.check=false;

		array=(P[][]) new Object[height][width]; 
		int counter=0;
		for(int t=0;t<height;t++){
			for(int u=0;u<width;u++){
				array[t][u]=list.get(counter);
				counter ++;

			}
		}
	}

	public void scale(double factor){


		Scanner scan = new Scanner(createPicture());
		String content = scan.nextLine();
		content =content +"\n";
		double br = content.length();
		double hei=1;
		while (scan.hasNextLine()) {
			content += scan.nextLine()+"\n";
			hei++;
		}
		int h=(int)hei;
		Scanner scan1 = new Scanner(createPicture());
		String [] ar=new String[h];
		int i=0;
		while (scan1.hasNextLine()) {
			ar[i]=scan1.nextLine();
			i++;
		}
		int height=(int) hei;
		int width=(int)br;
		String output="";
		br *=factor;
		hei *=factor;
		int prH = (int) Math.round(hei + .49);
		int prW = (int) Math.round(br + .49);
		if(factor>1){
			for(int k=0;k<h;k++){
				String zw=ar[k];
				ar[k] +=zw.substring(0,prW-width-1);
			}
			for(int k=0;k<h;k++){
				output +=ar[k]+"\n";
			}
			for(int k=0;k<(prH-height);k++){
				output +=ar[k]+"\n";
			}
		}else if(factor<1){
			for(int k=0;k<h;k++){
				String zw=ar[k];
				ar[k] =zw.substring(0,prW-1);
			}
			for(int k=0;k<prH+2;k++){
				output +=ar[k]+"\n";
			}
		}
		picture=output;
		check=true;
		
	}
	private String createPicture(){
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
		
		if(check){
			ausgabe=picture;
		}else{
			ausgabe=createPicture();
		}
		
		return ausgabe;

	}
}
