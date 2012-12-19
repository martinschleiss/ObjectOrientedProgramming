
/**
 * Repraesentiert vom Kunden gewuenschten Teig der Kekse
 */
public interface WunschTeig {

	/**
	 * liefert zum Wunschteig passenden Teig
	 * @return Untertyp von Teig, der gewuenscht ist
	 */
	public Teig getTeig();
}
