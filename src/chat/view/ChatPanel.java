package chat.view;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout; //For layout
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

import chat.controller.ChatController;

/**
 * @author rbar3155
 * @version 1.0 March 11, 2016
 *
 */
public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton chatButton;
	private JTextField chatTextField;
	private JButton tweetButton;
	private JTextArea chatArea;
	private JButton analyzeTwitterButton;

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		chatButton = new JButton("Please do not click the button");
		tweetButton = new JButton("Tweet button");
		chatTextField = new JTextField("Words can be typed here");
		analyzeTwitterButton = new JButton("Analyze tweets");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(chatTextField);
		this.add(tweetButton);
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

		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("no text to send");
			}
		});

		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = chatTextField.getText();
				String results = baseController.analyze(user);
				chatArea.setText(results);
			}

		});
	}
	
	
	public JComponent getTextField()
	{
		// TODO Auto-generated method stub
		return null;

	}
}
