import javax.swing.*;

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
	    super.addReturnBtn();
	    mainFrame.add(loserPic);
	}	
}