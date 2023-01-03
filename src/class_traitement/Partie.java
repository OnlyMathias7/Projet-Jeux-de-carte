package class_traitement;
import java.util.ArrayList;

import Bot.equilibre;
import Bot.impulsif;
import Bot.presse;
import Bot.reserve;
import class_donne.Joueur;
import class_donne.JoueurPartie;
import class_donne.Main;
import class_donne.Pioche;


public class Partie {

	private JoueurPartie membres= JoueurPartie.getInstance();
	private Pioche pioche;
	private Combinaison comb = Combinaison.getInstance();
	private equilibre equ = new equilibre();
	private impulsif imp = new impulsif();
	private presse pre = new presse();
	private reserve res = new reserve();
	private int compteurManche=0;
	
	public Partie() {
		pioche = new Pioche();
		pioche = pioche.melangePioche(pioche);
	}
	
	public void VideMainJoueur() {
		for(int i=0;i<membres.size();i++) {
			membres.getJoueur(i).VideM();
		}
	}
	
	public boolean Verifwinner() {
		boolean x = false;
		for(int i = 0; i < membres.size(); i++){
	      if((membres.getJoueur(i)).TailleMain() == 0) {
	    	  return true;
	      }
	      else {
	    	  return false;
	      }
	    }
		return x;
		
	}
	
	public void NewManche() {
		for(int i = 0; i < membres.size(); i++){
			membres.getJoueur(i).setCouche(false);;
		}
		for(int i=0;i< membres.size();i++) {
			membres.getJoueur(i).PiocherCarte(pioche);
		}
		this.compteurManche++;
	}
	
	
	public boolean FinManche() {
		boolean x = false;
		int w = 0;
		for(int i = 0; i < membres.size(); i++){
			if((membres.getJoueur(i)).getCouche()) {
				w++;
			}
		}
		if(w == membres.size()-1) {
			x = true;
		}
		else {
			x = false;
		}
		return x;
	}
	
	public int DernierJoueurManche() {
		for(int i = 0; i < membres.size(); i++) {
			if(!(membres.getJoueur(i)).getCouche()) {
				return i;
			}
		}
		return  100;
	}
	
	public String EtatJoueur() {
		String s="";
		for(int i = 0; i < membres.size(); i++) {
			s+="Joueur "+i+" etat de jeux : "+membres.getJoueur(i).getCouche()+"\n";
		}
		return s;
	}
	
	public void distribution() {
		
		for(int i = 0; i < membres.size(); i++){
			(membres.getJoueur(i)).RemplirMain(pioche);			
		}
	}
	
	public boolean JouerBot(Joueur joueur) {
		
		boolean x = false;
			switch(joueur.getNum()) {
			
			case 1:
				if (comb.VerifPlay(joueur).size() != 0 ) {
					if (equ.probabilite()==1) {
						return true;
					}
					else {
						joueur.setCouche(true);
						return false;
					}
				
				}else {
					joueur.setCouche(true);
					return false;
				}
			
				
			case 2:
			
				if (comb.VerifPlay(joueur).size() != 0 ) {
					if (imp.probabilite()==1) {
						return true;
					}
					else {
						return false;
					}
					
				}else {
					joueur.setCouche(true);
				}
				
			case 3:
				
				if(comb.VerifPlay(joueur).size() != 0 ) {
					if (pre.probabilite()==1) {
						 return true;
					}
					else {
						return false;
					}
					
				}else {
					joueur.setCouche(true);
					return false;
				}
				
				
				
			case 4:
				
				if (comb.VerifPlay(joueur).size() != 0 ) {
					if (res.probabilite()==1) {
						return true;
					}
					else {
						return false;
					}
					
				}else {
					joueur.setCouche(true);
					return false;
				}
			}
			return x;
		}
	
	
	public void ComptagePoint() {
		for(int i=0;i<membres.size();i++) {
			int comp=0;
			for(int j=0;j<membres.getJoueur(i).getMain().size();j++) {
				if(membres.getJoueur(i).getMain().get(j).getForce()<10) {
					comp+=5;
				}
				if(membres.getJoueur(i).getMain().get(j).getForce()>=10 && membres.getJoueur(i).getMain().get(j).getForce()<=14) {
					comp+=10;
				}
				if(membres.getJoueur(i).getMain().get(j).getForce()>=14) {
					comp+=15;
				}
			}
			membres.getJoueur(i).setPoint(comp);
			
		}
	}
	
	public int getCompteur() {
		return this.compteurManche;
	}
	
}