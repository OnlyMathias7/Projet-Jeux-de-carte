package class_traitement;

import java.util.ArrayList;

import class_donne.Carte;
import class_donne.CartePosition;
import class_donne.Joueur;
import class_donne.Main;

/*
 * Cette class nous permet de stoker les dernieres combinaisons de cartes jouer afin de vérifier si le joueur peut en 
 * jouer d'autre.
 */


public class Combinaison {
	

	private ArrayList<Carte> newcombinaison= new ArrayList<Carte>();
	private ArrayList<Carte> lastcombinaison= new ArrayList<Carte>();
	
	private static Combinaison instance = new Combinaison();
	private Simple simple= new Simple();
	private Double doubl= new Double();
	private Bombe bomb= new Bombe();
	private Serie serie= new Serie();
	
	
	private Combinaison() {
		
	}
		
	public static Combinaison getInstance(){
		return instance;
	}
	
	/*
	 * Méthode qui rajoute une carte ou qui retire une carte (si elle y est déjà) dans l'ArrayListe newcombinaison.
	 */
	public void add(Carte carte) {
		if(isNotInNewCombinaison(carte)) {
			this.newcombinaison.add(carte);
		}else {
			this.newcombinaison.remove(getIndexCarte(carte));
		}
	}
	
	/*
	 * Méthode qui vérifie si une carte prise en paramètre fait partie de l'ArrayListe newcombinaison.
	 */
	public boolean isNotInNewCombinaison(Carte carte) {
		for(int i=0;i<this.newcombinaison.size();i++) {
			if(this.newcombinaison.get(i).equal(carte)) {
				return false;
			}
		}
		return true;
	}
	
	public void SuppCartes(Joueur joueur) {
		for (int i =joueur.TailleMain()-1; i>=0;i--) {
			if(!isNotInNewCombinaison(joueur.getCarte(i))) {
				joueur.JouerCarte(i);
			}
		}
	}
	
	/*
	 * Méthode qui retourne l'adresse d'une carte souhaité dans l'ArrayListe newcombinaison
	 */
	public int getIndexCarte(Carte carte) {
		for(int i=0;i<this.newcombinaison.size();i++) {
			if(this.newcombinaison.get(i).equal(carte)) {
				return i;
			}
		}
		return (Integer) null;
	}
	
	public ArrayList<Carte> getLastCombinaison(){
		return this.lastcombinaison;
	}
	
	/*
	 * Retourne la nouvelle combinaison que le joueur veux jouer
	 */
	public ArrayList<Carte> getNewCombinaison(){
		return this.newcombinaison;
	}

	
	
