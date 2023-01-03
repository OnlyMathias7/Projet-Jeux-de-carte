package class_traitement;

import java.util.ArrayList;

import class_donne.Carte;

public class Simple {
	
	private boolean valide=false;
	
	public Simple() {
		
	}
	
	public void verification(ArrayList<Carte> newcom, ArrayList<Carte> last) {
		if(newcom.size()>1 || newcom.size()==0) {
			setValide(false);
		}else {
			if(newcom.size()==1 && last.size()==0) {
				setValide(true);
			}else {
				if((last.size()!=0 && last.size()!=1  ) || (newcom.get(0).getForce()!=last.get(0).getForce()+1 && last.size()!=0 )) {
					if(newcom.get(0).getForce()!=99) {
						setValide(false);
					}else {
						setValide(true);
					}	
				}else {
					setValide(true);
				}
			}
		}
			

	}	
	
	public boolean getValide() {
		return this.valide;
	}
	
	private void setValide(boolean val) {
		this.valide=val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
