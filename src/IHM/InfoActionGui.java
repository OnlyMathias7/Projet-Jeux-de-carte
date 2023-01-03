package IHM;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class InfoActionGui extends JSplitPane {
	
	//JPanel 
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	
	//JLabel 
	JLabel label1= new JLabel("Action de Jeux");
	JLabel label2= new JLabel("Liste d'Action");
	JLabel label3= new JLabel("Chronomètre");
	
	//JScrollpane
	JScrollPane scroll1= new JScrollPane();
	
	//JSplitPane
	JSplitPane split1= new JSplitPane(SwingConstants.HORIZONTAL);
	
	
	public InfoActionGui() {
		
		//Organisation panel5
		panel1.setLayout(new BorderLayout());
		panel1.add(label1, BorderLayout.NORTH);
		panel1.add(scroll1, BorderLayout.CENTER);
		
		//Organisation panel3
		panel2.add(label3);
		
		//Organisation split1 
		setOrientation(SwingConstants.HORIZONTAL); 
		setTopComponent(panel2);
		setBottomComponent(panel1);
		setDividerLocation(40);
		
		
		//Organisation scroll1
		scroll1.add(label2);
	}

}
