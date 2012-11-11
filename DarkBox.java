public class DarkBox extends Box { //Vererbung kann sich noch aendern, siehe Problem
	
	public DarkBox(double width, double height, char content) {
		
		super(width, height, content, content);
	}

	public void setContent(char c) {
		
		//Problem: content soll durch c ersetzt werden. Oberklasse Box verlangt,
		//dass content nicht veraendert wird und ist deshalb final.
	}
}