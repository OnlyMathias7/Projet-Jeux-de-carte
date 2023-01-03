package class_donne;

import java.util.ArrayList;

public class Joueur extends Main {
	
	private String nom;
	private boolean couche=false;
	private int num;
	private int point=100;
	
	public Joueur() {
		 this.nom = "Joueur";
		 
		 num=0;
	}
	
	public void VideM() {
		super.VideMain();
	}
	
	public void setName(String name) {
		nom=name;
	}
	
	public String getName() {
		return this.nom;
	}
	
	public void setNum(int num) {
		this.num=num;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void setCouche(boolean etat) {
		this.couche=etat;
	}
	
	public boolean getCouche() {
		return this.couche;
	}
	
	public ArrayList<Carte> getMain() {
		return super.getMain();
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public void setPoint(int i) {
		this.point=this.point-i;
	}
	
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", main=" + super.toString() + "]";
	}
	
}

