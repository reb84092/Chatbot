package chat.model;

import twitter4j.*;
import chat.controller.ChatController;
import java.util.ArrayList;

/**
 * @RachelBarnes
 * @1.1 First part of Twitter project
 */
public class CTECTwitter {

	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ArrayList<String> tweetTexts;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController) {
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		chatbotTwitter = TwitterFactory.getSingleton();
		tweetTexts = new ArrayList<String>();
	}

	public void sendTweet(String tweet) {
		try 
		{
			chatbotTwitter
					.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		} 
		catch (TwitterException error) 
		{

			baseController.handleErrors(error.getErrorMessage());
		}

	}
}