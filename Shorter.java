/**
 * Klassen, die dieses Interface implementieren lassen sich bezueglich darauf testen,
 * ob sie kuerzer als das uebergebene Element sind.
 */
public interface Shorter {
	
	/**
	 * @param other		wird verglichen
	 * @return			true, wenn this kuerzer als other, sonst false
	 */
	public boolean shorter(Shorter other);

	
	//NUR TESTWEISE
	public Double getLength();
}
