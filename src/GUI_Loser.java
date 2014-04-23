import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Set;

import javax.sound.sampled.*;

public class GUI_Loser extends GUI_EndScreen {

	public GUI_Loser(String answer, JFrame frame) {
		super(answer, frame);
	}

	@Override
	void setUpLabels(String answer) {
		JLabel secretWordLabel = new JLabel("The answer is " + answer + ".");
      	JLabel gameResultLabel = new JLabel("You are the Loser!");
	    JLabel loserPic = new JLabel(new ImageIcon("loser.gif"));
	    
	    mainFrame.add(secretWordLabel);
	    mainFrame.add(gameResultLabel);
	    mainFrame.add(loserPic);
	}	
}