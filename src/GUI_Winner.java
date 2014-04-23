import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.*;

public class GUI_Winner extends GUI_EndScreen {    
    public GUI_Winner(String answer,JFrame frame) {
    	super(answer, frame);
    }

	@Override
	void setUpLabels(String answer) {
		ImageIcon background = new ImageIcon("Congrats.gif");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		
		JPanel imagePanel = (JPanel) mainFrame.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new FlowLayout());
		
	    JLabel answerLabel = new JLabel("The answer is ");
	    JLabel secretWordLabel = new JLabel(answer);
	    secretWordLabel.setFont(new Font("Default",Font.PLAIN,23));
	    secretWordLabel.setForeground(Color.red);
	    
	    JLabel gameResultLabel = new JLabel("You are winner!");
	    
	    mainFrame.getLayeredPane().setLayout(null);
	    mainFrame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	    
	    mainFrame.add(answerLabel);
	    mainFrame.add(secretWordLabel);
	    mainFrame.add(gameResultLabel);
	}
}