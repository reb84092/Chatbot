package chat.view;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout; //For layout

import java.awt.event.*;
import java.awt.Color;

import chat.controller.ChatController;

/**
 * @author rbar3155
 * @version 0.1 Nov 23, 2015
 *
 */
public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton chatButton;
	private JTextField chatTextField;
	

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		chatButton = new JButton("Please do not click the button");
		chatTextField = new JTextField("Words can be typed here");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

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

	public JComponent getTextField()
	{
		// TODO Auto-generated method stub
		return null;
	}


}
