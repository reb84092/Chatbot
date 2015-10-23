package chat.control;

import chat.view.ChatbotView;
import chatbotmodel.java.ChatbotModel;
import chatbotmodel.java.ChatbotModel1;

public class ChatRunner
{
	
	private ChatbotView myDisplay;
	private ChatbotModel1 simpleBot;
	
	public ChatRunner()
	{
		myDisplay = new ChatbotView();
		String userName = myDisplay.collectUserText111("What is your name?");
		simpleBot = new ChatbotModel1(userName);
	}
	
	public void start()
	{
		
	}
}
