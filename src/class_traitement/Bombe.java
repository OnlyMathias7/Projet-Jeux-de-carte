package class_traitement;

import java.util.ArrayList;

import class_donne.Carte;

public class Bombe {
private boolean valide= false;
	
	public Bombe() {
		
	}
	
	public void verification(ArrayList<Carte> newcom, ArrayList<Carte> last) {
		if(estUneBombe(newcom)) {
			if(last.size()!=0 && estUneBombe(last)) {
				if(newcom.size()<last.size() || newcom.get(0).getForce()<last.get(0).getForce()) {
					setValide(false);
				}else {
					setValide(true);
				}
			}else {
				setValide(true);
			}
		}
	}
	
	public boolean getValide() {
		return this.valide;
	}
	
	public boolean estUneBombe(ArrayList<Carte> list) {
		Carte one= list.get(0);
		if(list.size()>=3) {
			for(int i=1;i<list.size();i++) {
				if(!(one.equalValue(list.get(i)) || list.get(i).getValeur().equals("J"))) {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	private void setValide(boolean val) {
		this.valide=val;
	}
}
