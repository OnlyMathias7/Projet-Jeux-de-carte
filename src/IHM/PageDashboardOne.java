package IHM;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PageDashboardOne extends JPanel{
	private Graphics2D g2;
	private PaintPageOne paint= new PaintPageOne();
	public PageDashboardOne(){
		super.setBackground(Color.WHITE);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g2 = (Graphics2D) g;
		
		PaintFond(g2);
		Button(g2);
	
	}
	
	public void Button(Graphics2D g) {
		paint.paintBoutton(g);
	}
	
	public void PaintFond(Graphics2D g) {
		paint.paintFond(g);
	}
}
