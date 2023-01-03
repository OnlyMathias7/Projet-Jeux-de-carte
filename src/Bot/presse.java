package Bot;

import class_donne.Joueur;

public class presse extends Joueur{
	
	public presse() {
		super();
		super.setName("Pressé");
		super.setNum(3);
		
	}

	//joue dès qu'il en a l'occasion
	public int probabilite() {
		
		return 1;
	}

}