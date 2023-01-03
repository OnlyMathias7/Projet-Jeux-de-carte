package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class PageOne {
	
	private PageDashboardOne dashboard= new PageDashboardOne();
	
	//page fenetre
	JFrame frame= new JFrame();
	
	//espace diffèrent sur la page
	JPanel panel1= new JPanel();
	
	
	
	public PageOne(){
		
		init();

	}
	
	private void init() {
		
		panel1.setLayout(new BorderLayout());
		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);
		
		panel1.add(dashboard, BorderLayout.CENTER);
		frame.add(panel1);
		
		//Ouverture de la fenetre
		
		//Donne la taille de la fenetre
		frame.setSize(1000,500);
		    
		//Organisation de la fenetre principale (frame)
		frame.setLayout(new GridLayout(1,1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
			
		//Methode qui affiche la fenetre à l'écran
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PageOne();
	}
	
	private class MouseControls implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
			
			//Button Partie
			if((x>=390 && x<=670) && (y>=145 && y<=195)) {
				frame.dispose();
				new PageBot();
			}
			
			//Button Règles
			if((x>=390 && x<=670) && (y>=215 && y<=265)) {
				frame.dispose();
				new PageRegle();
			}
			
			//Button Quitter
			if((x>=390 && x<=670) && (y>=285 && y<=335)) {
				frame.dispose();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
