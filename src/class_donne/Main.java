package class_donne;

import java.util.ArrayList;

public class Main {
	
	private ArrayList<Carte>main;
	
	public Main() {
		main = new ArrayList<Carte>();
	}
	
	public void AjouterCarte(Carte carte) {
		main.add(carte);
		
	}
	
	
	public void PiocherCarte(Pioche pioche) {
		int j=0;
		while(j!=99) {
			if ((!(j>=pioche.pioche.length)) && pioche.pioche[j]!=null ) {
				AjouterCarte(pioche.pioche[j]);
				pioche.pioche[j]=null;
				j=99;
			}
			else {
				j++;
			}
		}
	}
	
	public void VideMain() {
		for(int j=main.size()-1; j>=0  ; j--) {
			JouerCarte(j);
		}
	}
	
	public void RemplirMain(Pioche pioche) {
		for(int d=0;d<5; d++ ) {
			int j=0;
			while(j!=99) {
				if (pioche.pioche[j]!=null) {
					AjouterCarte(pioche.pioche[j]);
					pioche.pioche[j]=null;
					j=99;
				}
				else {
					j++;
				}
			}
		}
	}
	
	public void JouerCarte(int n) {
    	main.remove(n);
    }
	
	public String toString() {
		return "Main [" + main + "]";
	} 
	
	public int TailleMain() {
		return main.size();
	}
	
	public void AfficheMain() {
		for (int i=0; i<main.size(); i++) {
			if ((main.get(i))==null) {
				System.out.println("Pas de carte");
			}
			else {
			System.out.println((main.get(i)).getValeur());
			}
		}
	}
	
	public Carte getCarte(int i) {
		return main.get(i);
	}
	
	public ArrayList<Carte> getMain(){
		return this.main;
	}
		    
}