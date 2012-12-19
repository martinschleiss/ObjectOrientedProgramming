/**
 * Baeckt Doppelkekse in allen Formen und Teigarten und liefert eine Keksdose
 * Dabei werden zuerst Einfachkekse gebacken und danach automatisch fuer jeden Einfachkeks
 * ein aequvivalenter 2. Keks.
 */
public class BackmaschineDoppelt implements Backmaschine {

	/**
	 * Baeckt Kekse, die der Anzahl, Form, Teig und Fuellung in der Position gefordert
	 * @param pd != null
	 * @return wenn Position Doppelkekse fordert: Keksdose, gefuellt mit Doppelkeksen laut Position
	 * 			sonst: leere Keksdose
	 */
	public Keksdose backe(Position pd) {
		
		PositionDoppelkeks p;
		Keksdose k = new Keksdose();

		if(pd instanceof PositionDoppelkeks) {
			
			p = (PositionDoppelkeks) pd;
			
		} else {
			
			return k;
		}
		
		Backmaschine b = p.getForm().getBackmaschine();
		
		k.befuelle(b.backe(p));
		
		Keksdose doppelKeksDose = new Keksdose();
		
		for(Keks boden : k.getKekse()) {
			
			Keks deckel = boden.clone();
			
			doppelKeksDose.befuelle(new Doppelkeks(boden, deckel, p.getFuellung().clone()));
		}
		
		return doppelKeksDose;
	}
}