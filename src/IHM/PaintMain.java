package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import class_donne.Carte;
import class_donne.CartePosition;
import class_donne.Couleur;
import class_donne.JoueurPartie;
import class_donne.Main;
import class_traitement.Combinaison;
import class_traitement.PositionMain;

public class PaintMain {
	
	private JoueurPartie joueur = JoueurPartie.getInstance();
	private PositionMain positionCarte = PositionMain.getInstance();
	private Combinaison comb= Combinaison.getInstance();
	private boolean menu=false;
	
	
	public void paint(Main main, Graphics2D graphie) {
		positionCarte.clear();
		for(int i=0; i< main.TailleMain();i++) {
			String numero= main.getCarte(i).getValeur();
			CartePosition carte= new CartePosition();
			carte.setCarte(ConstantJeu.POSITION_CARTE_X+70*i, ConstantJeu.POSITION_CARTE_Y,main.getCarte(i));
			positionCarte.add(carte);
			if(!(comb.isNotInNewCombinaison(main.getCarte(i)))) {
				graphie.setColor(Color.black);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X+70*i, ConstantJeu.POSITION_CARTE_Y,  ConstantJeu.LARGUEUR_CARTE, ConstantJeu.HAUTEUR_CARTE);
				graphie.setColor(Color.yellow);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X+2+70*i, ConstantJeu.POSITION_CARTE_Y+2, ConstantJeu.LARGUEUR_CARTE-4, ConstantJeu.HAUTEUR_CARTE-4);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
				graphie.setColor(Color.RED);
				graphie.drawString(numero, ConstantJeu.POSITION_CARTE_X+(70*i)+18, ConstantJeu.POSITION_CARTE_Y+45);
			}else {
				graphie.setColor(Color.black);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X+70*i, ConstantJeu.POSITION_CARTE_Y,  ConstantJeu.LARGUEUR_CARTE, ConstantJeu.HAUTEUR_CARTE);
				graphie.setColor(Color.white);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X+2+70*i, ConstantJeu.POSITION_CARTE_Y+2, ConstantJeu.LARGUEUR_CARTE-4, ConstantJeu.HAUTEUR_CARTE-4);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
				graphie.setColor(Color.RED);
				graphie.drawString(numero, ConstantJeu.POSITION_CARTE_X+(70*i)+18, ConstantJeu.POSITION_CARTE_Y+45);
			}
		}	
	}

	
	public void paintAd1(Main main, Graphics2D graphie) {
		for(int i=0; i< main.TailleMain();i++) {
			String numero= main.getCarte(i).getValeur();
			if(i>4) {
				graphie.setColor(Color.black);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD1-80, ConstantJeu.POSITION_CARTE_Y_AD1+(i*50)-250,  ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE);
				graphie.setColor(Color.white);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD1-78, ConstantJeu.POSITION_CARTE_Y_AD1+(i*50)-248, ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-4, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE-4);
				if(joueur.getSimulation()) {
					graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
					graphie.setColor(Color.RED);
					graphie.drawString(numero,ConstantJeu.POSITION_CARTE_X_AD1-60, ConstantJeu.POSITION_CARTE_Y_AD2+(i*50)-220);
				}
			}else {
				graphie.setColor(Color.black);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD1, ConstantJeu.POSITION_CARTE_Y_AD1+(i*50),  ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE);
				graphie.setColor(Color.white);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD1+2, ConstantJeu.POSITION_CARTE_Y_AD1+(i*50)+2, ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-4, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE-4);
				if(joueur.getSimulation()) {
					graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
					graphie.setColor(Color.RED);
					graphie.drawString(numero,ConstantJeu.POSITION_CARTE_X_AD1+20, ConstantJeu.POSITION_CARTE_Y_AD2+(i*50)+30);
				}
			}
		}
	} 
	
	public void paintPioche(Graphics2D graphie) {
		graphie.setColor(Color.BLACK);
		graphie.drawRect(300, 160, 300, 80);
		graphie.setColor(Color.BLACK);
		graphie.drawRect(300, 170, 300, 60);
		for(int i=0;i<comb.getLastCombinaison().size();i++) {
			String numero=comb.getLastCombinaison().get(i).getValeur();
			Couleur couleur = comb.getLastCombinaison().get(i).getCouleur();
			if(couleur.equals(Couleur.SPECIAL)) {
				graphie.setColor(Color.black);
				graphie.fillRect(313+60*i, 165, 50, 70);
				graphie.setColor(new Color(102,0,161));
				graphie.fillRect(315+60*i, 167, 46, 66);
				graphie.setColor(Color.red);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
				graphie.setColor(Color.RED);
				graphie.drawString(numero,330+60*i, 205);
			}else {
				graphie.setColor(Color.black);
				graphie.fillRect(313+60*i, 165, 50, 70);
				graphie.setColor(Color.WHITE);
				graphie.fillRect(315+60*i, 167, 46, 66);
				graphie.setColor(Color.red);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
				graphie.setColor(Color.RED);
				graphie.drawString(numero,330+60*i, 205);
			}
		}
		
	}
	
	
	public void paintAd2(Main main, Graphics2D graphie) {
		for(int i=0; i< main.TailleMain();i++) {
			String numero= main.getCarte(i).getValeur();
			if(i>4) {
				graphie.setColor(Color.black);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD2+80, ConstantJeu.POSITION_CARTE_Y_AD2+(i*50)-250,  ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE);
				graphie.setColor(Color.white);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD2+82, ConstantJeu.POSITION_CARTE_Y_AD2+(i*50)-248, ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-4, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE-4);
				if(joueur.getSimulation()) {
					graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
					graphie.setColor(Color.RED);
					graphie.drawString(numero, ConstantJeu.POSITION_CARTE_X_AD2+100, ConstantJeu.POSITION_CARTE_Y_AD2+(i*50)-220);
				}
			}else {
				graphie.setColor(Color.black);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD2, ConstantJeu.POSITION_CARTE_Y_AD2+(i*50),  ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE);
				graphie.setColor(Color.white);
				graphie.fillRect(ConstantJeu.POSITION_CARTE_X_AD2+2, ConstantJeu.POSITION_CARTE_Y_AD2+2+(i*50), ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-4, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE-4);
				if(joueur.getSimulation()) {
					graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
					graphie.setColor(Color.RED);
					graphie.drawString(numero, ConstantJeu.POSITION_CARTE_X_AD2+20, ConstantJeu.POSITION_CARTE_Y_AD2+(i*50)+30);
				}
			}
		}
	}
	
	public void paintAd3(Main main, Graphics2D graphie) {
		for(int i=0; i< main.TailleMain();i++) {
			String numero= main.getCarte(i).getValeur();
			if(i<8) {
				graphie.setColor(Color.black);
				graphie.fillRect(220+(i*50), 10, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE, ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-5);
				graphie.setColor(Color.white);
				graphie.fillRect(222+(i*50), 12, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE-4, ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-9);
				if(joueur.getSimulation()) {
					graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
					graphie.setColor(Color.RED);
					graphie.drawString(numero, 230+(i*50), 45);
				}
			}else {
				graphie.setColor(Color.black);
				graphie.fillRect(220+(8*50), 10, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE, ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-5);
				graphie.setColor(Color.white);
				graphie.fillRect(222+(8*50), 12, ConstantJeu.LARGUEUR_CARTE_ADVERSAIRE-4, ConstantJeu.HAUTEUR_CARTE_ADVERSAIRE-9);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 25));
				graphie.setColor(Color.RED);
				int z=main.TailleMain()-8;
				numero="+"+z;
				graphie.drawString(numero, 620, 45);
				i=main.TailleMain();
			}
		}
	}
	
	public void paintWinner(String s,Graphics2D graphie) {
		graphie.setColor(Color.RED);
		graphie.fillRect(250, 120, 400, 100);
		graphie.setColor(Color.white);
		graphie.fillRect(256, 126, 388, 88);
		graphie.setColor(Color.RED);
		graphie.setFont(new Font("Dialog", Font.PLAIN, 50));
		graphie.drawString(s, 320, 185);
	}
	
	public void paintWinner2(Graphics2D graphie) {
		graphie.setColor(Color.RED);
		graphie.fillRect(250, 120, 400, 100);
		graphie.setColor(Color.white);
		graphie.fillRect(256, 126, 388, 88);
		graphie.setColor(Color.RED);
		graphie.setFont(new Font("Dialog", Font.PLAIN, 50));
		graphie.drawString("  Fin de la Partie", 255, 185);
		for(int i=0;i<joueur.size();i++) {
			if(i==0) {
				graphie.setColor(Color.RED);
				graphie.fillRect(320, 230, 100, 30);
				graphie.setColor(Color.white);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 10));
				graphie.drawString("Point J0 : "+joueur.getJoueur(i).getPoint()+"pt", 330, 250);
			}
			if(i==1) {
				graphie.setColor(Color.RED);
				graphie.fillRect(450, 230, 100, 30);
				graphie.setColor(Color.white);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 10));
				graphie.drawString("Point J1 : "+joueur.getJoueur(i).getPoint()+"pt", 460, 250);
			}
			if(i==2) {
				graphie.setColor(Color.RED);
				graphie.fillRect(580, 230, 100, 30);
				graphie.setColor(Color.white);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 10));
				graphie.drawString("Point J2 : "+joueur.getJoueur(i).getPoint()+"pt", 590, 250);
			}
			if(i==3) {
				graphie.setColor(Color.RED);
				graphie.fillRect(190, 230, 100, 30);
				graphie.setColor(Color.white);
				graphie.setFont(new Font("Dialog", Font.PLAIN, 10));
				graphie.drawString("Point J3 : "+joueur.getJoueur(i).getPoint()+"pt", 200, 250);
			}
		}
		graphie.setColor(Color.black);
		graphie.fillRect(305, 270, 120, 50);
		graphie.setColor(Color.LIGHT_GRAY);
		graphie.fillRect(311, 276, 108, 38);
		graphie.setColor(Color.white);
		graphie.setFont(new Font("Dialog", Font.PLAIN, 15));
		graphie.drawString("Rejouer", 338, 300);
		
		graphie.setColor(Color.black);
		graphie.fillRect(445, 270, 120, 50);
		graphie.setColor(Color.LIGHT_GRAY);
		graphie.fillRect(451, 276, 108, 38);
		graphie.setColor(Color.white);
		graphie.setFont(new Font("Dialog", Font.PLAIN, 15));
		graphie.drawString("Quitter", 483, 300);
	}
	
	public void paintFond(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1500, 1500);
		g.setColor(Color.WHITE);
		g.fillRect(6, 6, 886, 435);
		g.setColor(Color.black);
		g.drawRect(10, 10, 30, 35);
		for(int i=0;i<3;i++) {
			g.setColor(Color.lightGray);
			g.fillRect(13, 15+i*10, 23, 5);
			g.setColor(Color.black);
			g.drawRect(13, 15+i*10, 23, 5);
		}
		if(this.menu) {
			g.setColor(Color.white);
			g.fillRect(40, 10, 80, 30);
			g.setColor(Color.black);
			g.drawRect(40, 10, 80, 30);
			g.setFont(new Font("Dialog", Font.PLAIN, 25));
			g.drawString("Menu",50 , 35);
		}
	}
	
	public void paintTable(Graphics2D g) {
		g.setColor(Color.black);
		g.fillOval(210, 80, 480, 240);
		g.setColor(Color.GREEN);
		g.fillOval(216, 84, 468, 228);
		g.setColor(Color.black);
		g.drawLine(6, 330, 892, 330);
		g.drawLine(200, 6, 200, 330);
		g.drawLine(700, 6, 700, 330);
		g.drawLine(200, 70, 700, 70);
	}
	
	public void paintPointJoueur() {
		
	}
	
	public void setMenu(boolean m) {
		this.menu=m;
	}
	
	public boolean getMenu() {
		return menu;
	}
}
