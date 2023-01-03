package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import class_traitement.Regle;

public class PageRegle {
	
	//JFrame
	JFrame frame= new JFrame();
	
	//JPanel
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	
	//JButton 
	JButton b1= new JButton("Retour");
	
	//JLabel
	JLabel label1= new JLabel("Règle du Jeu");
	
	//Règle
	Regle h= new Regle();
	
	//Textarea
	JTextArea textarea= new JTextArea();
	
	public PageRegle() {
		

/*------------------------------------------------------------------------------------*/
		//Taille d'Ecriture
		
		//Couleur des panels
		panel2.setBackground(Color.BLACK);
		panel3.setBackground(Color.BLACK);
	
		//Couleur texte
		label1.setForeground(Color.WHITE);
		
/*------------------------------------------------------------------------------------*/
	
	//Organisation panel1
		panel1.setLayout(new BorderLayout());
		panel1.add(textarea, BorderLayout.CENTER);	
		panel1.add(panel2, BorderLayout.SOUTH);
		panel1.add(panel3, BorderLayout.NORTH);
		
		
	//Organisation textarea
	    textarea.setText(h.toString());
	    textarea.setEditable(false);
	    textarea.setBorder(BorderFactory.createLineBorder(Color.BLACK,6));
	    //textarea.setFont(new Font(textarea.getFont().getName(), textarea.getFont().getStyle(), textarea.getFont().getSize()-4));
    
    //Organisation panel2
	    panel2.setLayout(new FlowLayout());
	    panel2.add(b1);
	 
	//Organisation panel3
	    panel3.add(label1);
	    
	//Organisation frame
	    frame.add(panel1);
	    frame.setSize(580, 450);
	    frame.setVisible(true);
		
		
	//Organisation frame
	frame.add(panel1);
		
		
/*------------------------------------------------------------------------------------*/	
	
	//Gestion des boutton
	
	//Boutton1
	b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			frame.dispose();
			new PageOne();
		}
		
	});
	
	
		
/*------------------------------------------------------------------------------------*/
	//Ouverture de la fenetre
	
	//Donne la taille de la fenetre
	frame.setSize(1000,500);
	    
	//Organisation de la fenetre principale (frame)
	frame.setLayout(new GridLayout(1,1));
	frame.setLocationRelativeTo(null);
		
	//Methode qui affiche la fenetre à l'écran
	frame.setVisible(true);
	}
	

/*------------------------------------------------------------------------------------*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PageRegle();
	}

}
