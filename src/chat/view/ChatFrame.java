package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatController;

import javax.swing.JOptionPane;

/**
 * @author rbar3155
 * @version 0.1 Nov 30 2015
 * 
 */
public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
				
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setVisible(true);
	}

	public ChatController getBaseController()
	{
		return baseController;
	}

}