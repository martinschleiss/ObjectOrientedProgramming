import java.util.ArrayList;

public class Repeated<P>{

	private	P[][] array;
	private int width;
	private int height;

	public Repeated(ArrayList<P> list, int height, int width){
		this.height=height;
		this.width=width;

		array=  (P[][]) new Object[height][width]; 
		int counter=0;
		for(int t=0;t<height;t++){
			for(int u=0;u<width;u++){
				array[t][u]=list.get(counter);
				counter ++;

			}
		}
	}

	private String help(){
		String aus;
		int h=0;
		int b=0;

		for(int t=0;t<height;t++){
			for(int u=0;u<width;u++){
				aus=array[t][u].toString();
				int z=aus.indexOf("\n");
				int r=aus.lastIndexOf("\n");
				System.out.println(r);
				if(z>b){
					b=z;
				}
				if(r>h){
					h=r;
				}
			}
		}
		h=h/b;
		System.out.println(b+" "+h);
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
						System.out.println(z);
						if(z<b){
							System.out.println(r+" "+help+" "+(z+help));
							subString[r] +=objOut.substring(help,z+help )+" ";
							int safe=z;
							for(;safe<b;safe++){
								subString[r] +=" ";
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
						System.out.println(z);
						if(z<b){
							System.out.println(r+" "+help+" "+(z+help));
							subString[r] +=objOut.substring(help,z+help )+" ";
							int safe=z;
							for(;safe<b;safe++){
								subString[r] +=" ";
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
							subString[h1] +=" ";
						}
					}
				}
			}
			for(int w=0;w<h;w++){

				ausgabe += subString[w]+"\n";
			}
			ausgabe +="\n";
			for(int q=0;q<h;q++){
				subString[q]="";
			}
		}
		return ausgabe;
	}

	public String toString(){
		return help();
		
	}
}