	/*
	 * Méthode qui
	 */
	public void setLastCombinaison() {
		simple.verification(newcombinaison, lastcombinaison);
		bomb.verification(newcombinaison, lastcombinaison);
		doubl.verification(newcombinaison, lastcombinaison);
		serie.verification(newcombinaison, lastcombinaison);
		
		if(simple.getValide()) {
            for(int i =0; i<newcombinaison.size();i++) {
                if(newcombinaison.get(i).getForce()==99) {
                    if(lastcombinaison.get(lastcombinaison.size()-1).getForce()==13) {
                        newcombinaison.get(i).setCouleur();
                        newcombinaison.get(i).setValeur(lastcombinaison.get(lastcombinaison.size()-1).getValeurV());
                        newcombinaison.get(i).setForce(lastcombinaison.get(lastcombinaison.size()-1).getForce());
                    }else {
                        newcombinaison.get(i).setCouleur();
                        newcombinaison.get(i).setValeur(lastcombinaison.get(lastcombinaison.size()-1).getValeurV()+1);
                        newcombinaison.get(i).setForce(lastcombinaison.get(lastcombinaison.size()-1).getForce()+1);
                    }

                }
            }
        }
		
		if(bomb.getValide()) {
			this.newcombinaison = trieCarte(this.newcombinaison);
			int force=newcombinaison.get(0).getForce();
			int valeur=newcombinaison.get(0).getValeurV();
			for(int i =0; i<newcombinaison.size();i++) {
				if(newcombinaison.get(i).getForce()!=force) {
					newcombinaison.get(i).setCouleur();
					newcombinaison.get(i).setValeur(valeur);
					newcombinaison.get(i).setForce(force);
				}
			}
		}
		
		if(doubl.getValide()) {
			if(newcombinaison.get(0).getForce()==99) {
				newcombinaison.get(0).setCouleur();
				newcombinaison.get(0).setValeur(newcombinaison.get(1).getValeurV()+1);
				newcombinaison.get(0).setForce(newcombinaison.get(1).getForce()+1);
			}
			if(newcombinaison.get(1).getForce()==99) {
				newcombinaison.get(1).setCouleur();
				newcombinaison.get(1).setValeur(newcombinaison.get(0).getValeurV()+1);
				newcombinaison.get(1).setForce(newcombinaison.get(0).getForce()+1);
			}
		}
		
		if(serie.getValide()) {
			this.newcombinaison = trieCarte(this.newcombinaison);
			if(serie.estuneSerieSanstrou(this.newcombinaison)) {
				for(int i=newcombinaison.size()-1;i>=1;i--) {
					if(newcombinaison.get(i).getForce()==99) {
						if(newcombinaison.get(i-1).getForce()==99) {
							
							newcombinaison.get(i-1).setCouleur();
							newcombinaison.get(i-1).setValeur(newcombinaison.get(i-2).getValeurV()+1);
							newcombinaison.get(i-1).setForce(newcombinaison.get(i-2).getForce()+1);
							newcombinaison.get(i).setCouleur();
							newcombinaison.get(i).setValeur(newcombinaison.get(i-1).getValeurV()+1);
							newcombinaison.get(i).setForce(newcombinaison.get(i-1).getForce()+1);
						}else {
							newcombinaison.get(i).setCouleur();
							newcombinaison.get(i).setValeur(newcombinaison.get(i-1).getValeurV()+1);
							newcombinaison.get(i).setForce(newcombinaison.get(i-1).getForce()+1);
						}
					} 	
				}
			}else {
				int compt=1;
				for(int i=0;i<this.newcombinaison.size()-serie.NbJoker(this.newcombinaison);i++) {
					if(newcombinaison.get(this.newcombinaison.size()-1).getForce()==99) {
						if(newcombinaison.get(this.newcombinaison.size()-2).getForce()==99) {
							if(newcombinaison.get(i).getForce()!=newcombinaison.get(i+1).getForce()+1) {
								if(newcombinaison.get(i).getForce()!=newcombinaison.get(i+2).getForce()+2) {
									newcombinaison.get(this.newcombinaison.size()-1).setCouleur();
									newcombinaison.get(this.newcombinaison.size()-1).setValeur(newcombinaison.get(i).getValeurV()+1);
									newcombinaison.get(this.newcombinaison.size()-1).setForce(newcombinaison.get(i).getForce()+1);
									newcombinaison.get(this.newcombinaison.size()-2).setCouleur();
									newcombinaison.get(this.newcombinaison.size()-2).setValeur(newcombinaison.get(this.newcombinaison.size()-1).getValeurV()+1);
									newcombinaison.get(this.newcombinaison.size()-2).setForce(newcombinaison.get(this.newcombinaison.size()-1).getForce()+1);
								}else {
									newcombinaison.get(this.newcombinaison.size()-compt).setCouleur();
									newcombinaison.get(this.newcombinaison.size()-compt).setValeur(newcombinaison.get(i).getValeurV()+1);
									newcombinaison.get(this.newcombinaison.size()-compt).setForce(newcombinaison.get(i).getForce()+1);
									compt++;
								}
							}
						}else {
							if(newcombinaison.get(i).getForce()!=newcombinaison.get(i+1).getForce()+1) {
								newcombinaison.get(this.newcombinaison.size()-1).setCouleur();
								newcombinaison.get(this.newcombinaison.size()-1).setValeur(newcombinaison.get(i).getValeurV()+1);
								newcombinaison.get(this.newcombinaison.size()-1).setForce(newcombinaison.get(i).getForce()+1);
							}
							
						}
					} 	
				}
			}
			
			
			this.newcombinaison = trieCarte(this.newcombinaison);
		}
		
		this.lastcombinaison = this.newcombinaison;
		this.newcombinaison = null;
		this.newcombinaison = new ArrayList<Carte>(); 
	}
	
	/*
	 * Méthode qui
	 */
	public void initCombinaison() {
		lastcombinaison= null;
		newcombinaison= null;
		lastcombinaison= new ArrayList<Carte>();
		newcombinaison= new ArrayList<Carte>();
	}
	
	public ArrayList<Carte> trieCarte(ArrayList<Carte> trie){
        ArrayList<Carte> action=  new ArrayList<Carte>();
        Carte tab[]= new Carte[trie.size()];
        for(int i=0;i<trie.size();i++) {
            tab[i]=trie.get(i);
        }
        int min=0;
        Carte temp;
        for(int i=0;i<tab.length-1;i++) {
            min=i;
            for(int j=i;j<tab.length;j++) {
                if(tab[j].getForce()<tab[min].getForce()) {
                    min=j;
                }
            }
            temp=tab[min];
            tab[min]=tab[i];
            tab[i]=temp;

        }
        for(int i=0;i<tab.length;i++) {
            action.add(tab[i]);
        }
        return action;
    }
	
