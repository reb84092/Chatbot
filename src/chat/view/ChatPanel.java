package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout; //For layout
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.Color;
import chat.control.ChatbotControl;

/**
 * @author rbar3155
 * @version 0.1 Nov 23, 2015
 *
 */
public class ChatPanel extends JPanel
{
	private ChatbotControl baseController;
	private JButton chatButton;
	private JTextField chatTextField;
	private SpringLayout baseLayout;

	public ChatPanel(ChatbotControl baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		chatButton = new JButton("Please do not click the button");
		chatTextField = new JTextField("Words can be typed here");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Helper method to load all Chatbot components into the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(chatTextField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 107, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -32, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, 37, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextField, -24, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatTextField.setText("Wow, this is the most amazing click event ever! WOW!");
			}
		});
		
	}
}
