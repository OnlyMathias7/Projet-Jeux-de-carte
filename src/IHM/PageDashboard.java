package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

import class_donne.Carte;
import class_donne.CartePosition;
import class_donne.Couleur;
import class_donne.JoueurPartie;
import class_donne.Main;
import class_traitement.Combinaison;


public class PageDashboard extends JPanel{
	
	private PaintMain paintmain= new PaintMain();
	private Combinaison comb= Combinaison.getInstance();
	private Graphics2D g2;
	private JoueurPartie joueur= JoueurPartie.getInstance();
	private boolean partiecommence= false;
	private boolean partiefini= false;
	
	public PageDashboard() {
		super.setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2 = (Graphics2D) g;
		
		PaintWhite();
		
		
		if(partiecommence==false) {
			PaintDebut();
			return;
		}
		
		init();

		g2.setColor(Color.BLACK);
		
		if(joueur.size()!=0) {
			switch(joueur.size()) {
			
			case 2 : 
				MainJ(joueur.getJoueur(1));
				Mainadd1(joueur.getJoueur(0));
				break;
			case 3 :
				MainJ(joueur.getJoueur(2));
				Mainadd1(joueur.getJoueur(0));
				Mainadd2(joueur.getJoueur(1));
				break;
			case 4 : 
				MainJ(joueur.getJoueur(3));
				Mainadd1(joueur.getJoueur(0));
				Mainadd2(joueur.getJoueur(2));
				Mainadd3(joueur.getJoueur(1));
				break;
		}
		}
		
		if(comb.getLastCombinaison()!=null && comb.getLastCombinaison().size()!=0) {
			PiocheTas();
		}
		
		if(partiefini==true) {
			PaintWhite();
			PaintWinner();
		}
	}
	
	public void init() {
		paintmain.paintTable(g2);
	}
	public void MainJ(Main main) {
		 paintmain.paint(main, g2);
	 }
	
	public void Mainadd1(Main main) {
		 paintmain.paintAd1(main, g2);
	 }
	 
	public void Mainadd2(Main main) {
		 paintmain.paintAd2(main, g2);
	 }
	
	public void Mainadd3(Main main) {
		 paintmain.paintAd3(main, g2);
	 }
	
	public void PiocheTas() {
		paintmain.paintPioche(g2);
	}
	
	public void setPartiecommencer(boolean change) {
		this.partiecommence=change;
	}
	
	public void setPartiefini(boolean change) {
		this.partiefini=change;
	}
	
	public boolean getPartiecommence() {
		return this.partiecommence;
	}
	
	public void PaintWinner() {
		paintmain.paintWinner2(g2);
	}
	
	public void PaintDebut() {
		paintmain.paintWinner("START", g2);
	}
	
	public void PaintWhite() {
		paintmain.paintFond(g2);
	}
	
	public void setMenu(boolean m) {
		paintmain.setMenu(m);
	}
	
	public boolean getMenu() {
		return paintmain.getMenu();
	}
	
	public boolean getPartifini() {
		return this.partiefini;
	}
}
