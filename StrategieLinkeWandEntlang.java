public class StrategieLinkeWandEntlang extends Strategie {
	
	private ausrichtung a;
	
	public StrategieLinkeWandEntlang(ausrichtung a) {
		super();
		this.a = a;
	}
	
	public Feld naechstesFeld(Feld aktuell) {
		
		Feld ziel = null;
		
		if(a == ausrichtung.NORD) {
			ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
			if(ziel == null) {
				ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
				a = ausrichtung.OST;
			}
		} else if (a == ausrichtung.OST) {
			ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
			if(ziel == null) {
				ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.S);
				a = ausrichtung.SUED;
			}
		} else if (a == ausrichtung.SUED) {
			ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.S);
			if(ziel == null) {
				ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.W);
				a = ausrichtung.WEST;
			}
		} else {
			ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.W);
			if(ziel == null) {
				ziel = aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
				a = ausrichtung.NORD;
			}
		}
		
		return ziel;
	}

}
