package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Pop up display class for GUI interaction in the Chatbot project.
 * @author rbar3155
 * @version 1.3 11/5/15 Added Icons to pop up windows!
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Hello from your friendly chatbot :D";
		chatIcon = new ImageIcon(getClass().getResource("images/download.jpeg"));
	}
	
	/**
	 * Displays a GUI pop up from collecting user text with the supplied String.
	 * Usually in the form of a question to collect for further use in the program.
	 * @param textDisplay The text to show in the pop up window. Should be a question
	 * @return The text supplied by the user.
	 */
	public String collectUserText(String textDisplay)
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog(null, textDisplay, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here :)").toString();
		
		return userInput;
	}
	
	/**
	 * Displays a String to the user with a standard pop up.
	 * @param textDisplay The supplied text to be displayed.
	 */
	public void displayText(String textDisplay)
	{
		JOptionPane.showMessageDialog(null, textDisplay, windowMessage, JOptionPane.INFORMATION_MESSAGE,chatIcon);
	}
}
