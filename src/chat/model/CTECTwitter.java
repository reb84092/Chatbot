package chat.model;

import twitter4j.*;

import java.util.ArrayList;

/**
 * @RachelBarnes
 * @1.1 First part of Twitter project
 */
public class CTECTwitter {

	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;

	public CTECTwitter() {
		statusList = new ArrayList<Status>();
	}

	public void sendTweet(String tweet) 
	{
		try {
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}