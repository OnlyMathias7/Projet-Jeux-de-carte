package class_donne;

public class Carte {
	private int valeur;
	private int force;
	private Couleur couleur;
	private boolean afficher;	
	
	
	public Carte(int valeur, Couleur couleur2) {
			
		this.valeur=valeur;
		this.couleur=couleur2;
		this.afficher=false;
		
		
		if(valeur==2) {
			this.force=13;
		}
		else if(valeur==1){
			this.force=12;
		}
		else if(couleur2==Couleur.JOKER1 || couleur2==Couleur.JOKER2) {
			this.force=99;
		}
		else {
			this.force=valeur-2;
		}
	}
	

	public boolean afficher() {
		return afficher;
	}
	
	public void retourner() {
		afficher= !afficher;
	}
	
	
	public String toString() {
		return this.valeur+" "+this.couleur;
	}
	
	public int Valeur() {
		return this.valeur;
	}

	
	public int getValeurV() {
		return valeur;
	}
	public String getValeur() {
		if (valeur==11) {
			return "V";
		}
		else if (valeur==10) {
			return "X";
		}
		else if (valeur==12) {
			return "D";
		}
		else if (valeur==13) {
			return "R";
		}
		else if (valeur==1) {
			return "A";
		}
		else if (couleur==Couleur.JOKER1 ) {
			return "J";
		}
		else if (couleur==Couleur.JOKER2 ) {
			return "J";
		}
		else {
			return Integer.toString(valeur);
		}
	}

	public int getForce() {
		
		return force;
	}
	
	public void setForce(int force) {
		this.force = force;
	}

	public Couleur getCouleur() {
		return couleur;
	}
	
	public void setCouleur() {
		this.couleur = Couleur.SPECIAL;
	}
	
	public boolean equal(Carte carte) {
		return (this.couleur.equals(carte.couleur)) && (this.valeur==carte.valeur);
	}
	
	public boolean equalValue(Carte carte) {
		return (this.valeur==carte.valeur);
	}

	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	


}