	public boolean verification() {
			switch(this.newcombinaison.size()) {
				case 1 :
					simple.verification(newcombinaison, lastcombinaison);
					bomb.verification(newcombinaison, lastcombinaison);
					return (simple.getValide() || bomb.getValide()) ;
				case 2: 
					doubl.verification(newcombinaison, lastcombinaison);
					bomb.verification(newcombinaison, lastcombinaison);
					return (doubl.getValide() || bomb.getValide());
				case 3: 
					serie.verification(newcombinaison, lastcombinaison);
					bomb.verification(newcombinaison, lastcombinaison);
					return (serie.getValide() || bomb.getValide());
				case 4: 
					serie.verification(newcombinaison, lastcombinaison);
					bomb.verification(newcombinaison, lastcombinaison);
					return (serie.getValide() || bomb.getValide());
				case 5: 
					serie.verification(newcombinaison, lastcombinaison);
					bomb.verification(newcombinaison, lastcombinaison);
					return (serie.getValide() || bomb.getValide());
					
				case 6: 
					serie.verification(newcombinaison, lastcombinaison);
					bomb.verification(newcombinaison, lastcombinaison);
					return (serie.getValide() || bomb.getValide());
			}
			if(this.newcombinaison.size()>6) {
				serie.verification(newcombinaison, lastcombinaison);
				return serie.getValide();
			}
			return false;
	}
	
