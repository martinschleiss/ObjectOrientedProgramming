/**
 * nur fuer schnelle Autos
 *
 */
public class StrategieRandom extends Strategie{
	
	private ausrichtung a;
	public enum adjazentFeldN {N, NO, NW};
	public enum adjazentFeldO {O, NO, SO};
	public enum adjazentFeldS {S, SO, SW};
	public enum adjazentFeldW {W, NW, SW};
	
	public StrategieRandom(ausrichtung a){
		super();
		this.a=a;
	}
	
	
	public Feld naechstesFeld(Feld aktuell){
		Feld ziel = null;
		
		if(a==ausrichtung.NORD){
			
			adjazentFeldS[] values = adjazentFeldS.values();
			adjazentFeldS value = values[(int) (Math.random() * 3)];
			String c= value.toString();
			
			if(c.equals("NO")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NO);
				a = ausrichtung.OST;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
					a = ausrichtung.NORD;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NW);
						a = ausrichtung.WEST;
					}
				}
			}else if(c.equals("N")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NO);
					a = ausrichtung.OST;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NW);
						a = ausrichtung.WEST;
					}
				}
			}else if(c.equals("NW")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NW);
				a = ausrichtung.WEST;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.N);
					a = ausrichtung.NORD;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NO);
						a = ausrichtung.OST;
					}
				}
			}
			return ziel;
		}else if(a==ausrichtung.OST) {
			
			adjazentFeldO[] values = adjazentFeldO.values();
			adjazentFeldO value = values[(int) (Math.random() * 3)];
			String c= value.toString();
			
			if(c.equals("O")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
			
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NO);
					a = ausrichtung.NORD;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SO);
						a = ausrichtung.SUED;
					}
				}
			}else if(c.equals("NO")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NO);
				a = ausrichtung.NORD;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
					a = ausrichtung.OST;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SO);
						a = ausrichtung.SUED;
					}
				}
			}else if(c.equals("SO")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SO);
				a = ausrichtung.SUED;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NO);
					a = ausrichtung.NORD;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.O);
						a = ausrichtung.OST;
					}
				}
			}
			return ziel;
			
		}else if(a==ausrichtung.SUED){
			adjazentFeldS[] values = adjazentFeldS.values();
			adjazentFeldS value = values[(int) (Math.random() * 3)];
			String c= value.toString();
			
			if(c.equals("S")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.S);
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SW);
					a = ausrichtung.WEST;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SO);
						a = ausrichtung.OST;
					}
				}
			}else if(c.equals("SO")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SO);
				a = ausrichtung.OST;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SW);
					a = ausrichtung.WEST;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.S);
						a = ausrichtung.SUED;
					}
				}
			}else if(c.equals("SW")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SW);
				a = ausrichtung.WEST;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SO);
					a = ausrichtung.OST;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.S);
						a = ausrichtung.SUED;
					}
				}
			}
			return ziel;
			
		}else{
			adjazentFeldW[] values = adjazentFeldW.values();
			adjazentFeldW value = values[(int) (Math.random() * 3)];
			String c= value.toString();
			
			if(c.equals("W")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.W);
				a = ausrichtung.WEST;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NW);
					a = ausrichtung.NORD;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SW);
						a = ausrichtung.SUED;
					}
				}
			}else if(c.equals("NW")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NW);
				a = ausrichtung.NORD;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SW);
					a = ausrichtung.SUED;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.W);
						a = ausrichtung.WEST;
					}
				}
			}else if(c.equals("SW")){
				ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.SW);
				a = ausrichtung.SUED;
				
				if(ziel==null){
					ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.NW);
					a = ausrichtung.NORD;
					if(ziel==null){
						ziel= aktuell.adjazentesFeld(Feld.adjazentesFeld.W);
						a = ausrichtung.WEST;
					}
				}
			}
			return ziel;
			
		}
	}

}
