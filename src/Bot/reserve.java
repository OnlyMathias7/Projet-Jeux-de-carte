package Bot;

import class_donne.Joueur;

public class reserve extends Joueur{

	public reserve() {
		super();
		super.setName("Reserve");
		super.setNum(4);
	}
	public int probabilite() {
		if (super.getMain().size()<9) {
			return 0;
		}
		else {
			int x = (int) (Math.random() * 5);
			if (x==1) {
				return 1;
			}
			else {
				return 0;
			}
		}		
	}	
}

	