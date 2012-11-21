

public class CompositeTime extends ElapsedTime {

	private Double [] totalTime; 


	public CompositeTime( Double [] totalTime) {

		super(sum(totalTime));
		this.totalTime=totalTime;
	}
	/**
	 * Nur fuer Parameter des Superkonstruktors relevant
	 * @param totTime
	 * @return summe aller Werte aus dem Array
	 */
	private static Double sum( Double [] totTime){
		Double sum=0.0;
		for(int i=0;i<totTime.length;i++){
			sum+=totTime[i];
		}
		return sum;
	}

	/**
	 * Liefert Vergleichsmass fuer shorter()
	 * @return		Summe der gemessenen Zeiten
	 */
	public double getMessure() {
		
		return sum();
	}
	
	/**
	 * totalTime != null
	 * @return  summe aller Werte aus dem Array
	 */
	private Double sum(){
		Double sum=0.0;
		for(int i=0;i<totalTime.length;i++){
			sum+=totalTime[i];
		}
		return sum;
	}

	/**
	 *  totalTime != null
	 * @return kleinster Wert aus dem Array
	 */
	public Double shortest(){

		Double shortest=Double.MAX_VALUE;

		for(int i=0;i<totalTime.length;i++){
			if(totalTime[i]<shortest){
				shortest=totalTime[i];
			}
		}
		return shortest;
	}
	/**
	 * gibt die laenge des Arrays zuruek, also die Anzahl der Messwerte
	 */
	@Override
	public int count(){
		return totalTime.length;
	}
	public String toString() {
		
		return "CompositeTime, Summe: " + sum();
	}
}