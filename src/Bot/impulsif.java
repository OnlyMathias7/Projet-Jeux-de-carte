package Bot;

import class_donne.Joueur;

public class impulsif extends Joueur{
	
	private int degreImp;
	
	public impulsif() {
		super();
		super.setName("Impulsif");
		super.setNum(2);
		int degreImp;
		
	}
	
	public void degreAug(){
		if (degreImp < 10) {
			degreImp ++;
		}	
	}
	public int probabilite() {
		int seuil = 11 - degreImp;
		int x = (int) (Math.random() * seuil);
		if (x==1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	

}