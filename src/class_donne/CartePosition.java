package class_donne;

import IHM.ConstantJeu;

public class CartePosition {
	private int x;
	private int y;
	private Carte carte;
	
	public void setCarte(int x, int y, Carte carte) {
		this.x=x;
		this.y=y;
		this.carte=carte;
	}
	
	public Carte getCarte() {
		return this.carte;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isInCarte(int x, int y) {
		return (x>=this.x && x<=this.x+ConstantJeu.LARGUEUR_CARTE) && (y>=this.y && y<=this.y+ConstantJeu.HAUTEUR_CARTE);
	}
	
	public String toString() {
		String s="Position en x : "+this.x+" Position en y : "+this.y;
		return s;
	}
}
