package chat.model;

import java.util.ArrayList;

/**
 * Base version of the Chatbot class. Only stub methods are provided. Students will complete method as part 
 * of the project.
 * @author rbar3155
 * @version 1.2 10/23/15 Completed the lengthChecker method. Fixed the Constructor and getter for userName
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/** Creates an instance of the Chatbot with the supplied username.*/
	public Chatbot(String userName)
	{
		this.userName = userName;
	}
	
	private void buildMemesList()
	
	private void buildPoliticalTopicsList()
	
	/** Checks the length of the supplied string.*/
	public boolean lengthChecke(String currentInput)