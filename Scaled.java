import java.util.ArrayList;
import java.util.Scanner;;

public class Scaled<T extends Pict> implements Pict {
	
	private int height;
	private int width;
	private ArrayList<? extends Pict> list;
	private int boxWidth;
	private int boxHeight;
	
	public Scaled(ArrayList<? extends Pict> list, int height, int width) {
		this.height = height;
		this.width = width;
		this.list = list;
		this.boxHeight = getMaximumBoxHeight(list);
		this.boxWidth = getMaximumBoxWidth(list);
	}
	
	private int getMaximumBoxHeight(ArrayList<? extends Pict> l) {
		int maximum = 0;
		
		for(Pict elem : l) {
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
	
	private int getMaximumBoxWidth(ArrayList<? extends Pict> l) {
		return 0;
	}
	
	public void scale(double factor) {
		
		for(Pict elem : list) {
			elem.scale(factor);
		}
	
	}
	
	public String toString() {
		String s = "";
		
		for(int h = 0; h < height; h++) {
			
			for(int w = 0; w < width; w++) {
				
				//for(int bh = 0; )
				
			}
			
		}
		
		return s;
	}
}