package Bot;

import class_donne.Joueur;

public class presse extends Joueur{
	
	public presse() {
		super();
		super.setName("Press�");
		super.setNum(3);
		
	}

	//joue d�s qu'il en a l'occasion
	public int probabilite() {
		
		return 1;
	}

}