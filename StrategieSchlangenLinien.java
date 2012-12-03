/**
 * fuer bewegliche Autos
 *
 */
public class StrategieSchlangenLinien extends Strategie{

	private ausrichtung a;
	public StrategieSchlangenLinien(ausrichtung a){
		super();
		this.a=a;
	}

	public Feld naechstesFeld(Feld aktuell) {
		Feld ziel = null;

		if(a == ausrichtung.NORD) {
			ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
			//a = ausrichtung.NORD;
			if(ziel==null){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.W);
				a = ausrichtung.WEST;
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
					a = ausrichtung.OST;

				}
			}
		}else if(a == ausrichtung.SUED) {
			ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.W);
			a = ausrichtung.WEST;
			if(ziel==null){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
				a = ausrichtung.OST;
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
				}
			}
		}else if(a == ausrichtung.WEST) {
			ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.W);

			if(ziel==null){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.S);
				a = ausrichtung.SUED;
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
					a = ausrichtung.NORD;

				}
			}
		}else if(a == ausrichtung.OST) {
			ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.O);

			if(ziel==null){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.S);
				a = ausrichtung.SUED;
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
					a = ausrichtung.NORD;
				}
			}
		}

		return ziel;
	}
}


