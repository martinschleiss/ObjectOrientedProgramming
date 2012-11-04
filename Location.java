/**
 * 
 * @author Anil
 *
 */
public abstract class Location{
	
	//FEHLER in der Implementierung von Comparable<Location>, siehe Subklassen.
	
	
	private int district;
	private int size;
	private int stageSize;
	
	/**
	 * Vorbedingungen:
	 * @param district		muss dem jeweiligen Bezirk der Stadt entsprechen, muss daher auch im Berech 1 bis #Bezirke der Stadt sein
	 * @param size			> 0, entspricht Groesse der Location
	 * @param stageSize		> 0, entspricht Groesse der Buehne
	 */
	public Location(int district, int size, int stageSize){
		this.setDistrict(district);
		this.setSize(size);
		this.setStageSize(stageSize);
	}
	
	//SCHLECHT: Siehe Subklassen: Methode koennte in diese Klasse aufgenommen werden, da beide Subklassen sie gleich implementieren. (oder einfach weglassen)
	//public abstract int undefined();

	public int getDistrict() {
		return district;
	}
	
	/**
	 * Vorbedingungen:
	 * @param district	muss dem jeweiligen Bezirk der Stadt entsprechen, muss im Bereich 1 bis #Bezirke der Stadt sein
	 * 
	 * Nachbedingungen: district wird als neuer Bezirk gespeichert
	 * VERBESSERUNGSVORSCHLAG: Vielleicht koennte man diesen und auch andere Setter einsparen.
	 */
	public void setDistrict(int district) {
		this.district = district;
	}

	public int getSize() {
		return size;
	}
	
	/**
	 * Vorbedingungen:
	 * @param size > 0, Groesse der Location
	 * 
	 * Nachbedingungen: size wird als neue Groesse gespeichert
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public int getStageSize() {
		return stageSize;
	}

	/**
	 * Vorbedingungen:
	 * @param stageSize > 0, Groesse der Buehne
	 * 
	 * Nachbedingungen: stageSize wird als neue Buehnengroesse gespeichert
	 */
	public void setStageSize(int stageSize) {
		this.stageSize = stageSize;
	}
	
	public String toString() {
		
		return "District: " + district + ", Size: " + size + ", Stage Size: " + stageSize;
	}
	

	
}
