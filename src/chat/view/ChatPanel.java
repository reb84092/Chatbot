package chat.view;

import javax.swing.*;

import java.awt.event.*;
import java.awt.Color;

import chat.controller.ChatController;
import chat.controller.IOController;

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
	private JButton saveButton;
	private JButton loadButton;
	private JLabel promptLabel;

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		chatButton = new JButton("Please do not click the button");
		tweetButton = new JButton("Tweet button");
		chatTextField = new JTextField("Words can be typed here");
		analyzeTwitterButton = new JButton("Analyze tweets");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		promptLabel = new JLabel("Information here");

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
		this.add(saveButton);
		this.add(loadButton);
		this.add(promptLabel);
		this.add(analyzeTwitterButton);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 107, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -32, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, 37, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextField, -24, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -36, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 77, SpringLayout.EAST, tweetButton);

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

		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String file = IOController.saveFile(chatArea.getText());
				promptLabel.setText(file);
			}
		});

		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText = IOController.readTextFromFile(promptLabel.getText());
				chatArea.setText(loadedText);
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
				String results = baseController.analyze("");
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