	public ArrayList<Carte> VerifPlayBomb3SD(Main main){
		trieCarte(main.getMain());
		ArrayList<Carte> TEMP = new ArrayList<Carte>();
		
		if(main.getCarte(main.TailleMain()-1).getForce() == 99) {
			if(main.getCarte(main.TailleMain()-2).getForce() == 99) {
				TEMP.add(main.getCarte(0));
				TEMP.add(main.getCarte(main.TailleMain()-1));
				TEMP.add(main.getCarte(main.TailleMain()-2));
				return TEMP;
			}
			else {
				for (int i =0 ; i<main.TailleMain()-2; i++) {
					for (int j =0 ; j<main.TailleMain()-2; j++) {
						if (j == i) {
							j++;
						}
						else if (main.getCarte(i).getForce() == main.getCarte(j).getForce()) {
							TEMP.add(main.getCarte(main.TailleMain()-1));
							TEMP.add(main.getCarte(i));
							TEMP.add(main.getCarte(j));
							return TEMP;
						}
					}
				}
			}
		}
		else {
			trieCarte(main.getMain());
			for (int i =0 ; i<main.TailleMain()-2; i++) {
				if ( main.getCarte(i) == main.getCarte(i+1)){
					if (main.getCarte(i) == main.getCarte(i+2) ) {
						TEMP.add(main.getCarte(i));
						TEMP.add(main.getCarte(i+1));
						TEMP.add(main.getCarte(i+2));
						return TEMP;
					}
				}
			}
			
		}
		return TEMP;
	}
	
	
	
	
	public ArrayList<Carte> VerifPlayBomb3(Main main){
		
	
		trieCarte(main.getMain());
		ArrayList<Carte> TEMP = new ArrayList<Carte>();
		
		if(main.getCarte(main.TailleMain()-1).getForce() == 99) {
			if(main.getCarte(main.TailleMain()-2).getForce() == 99) {
				for (int i =0 ; i<main.TailleMain()-2; i++) {
					if(main.getCarte(i).getForce() == lastcombinaison.get(lastcombinaison.size()-1).getForce()+1) {
						TEMP.add(main.getCarte(i));
						TEMP.add(main.getCarte(main.TailleMain()-1));
						TEMP.add(main.getCarte(main.TailleMain()-2));
						return TEMP;
				}
				}
			}
			else {
				for (int i =0 ; i<main.TailleMain()-2; i++) {
					for (int j =0 ; j<main.TailleMain()-2; j++) {
						if (j == i) {
							j++;
						}
						else if ((main.getCarte(i).getForce() == main.getCarte(j).getForce())
								&& (main.getCarte(i).getForce() == lastcombinaison.get(lastcombinaison.size()-1).getForce()+1)) {
							TEMP.add(main.getCarte(main.TailleMain()-1));
							TEMP.add(main.getCarte(i));
							TEMP.add(main.getCarte(j));
							return TEMP;
						}
					}
				}
			}
		}
		else {
			trieCarte(main.getMain());
			for (int i =0 ; i<main.TailleMain()-2; i++) {
				if ( main.getCarte(i) == main.getCarte(i+1)){
					if (main.getCarte(i) == main.getCarte(i+2) ) {
						if(main.getCarte(i).getForce() == lastcombinaison.get(lastcombinaison.size()-1).getForce()+1) {
						TEMP.add(main.getCarte(i));
						TEMP.add(main.getCarte(i+1));
						TEMP.add(main.getCarte(i+2));
						return TEMP;
					}
				}
			}
			
		}
	}
		return TEMP;
	}
	
	
	public ArrayList<Carte> VerifPlay(Joueur main) {
		
		trieCarte(main.getMain());
		ArrayList<Carte> TEMP = new ArrayList<Carte>();
		
		switch(lastcombinaison.size()){
		case 0:
			
			TEMP.add(main.getCarte(0));
			return TEMP;
		
		case 1:
			trieCarte(main.getMain());
			//SIMPLE
			main.AfficheMain();
			for (int i=0; i< main.TailleMain(); i++) {
				if ( main.getCarte(i).getForce()==99) {
					if (lastcombinaison.get(0).getForce() != 13) {
					TEMP.add(main.getCarte(i));
					return TEMP;
					}
				}
				else if (main.getCarte(i).getForce() == lastcombinaison.get(lastcombinaison.size()-1).getForce()+1) {
					TEMP.add(main.getCarte(i));
					return TEMP;
				}
				
			}
			if (VerifPlayBomb3SD(main).size()==3) {
				TEMP.add(VerifPlayBomb3SD(main).get(0));
				TEMP.add(VerifPlayBomb3SD(main).get(1));
				TEMP.add(VerifPlayBomb3SD(main).get(2));
				return TEMP;
			}
			
			return TEMP;
			
			
			
			
			
		case 2:
			trieCarte(main.getMain());
			for (int i=main.TailleMain()-1; i>=0; i--) {
				for (int j=0; j< main.TailleMain(); j++) {
					if (j == i) {
						j++;
					}
					
					else if (main.getCarte(i).getForce() == 99 ) {
						if (main.getCarte(j).getForce() == lastcombinaison.get(lastcombinaison.size()-1).getForce()+1) {
							TEMP.add(main.getCarte(i));
							TEMP.add(main.getCarte(j));
							return TEMP;
							}
						
						}
					else if (((main.getCarte(i).getForce() == main.getCarte(j).getForce()) 
							&&	main.getCarte(i).getForce() == lastcombinaison.get(lastcombinaison.size()-1).getForce()+1)) {
						TEMP.add(main.getCarte(i));
						TEMP.add(main.getCarte(j));
						return TEMP;
					}
				
				}
			}
			if (VerifPlayBomb3SD(main).size()==3) {
				TEMP.add(VerifPlayBomb3SD(main).get(0));
				TEMP.add(VerifPlayBomb3SD(main).get(1));
				TEMP.add(VerifPlayBomb3SD(main).get(2));
				return TEMP;
			}
			
			
		case 3:
			trieCarte(main.getMain());
			
			if (VerifPlayBomb3(main).size()==3) {
				TEMP.add(VerifPlayBomb3(main).get(0));
				TEMP.add(VerifPlayBomb3(main).get(1));
				TEMP.add(VerifPlayBomb3(main).get(2));
				return TEMP;
			}
			
			
			if(main.getCarte(main.TailleMain()-1).getForce() == 99) {
				if(main.getCarte(main.TailleMain()-2).getForce() == 99) {
					for (int i =0 ; i<main.TailleMain()-2; i++) {
						if(main.getCarte(i).getForce() == lastcombinaison.get(0).getForce()+1) {
							TEMP.add(main.getCarte(i));
							TEMP.add(main.getCarte(main.TailleMain()-1));
							TEMP.add(main.getCarte(main.TailleMain()-2));
							return TEMP;
					}
					}
				}
				else {
					for (int i =0 ; i<main.TailleMain()-2; i++) {
						for (int j =0 ; j<main.TailleMain()-2; j++) {
							if (j == i) {
								j++;
							}
							else if ((main.getCarte(i).getForce() == main.getCarte(j).getForce()-1)
									&& (main.getCarte(i).getForce() == lastcombinaison.get(0).getForce()+1)) {
								TEMP.add(main.getCarte(main.TailleMain()-1));
								TEMP.add(main.getCarte(i));
								TEMP.add(main.getCarte(j));
								return TEMP;
							}
						}
					}
				}
			}
			else {
				trieCarte(main.getMain());
				for (int i =0 ; i<main.TailleMain()-2; i++) {
					if ( main.getCarte(i).getForce() == main.getCarte(i+1).getForce()-1){
						if (main.getCarte(i).getForce() == main.getCarte(i+2).getForce()-2 ) {
							if(main.getCarte(i).getForce() == lastcombinaison.get(0).getForce()+1) {
							TEMP.add(main.getCarte(i));
							TEMP.add(main.getCarte(i+1));
							TEMP.add(main.getCarte(i+2));
							return TEMP;
						}
					}
				}
				
			}	
		
		}
	
	return TEMP;
		
	
			default :
				
				return TEMP;
		}
}

	
	public void setNewCombinaison(ArrayList<Carte> comb) {
		this.newcombinaison = comb;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
