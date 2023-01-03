package IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import class_donne.JoueurPartie;

public class PageBotDashboard extends JPanel {

	private Graphics2D g2;
	private PaintBot paint = new PaintBot();
	private boolean simullation=false;
	public PageBotDashboard() {
		super.setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2 = (Graphics2D) g;
		
		PaintWhite(g2);
		Autre(g2);
		Bot(g2);
		Liste(g2);
		Simulation(g2);
	}
	
	public void PaintWhite(Graphics2D g) {
		paint.paintWhite(g);
	}
	
	public void Autre(Graphics2D g) {
		paint.paintAutre(g2);
	}
	
	public void Bot(Graphics2D g) {
		paint.paintBot(g2);
	}
	public void Liste(Graphics2D g) {
		paint.paintListe(g2);
	}
	
	public void setJouer(boolean m) {
		paint.setJouer(m);
	}
	
	public void Simulation(Graphics2D g) {
		paint.paintSimulation(g);
		
	}
	
	public void setSimulation(boolean m) {
		paint.setSimulation(m);
	}
	
	public boolean getSimulation() {
		return paint.getSimulation();
	}
	
	public void setMenu(boolean m) {
		paint.setMenu(m);
	}
	
	public boolean getMenu() {
		return paint.getMenu();
	}
}
