package class_donne;

import java.util.ArrayList;

import class_traitement.Combinaison;



public class JoueurPartie {
	
	private ArrayList<Joueur> joueur= new ArrayList<Joueur>();
	
	private static JoueurPartie instance = new JoueurPartie();
	private boolean simulation=false;
	
	private JoueurPartie() {
		
	}
	
	private void init() {
		
	}
	
	public static JoueurPartie getInstance(){
		return instance;
	}
	
	public void add(Joueur joueur) {
		if(this.joueur.size()==3) {
			this.joueur.remove(0);
			this.joueur.add(joueur);
		}else {
			this.joueur.add(joueur);
		}
	}
	
	public void addJ1(Joueur joueur) {
		this.joueur.add(joueur);
	}
	
	public void remove(int i) {
		this.joueur.remove(i);
	}
	
	
	public void clear() {
		this.joueur.clear();
		init();
	}
	
	public Joueur getJoueur(int i){
		return joueur.get(i);
	}
	
	
	public int size() {
		return this.joueur.size();
	}
	
	public boolean getSimulation() {
		return this.simulation;
	}
	
	public void setSimulation(boolean m) {
		this.simulation=m;
	}

	
	public String toString() {
		String s= " ";
		for(int i=0;i<joueur.size();i++) {
			s+="Joueur "+(i+1)+" : "+joueur.get(i).getName()+"\n";
		}
		return s;
		
	}
}
