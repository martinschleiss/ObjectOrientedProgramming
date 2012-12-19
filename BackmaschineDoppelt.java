
public class BackmaschineDoppelt implements Backmaschine{


	public Keksdose backe(Position po) {
		
		PositionDoppelkeks p;
		//falls keine Doppelkeksposition gib leere Dose zurueck
		if(po instanceof PositionDoppelkeks) {
			p = (PositionDoppelkeks) po;
		} else {
			return new Keksdose();
		}
		
		Keksdose k = new Keksdose();
		Backmaschine keksbodenMaschine = p.getForm().getBackmaschine();
		k.befuelle(keksbodenMaschine.backe(p));
		
		Keksdose doppelKeksDose = new Keksdose();
		
		for(Keks boden : k.getKekse()) {
			Keks deckel = boden.clone();
			doppelKeksDose.befuelle(new Doppelkeks(boden, deckel, p.getFuellung()));
		}
		
		return doppelKeksDose;
	}
}
