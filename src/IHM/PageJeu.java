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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import class_donne.JoueurPartie;
import class_donne.Pioche;
import class_traitement.Combinaison;
import class_traitement.Partie;
import class_traitement.PositionMain;

public class PageJeu implements Runnable{
	
	PositionMain positionCarte = PositionMain.getInstance();
	Combinaison combinaison= Combinaison.getInstance();
	JoueurPartie joueur= JoueurPartie.getInstance();
	Pioche pioche;
	Partie partie= new Partie();
	//page fenetre
	JFrame frame= new JFrame();
	
	//JPanel
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	JPanel panel4= new JPanel();
	JPanel panel5= new JPanel();
	
	
	//JLabel
	JLabel label0= new JLabel("PAGE DE JEU");
	JLabel label3= new JLabel("Possibilité de Jeu :");
	
	
	//JButton
	JButton b2= new JButton("Passer son Tour");
	JButton b3= new JButton("Jouer");
	
	//PageDashBoder
	private PageDashboard dashboard = new PageDashboard();
	
	//InfoActionGUI
	private InfoActionGui info= new InfoActionGui();

	
	public PageJeu() {
		
	init();
		
	}

/*------------------------------------------------------------------------------------*/
	
	private void init() {
		/*------------------------------------------------------------------------------------*/
		//Couleur de fond
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.BLUE);
		
			
	/*------------------------------------------------------------------------------------*/
		
		//Organisation panel1
		panel1.setLayout(new BorderLayout());
		panel1.add(panel2,BorderLayout.CENTER);
		panel1.add(info, BorderLayout.EAST);
		
		//Organisation panel2
		panel2.setLayout(new BorderLayout());
		//panel2.add(b1, BorderLayout.NORTH);
		
		MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);
		
		panel2.add(dashboard, BorderLayout.CENTER);
		panel2.add(panel4, BorderLayout.SOUTH);

		
		
		
		//Organisation panel4
		panel4.setLayout(new FlowLayout());
		panel4.add(label3);
		panel4.add(b2);
		panel4.add(b3);
		
		//Organisation frame
		frame.add(panel1);
		
	/*------------------------------------------------------------------------------------*/
		//Gestion des boutton
		
			
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(combinaison.verification()) {
					
					for(int i= joueur.getJoueur(joueur.size()-1).TailleMain()-1; i>=0;i--) {
						if(!combinaison.isNotInNewCombinaison(joueur.getJoueur(joueur.size()-1).getCarte(i))) {
							joueur.getJoueur(joueur.size()-1).JouerCarte(i);

							
						}
					}
					combinaison.setLastCombinaison();
					dashboard.repaint();
					if(joueur.getJoueur(joueur.size()-1).TailleMain()==0) {
						partie.ComptagePoint();
						dashboard.setPartiefini(true);
					}else {
						int vainqueur=joueur.size()-1;
						for (int j=0; j < joueur.size()-1 ; j++) {
							
							if(!joueur.getJoueur(j).getCouche()) {
								if (partie.JouerBot(joueur.getJoueur(j))) {
									combinaison.setNewCombinaison(combinaison.VerifPlay(joueur.getJoueur(j)));
									for(int i= joueur.getJoueur(j).TailleMain()-1; i>=0;i--) {
										if(!combinaison.isNotInNewCombinaison(joueur.getJoueur(j).getCarte(i))) {
											joueur.getJoueur(j).JouerCarte(i);
											
										}
									}
									
									combinaison.setLastCombinaison();
									dashboard.repaint();
									if(joueur.getJoueur(j).TailleMain()==0) {
										vainqueur=j;
										partie.ComptagePoint();
										dashboard.setPartiefini(true);
										
									}
								}else {
								}
								dashboard.repaint();
								System.out.println("dashboard.repaint();");
								System.out.println(partie.EtatJoueur());
							}
							dashboard.repaint();
							
						}
						if(joueur.getJoueur(vainqueur).TailleMain()==0) {
							dashboard.setPartiefini(true);
							
						}else {
							if(partie.FinManche()) {
								System.out.println(partie.EtatJoueur());
								int j=partie.DernierJoueurManche();
								System.out.println("Vainqueur Manche : Joueur "+j);
								dashboard.repaint();
								partie.NewManche();
								combinaison.initCombinaison();
								for (; j < joueur.size()-1 ; j++) {
									
									if (partie.JouerBot(joueur.getJoueur(j))) {
										combinaison.setNewCombinaison(combinaison.VerifPlay(joueur.getJoueur(j)));
										for(int i= joueur.getJoueur(j).TailleMain()-1; i>=0;i--) {
											if(!combinaison.isNotInNewCombinaison(joueur.getJoueur(j).getCarte(i))) {
												joueur.getJoueur(j).JouerCarte(i);
												dashboard.repaint();
											}
										}
								
										combinaison.setLastCombinaison();
										dashboard.repaint();
										if(joueur.getJoueur(j).TailleMain()==0) {
											vainqueur=j;
											partie.ComptagePoint();
											dashboard.setPartiefini(true);
											
										}
									}else {
									}
									dashboard.repaint();
								}
						}else {
							System.out.println("La Manche n'est pas fini");
						}
					}
						
				}
					
			}else {
				System.out.println("Mauvais Combinaison");
			}
		}
	});
			
			
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(combinaison.getLastCombinaison().size()!=0) {
					joueur.getJoueur(joueur.size()-1).setCouche(true);
					System.out.println("Je passe mon tours !!!!!!");
					System.out.println(partie.EtatJoueur());
					while(!partie.FinManche()) {
						for (int j=0; j < joueur.size()-1 ; j++) {
							
							if (partie.JouerBot(joueur.getJoueur(j))) {
								combinaison.setNewCombinaison(combinaison.VerifPlay(joueur.getJoueur(j)));
								for(int i= 0; i<joueur.getJoueur(j).TailleMain();i++) {
									if(!combinaison.isNotInNewCombinaison(joueur.getJoueur(j).getCarte(i))) {
										joueur.getJoueur(j).JouerCarte(i);
									}
								}
								combinaison.setLastCombinaison();
								if(joueur.getJoueur(j).TailleMain()==0) {
									partie.ComptagePoint();
									dashboard.setPartiefini(true);
								}
							}else {
								joueur.getJoueur(j).setCouche(true);;
								if(partie.FinManche()) {
									break;
								}
							}
							
							dashboard.repaint();
						}

					}
					System.out.println(partie.EtatJoueur());
					int j=partie.DernierJoueurManche();
					System.out.println("Vainqueur Manche : Joueur "+j);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					partie.NewManche();
					System.out.println("Manche :"+partie.getCompteur());
					combinaison.initCombinaison();
					for (; j < joueur.size()-1 ; j++) {
						
						if (partie.JouerBot(joueur.getJoueur(j))) {
							combinaison.setNewCombinaison(combinaison.VerifPlay(joueur.getJoueur(j)));
							for(int i= joueur.getJoueur(j).TailleMain()-1; i>=0;i--) {
								if(!combinaison.isNotInNewCombinaison(joueur.getJoueur(j).getCarte(i))) {
									joueur.getJoueur(j).JouerCarte(i);
									
								}
							}
							
							combinaison.setLastCombinaison();
							if(joueur.getJoueur(j).TailleMain()==0) {
								partie.ComptagePoint();
								dashboard.setPartiefini(true);
							}
					
						}else {
							System.out.println("Bot ne joue pas");
							joueur.getJoueur(j).setCouche(true);;
						}
						dashboard.repaint();
						System.out.println(partie.EtatJoueur());
					}
				}
			}
		});
		
		
	/*------------------------------------------------------------------------------------*/
		//Ouverture de la fenetre
		
		//Donne la taille de la fenetre
		frame.setSize(1000,520);
		    
		//Organisation de la fenetre principale (frame)
		frame.setLayout(new GridLayout(1,1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
			
		//Methode qui affiche la fenetre à l'écran
		frame.setVisible(true);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			dashboard.repaint();
		}
	}
	

	private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			boolean initpage=false;
			 
			for(int i=0; i<positionCarte.getSize();i++) {
				if(positionCarte.getCartePosition(i).isInCarte(x, y)) {
					combinaison.add(positionCarte.getCartePosition(i).getCarte());
					System.out.println(combinaison.getNewCombinaison().toString());
					System.out.println(combinaison.getNewCombinaison().size());
					initpage=true;
				}
			}
			
			//Quitter apres fin Partie
			if((x>=445 && x<=665) && (y>=270 && y<=320) && dashboard.getPartifini()) {
				System.out.println("Quitter");
				joueur.clear();
				combinaison.initCombinaison();
				frame.dispose();
				new PageOne();
			}
			
			//Rejouer Après fin Partie
			if((x>=305 && x<=425) && (y>=270 && y<=320) && dashboard.getPartifini()) {
				System.out.println("Rejouer");	
				frame.dispose();
				partie.VideMainJoueur();
				combinaison.initCombinaison();
				new PageJeu();
			}
			
			
			if((x>=250 && x<=650) && (y>=120 && y<=220) && dashboard.getPartiecommence()==false){
				dashboard.setPartiecommencer(true);
				partie.distribution();
				dashboard.repaint();
				
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
				joueur.clear();
				combinaison.initCombinaison();
				frame.dispose();
				new PageOne();
			}
			
			if(initpage) {
				dashboard.repaint();
				System.out.println("OUI");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
		
		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
	
	
	private class PasserTours implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PageJeu();
	}
}
