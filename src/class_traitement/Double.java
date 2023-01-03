package class_traitement;

import java.util.ArrayList;

import class_donne.Carte;

public class Double {
	
	private boolean valide=false;
	
	public Double() {

	}
	
	public void verification(ArrayList<Carte> newcom, ArrayList<Carte> last) {
		if(newcom.size()==2) {
			if(last.size()==0) {
				if(newcom.get(0).getForce()==newcom.get(1).getForce()) {
					setValide(true);
				}else {
					if(newcom.get(0).getForce()==99 || newcom.get(1).getForce()==99) {
						setValide(true);
					}else {
						setValide(false);
					}
				}
			}else {
				if(newcom.get(0).getForce()==newcom.get(1).getForce() && last.size()==2 && 
				(last.get(0).getForce()==newcom.get(0).getForce()+1 || last.get(0).getForce()==newcom.get(1).getForce()+1)) {
					setValide(true);
				}else {
					if((newcom.get(0).getForce()==99 && newcom.get(1).getForce()==last.get(0).getForce()+1)
						||(newcom.get(1).getForce()==99 && newcom.get(0).getForce()==last.get(0).getForce()+1)) {
						setValide(true);
					}else {
						setValide(false);
					}
				}
			}
		}else {
			setValide(false);
		}
	}
		
	
	
	
	public boolean getValide() {
		return this.valide;
	}
	
	private void setValide(boolean val) {
		this.valide=val;
	}
	

}
