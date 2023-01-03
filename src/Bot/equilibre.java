package Bot;

import class_donne.Carte;
import class_donne.Joueur;

public class equilibre extends Joueur {

	public equilibre() {
		super();
		super.setName("Equilibre");
		super.setNum(1);
	}
	
	public int probabilite() {
		int x = (int) (Math.random() * 2);
		if (x==1) {
			return 1;
		}
		else {
			return 1;
		}
	}
	

}