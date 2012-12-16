
public abstract class Keksbackmaschine {

	/**
	 * abstracte Methode zum erstellen von einfachen Keksen 
	 * @param form Form des Keks
	 * @param teig Teigart des Keks
	 * @return ein einfacher Keks
	 */
	public abstract Keks<? extends Form, ? extends Teig> keksFactory(Form form, Teig teig);
	/**
	 * abstracte Methode zum erstellen von doppelten Keksen
	 * @param keks aus dem ein DoppelKeks erstellt werden soll
	 * @param fuelle die Fuellung des DoppelKekses
	 * @return ein DoppelKeks
	 */
	public abstract Keks<? extends Form, ? extends Teig> keksFactory(Keks<? extends Form, ? extends Teig> keks, Fuellung fuelle);
}
