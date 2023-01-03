package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Bot.equilibre;
import Bot.impulsif;
import Bot.presse;
import Bot.reserve;
import class_donne.Joueur;
import class_donne.JoueurPartie;

public class PageBot {
	
	private JoueurPartie bot= JoueurPartie.getInstance();
	private PageBotDashboard dashboard= new PageBotDashboard();
		
	//page fenetre
	JFrame frame= new JFrame();
	
	//JPanel 
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	JPanel panel4= new JPanel();
	
	//JSplitPane
	JSplitPane split1;
	
	//JTexteAria
	JTextArea text= new JTextArea();
	
	//JLabel
	JLabel label1= new JLabel("BOT :");
	JLabel label2= new JLabel("Liste des Bots :");
	
	//JButtom
	JButton b1= new JButton("Ajouter");
	JButton b2= new JButton("Supprimer");
	JButton b3= new JButton("Jouer");
	
	//JButtom pour bots
	JButton b4= new JButton("Equilibre");
	JButton b5= new JButton("Impulsif");
	JButton b6= new JButton("Pressé");
	JButton b7= new JButton("Reserver");
	
/*------------------------------------------------------------------------------------*/	
	
	public PageBot() {
		init();
	}
	
/*------------------------------------------------------------------------------------*/
	
	private void init() {
		panel1.setLayout(new BorderLayout());
		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);
		
		panel1.add(dashboard, BorderLayout.CENTER);
		frame.add(panel1);
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
		new PageBot();
	}
	
	private class MouseControls implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
			boolean initpage=false;
			
			if((x>=120 && x<=520) && (y>=300 && y<=380) && bot.size()!=0) {
				bot.addJ1(new Joueur());
				frame.dispose();
				new PageJeu();
			}
			
			if((x>=90 && x<=280) && (y>=150 && y<=200)) {
				bot.add(new equilibre());
				initpage=true;
			}
			
			if((x>=290 && x<=480) && (y>=150 && y<=200)) {
				bot.add(new impulsif());
				initpage=true;
			}

			if((x>=490 && x<=680) && (y>=150 && y<=200)) {
				bot.add(new presse());
				initpage=true;
			}
			
			if((x>=690 && x<=880) && (y>=150 && y<=200)) {
				bot.add(new reserve());
				initpage=true;
			}
			
			if((x>=910 && x<=925) && (y>=315 && y<=330) && bot.size()>=1) {
				bot.remove(0);
				initpage=true;
			}
			
			if((x>=910 && x<=925) && (y>=365 && y<=380) && bot.size()>=2) {
				bot.remove(1);
				initpage=true;
			}
			
			if((x>=910 && x<=925) && (y>=415 && y<=430) && bot.size()==3) {
				bot.remove(2);
				initpage=true;
			}
			
			if((x>=10 && x<=40) && (y>=10 && y<=45)) {
				if(dashboard.getMenu()) {
					dashboard.setMenu(false);
					initpage=true;
				}else {
					dashboard.setMenu(true);
					initpage=true;
				}
			}
			
			if((x>=40 && x<=120) && (y>=10 && y<=40) && dashboard.getMenu()==true) {
				bot.clear();
				frame.dispose();
				dashboard.setSimulation(false);
				new PageOne();
			}
			
			
			if((x>=130 && x<=170) && (y>=420 && y<=450)) {
				if(dashboard.getSimulation()) {
					dashboard.setSimulation(false);
					initpage=true;
				}else {
					dashboard.setSimulation(true);
					initpage=true;
				}
			}
			
			if(initpage) {
				dashboard.repaint();
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
