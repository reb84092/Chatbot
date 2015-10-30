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
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();		
		this.userName = userName;
		this.content = "";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("unhelpful high school teacher");
		this.memesList.add("aliens");
		this.memesList.add("what if I told you");
		this.memesList.add("me gusta y tu no");
		this.memesList.add("rare pepe");
		this.memesList.add("bad luck brian");
		this.memesList.add("spoderman");
		this.memesList.add("troll face");
	}
	
	private void buildPoliticalTopicsList()
	{
		
	}
	
	/** Checks the length of the supplied string.*/
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The suplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}

	public String getUserName()
	{
		return userName;
	}
/**
 * Returns the content area for this Chatbot instance.
 *@return the content area for this Chatbot instance.
 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 *Checks if supplied String matches ANY of the topics in the politicalTopicList. Returns
	 *true if it does find a match and false if it does not match.
	 *@param currentInput The supplied String to be checked.
	 *@return Whether the String is contained in  ArrayList.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		for(String meme : memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	public boolean quitmemeChecker(String currentInput)
	{
		boolean okToQuit = false;
		if(currentInput.equalsIgnoreCase("quit"))
		{
			okToQuit=true;
		}
	}
}