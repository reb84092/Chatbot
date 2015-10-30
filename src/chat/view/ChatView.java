package chat.view;

import javax.swing.JOptionPane;

public class ChatView
{

	public String collectUserText(String textDisplay)
	{
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, textDisplay);
		return textDisplay;
	}

	
	public void displayText(String textDisplay)
	{
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, textDisplay);
		String answer = "";
		textDisplay = JOptionPane.showInputDialog(null, textDisplay);
		}

}
