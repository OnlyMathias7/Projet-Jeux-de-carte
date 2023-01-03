package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class PaintPageOne {

	private String[] option= new String[]{" Jeux de Carte","       Partie"," Règles du jeu","       Quitter"};
	
	public void paintBoutton(Graphics2D g) {
		for(int i=0;i<option.length;i++){
			g.setColor(Color.black);
			g.fillRect(319, 75+i*70, 351, 50);
			g.setColor(Color.white);
			g.fillRect(325, 81+i*70, 339, 38);
			g.setColor(Color.black);
			g.setFont(new Font("Dialog", Font.PLAIN, 20));
			g.drawString(option[i], 430, 110+ i * 70);
		}
	}
	
	public void paintFond(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1500, 1500);
		g.setColor(new Color(96,180,218));
		g.fillRect(6, 6, 974, 451);
		g.setColor(Color.black);
		g.fillRect(34, 30, 920, 400);
		g.setColor(Color.white);
		g.fillRect(40, 36, 908, 388);
		g.setColor(Color.gray);
		g.fillRect(390, 46, 210, 368);
		g.setColor(Color.black);
		g.fillRect(396, 52, 198, 356);
		g.setColor(Color.red);
		g.fillRect(55, 50, 250, 350);
		g.setColor(Color.white);
		g.fillRect(58, 53, 244, 344);
		g.setColor(Color.black);
		g.fillRect(682, 50, 250, 350);
		g.setColor(Color.white);
		g.fillRect(685, 53, 244, 344);
	}
}
