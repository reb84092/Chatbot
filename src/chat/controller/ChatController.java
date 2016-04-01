package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatView;
import chat.model.CTECTwitter;
import twitter4j.TwitterException;

/**
 * Controller for the Chatbot project.
 */
public class ChatController
{
	private CTECTwitter chatTwitter;
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;

	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserText("What is your name?");
		simpleBot = new Chatbot(userName);
		chatTwitter = new CTECTwitter(this);
		baseFrame = new ChatFrame(this);
	}

	public void start()
	{
		display.displayText("Hello" + simpleBot.getUserName());
		//chat();
	}

	public String analyze(String userName)
	{
		String userAnalysis = "This topic " + userName + " has many tweets. ";
		userAnalysis += chatTwitter.sampleInvestigation();
		return userAnalysis;
	}
	
	private void chat()
	{
		String conversation = display.collectUserText("What would you like to talk about today?");
		while (simpleBot.lengthChecker(conversation))
		{
			if (simpleBot.contentChecker(conversation))
			{
				display.displayText("Wow, I had no idea you are interested in " + simpleBot.getContent());
			}
			else if (simpleBot.contentChecker(conversation))
			{
				display.displayText("What a lame meme :(");
			}

			conversation = display.collectUserText(conversation);
		}
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}


	
	private void shutDown()
	{
	}

	public Object getChatView()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ChatFrame getBaseFrame()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public void sendTweet(String tweetText)
	{
		chatTwitter.sendTweet(tweetText);
	}
	
	public void handleErrors(String errorMessage)
	{
		display.displayText(errorMessage);
	}
}