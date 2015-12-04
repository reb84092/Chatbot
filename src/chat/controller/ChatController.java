package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;

/**
 * Controller for the Chatbot project.
 */
public class ChatController
{

	private Chatbot simpleBot;
	private ChatView display;

	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserText("What is your name?");
		simpleBot = new Chatbot(userName);
	}

	public void start()
	{
		display.displayText("Hello" + simpleBot.getUserName());
		chat();
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

	private void shutDown()
	{
	}
}