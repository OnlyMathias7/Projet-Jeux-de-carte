package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import class_donne.Joueur;
import class_donne.JoueurPartie;

public class PaintBot {
	private JoueurPartie bot= JoueurPartie.getInstance();
	private boolean jouer=false;
	private boolean menu=false;
	private boolean simulation=bot.getSimulation();
	private String[] typebot=new String[] {"Equilibré","Impulsif","Préssé","Reservé"};
	
	public void paintBot(Graphics2D g) {
		for (int i = 0; i < typebot.length; i++) {
			g.setColor(Color.white);
			g.fillRect(90 +(i * 200), 150, 190, 50);
			g.setColor(Color.black);
			g.drawRect(90 +(i * 200), 150, 190, 50);
			g.setBackground(Color.magenta);
			g.setFont(new Font("Dialog", Font.PLAIN, 20));
			g.drawString(typebot[i], 140 + i * 200, 185);
		}
	}

	public void paintListe(Graphics2D g) {
		g.setColor(new Color(88, 41, 0));
		g.drawRect(650, 250, 300, 200);
		g.fillRect(650, 250, 300, 200);
		g.setColor(Color.white);
		g.fillRect(655, 255, 290, 190);
		if(bot.size()==0) {
			g.setColor(Color.black);
			g.setFont(new Font("Dialog", Font.PLAIN, 25));
			g.drawString("Vous devez choisir", 700, 330);
			g.drawString("au moins un ", 730, 380);
			g.drawString("adversaire pour jouer ", 690, 430);
		}
		g.setColor(Color.black);
		g.drawRect(655, 255, 290, 190);
		g.drawRect(660, 260, 280, 30);
		g.setFont(new Font("Dialog", Font.PLAIN, 25));
		g.drawString("Liste :", 760, 285);
		for (int i = 0; i < bot.size(); i++) {
			g.setColor(Color.black);
			g.setFont(new Font("Dialog", Font.PLAIN, 20));
			g.drawString("Joueur " + (i+1) + " :", 680, 330+i*50);
			g.drawString(bot.getJoueur(i).getName(), 780, 330+i*50);
			g.setColor(Color.red);
			g.fillRect(910, 315+i*50, 15, 15);
			g.setColor(Color.black);
			g.drawRect(910, 315+i*50, 15, 15);
			g.setColor(Color.white);
			g.fillRect(912, 322+i*50, 11, 3);
			g.setColor(Color.black);
			g.drawRect(912, 322+i*50, 11, 3);
		}
	}

	public void paintAutre(Graphics2D g) {
		g.setColor(new Color(88, 41, 0));
		g.fillRect(300, 30, 400, 50);
		g.setColor(Color.black);
		g.drawRect(300, 30, 400, 50);
		g.setColor(new Color(88, 41, 0));
		g.fillRect(300, 30, 400, 50);
		g.setColor(Color.white);
		g.fillRect(305, 35, 390, 40);
		g.setColor(Color.black);
		g.drawRect(305, 35, 390, 40);
		g.setFont(new Font("Dialog", Font.PLAIN, 25));
		g.drawString("Bot", 475, 65);
		if(bot.size()!=0) {
			g.setColor(Color.black);
			g.drawRect(120, 300, 400, 80);
			g.setColor(new Color(88, 41, 0));
			g.fillRect(120, 300, 400, 80);
			g.setColor(Color.WHITE);
			g.fillRect(125, 305, 390, 70);
			g.setColor(Color.black);
			g.drawRect(125, 305, 390, 70);
			g.setFont(new Font("Dialog", Font.PLAIN, 25));
			g.drawString("Jouer",285 , 350);
		}else {
			g.setColor(Color.black);
			g.drawRect(120, 300, 400, 80);
			g.setColor(Color.GRAY);
			g.fillRect(120, 300, 400, 80);
			g.setColor(Color.GRAY);
			g.fillRect(125, 305, 390, 70);
			g.setColor(Color.black);
			g.drawRect(125, 305, 390, 70);
			g.setFont(new Font("Dialog", Font.PLAIN, 25));
			g.drawString("Jouer",285 , 350);
		}

	}
	
	public void paintWhite(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1500, 1500);
		g.setColor(Color.lightGray);
		g.fillRect(5, 5, 977, 453);
		g.setColor(Color.black);
		g.drawRect(5, 5, 977, 453);
		g.setColor(Color.WHITE);
		g.fillRect(10, 10, 30, 35);
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
	public void paintSimulation(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(17, 417, 156, 36);
		g.setColor(Color.black);
		g.fillRect(20, 420, 100, 30);
		g.fillRect(130, 420, 40, 30);
		g.setColor(Color.white);
		g.setFont(new Font("Dialog", Font.PLAIN, 20));
		g.drawString("Simulation :",22 , 442);
		if(this.simulation) {
			g.setColor(Color.white);
			g.setFont(new Font("Dialog", Font.PLAIN, 10));
			g.drawString("Non",140 , 438);
		}else {
			g.setColor(Color.white);
			g.setFont(new Font("Dialog", Font.PLAIN, 10));
			g.drawString("Oui",140 , 438);
		}
	}
	public void setJouer(boolean m) {
		this.jouer=m;
	}
	public void setMenu(boolean m) {
		this.menu=m;
	}
	
	public boolean getMenu() {
		return this.menu;
	}
	
	public void setSimulation(boolean m) {
		this.simulation=m;
		bot.setSimulation(this.simulation);
	}
	
	public boolean getSimulation() {
		return this.simulation;
	}
}
