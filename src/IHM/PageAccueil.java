package IHM;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
public class PageAccueil {
	
	String nom_fichier_image = "C:\\Users\\mathi\\OneDrive\\Images\\logojeu.jpg";
	JFrame frame= new JFrame();
	JButton b1 = new JButton("JOUER");
	JPanel panel1= new JPanel();
	

public PageAccueil() {
    
    
    JPanel panneau = new JPanel()
    {
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);

            ImageIcon m = new ImageIcon(nom_fichier_image);
            Image monImage = m.getImage();
            g.drawImage(monImage, 0, 0,this);

        }
    };
    
    //Gestion b1
    b1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
			new PageOne();
		}
    	
    });

    //ajouter le panneau à la fenétre.
    frame.setSize(493,500);
    frame.getContentPane().add(panneau);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    
    //Organisation panel1
    panel1.setLayout(new FlowLayout());
    panel1.add(b1);
    b1.setPreferredSize(new Dimension(120,60));
    frame.add(panel1);

}


public static void main(String [] args)
{
    new PageAccueil();
}
}