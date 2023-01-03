package class_traitement;

import java.util.ArrayList;

import class_donne.CartePosition;

public class PositionMain {
	
	private ArrayList<CartePosition> positionCarte= new ArrayList<CartePosition>();
	
	private static PositionMain instance = new PositionMain();
	
	private PositionMain() {
		
	}
	
	public static PositionMain getInstance(){
		return instance;
	}
	
	public void add(CartePosition position) {
		this.positionCarte.add(position);
	}
	
	public void clear() {
		this.positionCarte.clear();
	}
	
	public ArrayList<CartePosition> getPositionCarte(){
		return this.positionCarte;
	}
	
	public int getSize() {
		if(this.positionCarte.size()!=0) {
			return this.positionCarte.size();
		}else {
			return 0;
		}
	}
	
	public CartePosition getCartePosition(int i) {
		return this.positionCarte.get(i)
;	}

}
