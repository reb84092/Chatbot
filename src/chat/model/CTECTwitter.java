package chat.model;

import twitter4j.*;
import chat.controller.ChatController;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

/**
 * @RachelBarnes
 * @1.1 First part of Twitter project
 */
public class CTECTwitter
{

	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ArrayList<String> tweetTexts;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
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
		for (Status currentStatus : statusList)
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
		for (int spot = 0; spot < tweetTexts.size(); spot++)
		{
			if (tweetTexts.get(spot).equals(""))
			{
				tweetTexts.remove(spot);
				spot--;
			}
		}
	}

	public String topResults(List<String> wordList)
	{
		String tweetResults = "";

		int topWordLocation = 0;
		int topCount = 0;

		for (int index = 0; index < wordList.size(); index++)
		{
			int wordUseCount = 1;
			
			for (int spot = index + 1; spot < wordList.size(); spot++)
			{
				if(wordList.get(index).equals(wordList.get(spot)))
				{
					wordUseCount++;
				}
				if (wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}

		tweetResults = "The top word in the tweets was " + wordList.get(topWordLocation) + " and it was used " + topCount + " times!";
		return tweetResults;

	}

	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();

		for (int count = 0; count < wordList.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{

				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}

			}
		}
		return wordList;
	}

	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile.reset();
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
		}
		catch (FileNotFoundException e)
		{
			return new String[0];
		}
		return boringWords;
	}

	private String removePunctuation(String currentString) // Goes through the
															// characters and
															// returns
															// everything that
															// isn't in the
															// punctuation list.
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";

		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}

	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("Rachel just tweeted from my Java Chatbot" + "program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException error)
		{

			baseController.handleErrors(error.getErrorMessage());
		}

	}
}