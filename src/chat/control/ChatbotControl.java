package chat.control;

import chat.model.Chatbot;
import chat.view.ChatView;

public class ChatbotControl
{
	
	private Chatbot simpleBot;
	private ChatView display;
	
	public ChatbotControl()
	{
		display = new ChatView();
		String userName = display.collectUserTest("What is your name?");
		simpleBot = new Chatbot(userName);
	}
	
	public void start()
	{
		display.displayText("Hello" + simpleBot.getUserName());
	}
}