

public class CompositeTime extends ElapsedTime {

	private Double [] totalTime; 


	public CompositeTime( Double [] totalTime) {
		super(sum(totalTime));
		this.totalTime=totalTime;
		variable=sum();	// fuer den vergleich durch shorter()


	}
	/**
	 * Nur fuer die Super() Methode relevant
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
	 * @param Objekt zum vergleichen, Theoretisch vom Typ ElapsedTime, CompositeTime oder MeanElapsedTime moeglich
	 * @return gibt true zuruek, wenn der durchschnitt dieser Instanz kleiner ist als other
	 */
	@Override
	public boolean shorter(ElapsedTime other){
		return this.sum()<other.variable;
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
}