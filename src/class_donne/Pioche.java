package class_donne;

public class Pioche {
	
	Carte[] pioche;
	
	public Pioche() {
	pioche = new Carte[54];
	int compt=0;
	Couleur couleur = Couleur.coeur;
	for(int j=0;j<4;j++) {
		if(j==1) {
			couleur=Couleur.carreau;
		}
		if(j==2) {
			couleur=Couleur.pique;
		}
		if(j==3) {
			couleur=Couleur.trefle;
		}
		for(int i=1;i<14;i++) {
			Carte carte= new Carte(i,couleur);
			pioche[compt]=carte;
			compt++;
		}
	}
	for(int k=0;k<2; k++) {
		int x=14;
		int o = 1;
		if(o==1) {
			couleur=Couleur.JOKER1;
		}
		if(o==2) {
			couleur=Couleur.JOKER2;
		}
		Carte joker= new Carte(x,couleur);
		pioche[compt]=joker;
		compt++;
		o++;
	
	}
	}
	
	public Pioche melangePioche(Pioche pioche) {
		
		for (int i = 0; i < pioche.pioche.length; i++) {
			int r = (int) (Math.random() * pioche.pioche.length);
	        Carte tmp = pioche.pioche[i];
	        pioche.pioche[i] = pioche.pioche[r];
	        pioche.pioche[r] = tmp;
	    }
		return pioche;
	}
	
	public int EstVidePioche() {
		int x = 0;
		for (int i = 0; i < pioche.length; i++) {
			if (pioche[i] != null) {
				x = 0;
			}
			else {
				x = 1;
				
			}
		}
		return x;
	}
		
		
	public void affichePioche() {
		for(int i=0; i<this.pioche.length;i++) {
			System.out.println(pioche[i].getValeur()+" de "+pioche[i].getCouleur()+" de force : "+pioche[i].getForce());
		}
	}
}