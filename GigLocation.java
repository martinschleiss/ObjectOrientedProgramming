/**
 * 
 * @author Anil
 *
 */

//import java.util.*;

public class GigLocation extends Location{
	
	private int seatings;
	
	public GigLocation(int district, int size, int stageSize, int seatings){
		super(district, size, stageSize);
		this.setSeatings(seatings);
	}

	public int getSeatings() {
		return seatings;
	}
	public int undefined(){
		return 0;
	}
	//seatings>0
	public void setSeatings(int seatings) {
		this.seatings = seatings;
	}
	
	public String toString() {
		
		return super.toString() + ", Seatings: " + seatings;
	}

	/**
	 * FEHLER: laut dieser Methode waeren alle Locations gleich 
	 */
	@Override
	public int compareTo(Location o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
