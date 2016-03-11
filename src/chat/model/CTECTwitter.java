package chat.model;

import twitter4j.*;
import chat.controller.ChatController;
import java.util.ArrayList;
import java.util.List;

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
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus: statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
		
	}
	
	private void removeEmptyText()
	{
		
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
	}
	
	public void sendTweet(String tweet) {
		try 
		{
			chatbotTwitter
					.updateStatus("Rachel just tweeted from my Java Chatbot" + "program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		} 
		catch (TwitterException error) 
		{

			baseController.handleErrors(error.getErrorMessage());
		}

	}
}