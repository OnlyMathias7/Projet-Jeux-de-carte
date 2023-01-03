package class_traitement;

import java.util.ArrayList;

import class_donne.Carte;

public class Serie {
	
	private boolean valide= false;
	
	public Serie() {
		
	}
	
	public void verification(ArrayList<Carte> newcom, ArrayList<Carte> last) {
		ArrayList<Carte> trie= new ArrayList<Carte>();
		trie=trieCarte(newcom);
		if(last.size()==0) {
			setValide(estUneSerie(trie));
		}else {
			ArrayList<Carte> trielast= new ArrayList<Carte>();
			trielast=trieCarte(last);
			if(estUneSerie(trielast)) {
				if( trielast.get(last.size()-1).getForce()==trie.get(0).getForce() ||trielast.get(last.size()-1).getForce()<trie.get(0).getForce()) {
					setValide(estUneSerie(trie));
				}else {
					setValide(false);
				}
			}
		}
	}
	
	public boolean estUneSerie(ArrayList<Carte> list) {
		int compt=0;
		if(list.size()>=3) {
			if(NbJoker(list)==0) {
				for(int i=0; i<list.size()-1;i++) {
					if(!(list.get(i).getForce()==list.get(i+1).getForce()+1)) {
						return false;
					}
				}
				return true;
			}
			if(NbJoker(list)==1) {
				for(int i=0; i<list.size()-2;i++) {
					if(!(list.get(i).getForce()==list.get(i+1).getForce()+1 || list.get(i+1).getForce()==99)) {
						if(compt==1) {
							return false;
						}
						compt++;
					}
				}
				return true;
			}
			if(NbJoker(list)==2) {
				for(int i=0; i<list.size()-3;i++) {
					if(!(list.get(i).getForce()==list.get(i+1).getForce()+1 || list.get(i+1).getForce()==99)) {
						if(list.get(i).getForce()!=list.get(i+1).getForce()+2 && list.get(i+1).getForce()!=99
						 || (list.get(i).getForce()!=list.get(i+1).getForce()+3 && list.get(i+1).getForce()!=99)) {
							return false;
						}
						if(compt==2) {
							return false;
						}
						compt++;
					}
				}
				return true;
			}
			return false;
		}else {
			return false;
		}
		
	}
	
	//Précondition list doit être trier
	
	public boolean estuneSerieSanstrou(ArrayList<Carte> list) {
		if(list.get(list.size()-1).getForce()==99) {
			if(list.get(list.size()-1).getForce()==99) {
				for(int i =0;i<list.size()-3;i++) {
					if(list.get(i).getForce()!=list.get(i).getForce()+1) {
						return false;
					}
				}
				return true;
			}else {
				for(int i =0;i<list.size()-2;i++) {
					if(list.get(i).getForce()!=list.get(i).getForce()+1) {
						return false;
					}
				}
				return true;
			}
		}else {
			for(int i =0;i<list.size()-1;i++) {
				if(list.get(i).getForce()!=list.get(i+1).getForce()+1) {
					return false;
				}
			}
			return true;
		}
	}
	
	public ArrayList<Carte> trieCarte(ArrayList<Carte> trie){
		ArrayList<Carte> action=  new ArrayList<Carte>();
		Carte tab[]= new Carte[trie.size()];
		for(int i=0;i<trie.size();i++) {
			tab[i]=trie.get(i);
		}
		int max=0;
		Carte temp;
		for(int i=0;i<tab.length-1;i++) {
			max=i;
			for(int j=i;j<tab.length;j++) {
				if(tab[j].getForce()>tab[max].getForce()) {
					max=j;
				}
			}
			temp=tab[max];
			tab[max]=tab[i];
			tab[i]=temp;
			
		}
		for(int i=0;i<tab.length;i++) {
			action.add(tab[i]);
		}
		return action;
	}
	
	public int NbJoker(ArrayList<Carte> list){
		int compt=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getForce()==99) {
				compt++;
			}
		}
		return compt;
	}
	
	public boolean getValide() {
		return this.valide;
	}
	
	private void setValide(boolean val) {
		this.valide=val;
	}
}
