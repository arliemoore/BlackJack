import java.util.ArrayList;
import java.util.Scanner;
/***************************************************************************
* This class creates the players that play the blackjack game.
*
* @author Arlie Moore
* @version Vn - 4/1/2014
*  PA5 - Game of BlackJack
***************************************************************************/
/***************************************************************************
* References and Acknowledgements: I received no outside help with this
* programming assignment
*
 ***************************************************************************/

public class Player {
	
	private ArrayList<Card> hand;									//creates a hand of Card objects
	private String playerName;
	private int deckIndex;
	private Shoe shoeMaker;											//the shoe object to retrieve cards from the shoe

	/** This constructor builds a player object
	 * 
	 * @param playerName
	 * @param shoeMaker
	 */
	public Player (String playerName, Shoe shoeMaker)
	{		
		this.playerName = playerName;
		this.shoeMaker = shoeMaker;
		hand = new ArrayList<Card>();
		deckIndex = shoeMaker.getDeckIndex();
	}
	
	/** This method plays the hand of the player
	 * 
	 * @param keyboard
	 * @param prompt
	 * @return
	 */
	public boolean playerTurn(Scanner keyboard, String prompt)
	{
		boolean keepPlaying = true;
		boolean turnOver = false;
		
		while (!(turnOver))
		{
			if (Util21.readYesNo(keyboard, prompt))					//finds out if the user wants a hit
			{
				takeHit();
				if (getScore() > 21)								//checks if the hit busted them
				{
					keepPlaying = false;
					turnOver = true;
					System.out.printf("%s Busted!\n", playerName);
				}
			}
			else 
			{
				turnOver = true;
			}
		}
		
		return keepPlaying;											//returns true if the player did not bust
	}
	
	/** This method plays the hand of the dealer
	 * 
	 */
	public void dealerTurn()
	{
		while (getScore() < 17)											//if score is less than 17, take a hit
		{
			System.out.printf("  Total is %d, dealer takes a card.\n", getScore());
			takeHit();
			if (getScore() > 21)
			{
				System.out.printf("%s Busted!\n", playerName);			//checks if they busted
			}
		}
	}
	
	/** This method adds up the score of the player
	 *  or the dealer hand and returns it as an int.
	 *  
	 * @return int score of the hand
	 */
	public int getScore()
	{
		int score = 0;
		int aceCounter = 0;
		

		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).getString().contains("ACE"))			//if there is an ace it adds one.
			{
				aceCounter++;
			}
			score = score + ((Card) hand.get(i)).getCardValue();	
		}
		
		if (score + (10 * aceCounter) <= 21)						//checks to see which score to use
		{															//because aces can either be 11 or 1
			score = score + (10 * aceCounter);
		}
		
		
		return score;
	}
	
	/** Takes a hit and an adds the card object
	 *  to the player or dealers hand. Also prints
	 *  the card that was drawn from the shoe.
	 * 
	 */
	public void takeHit()
	{	
		deckIndex = shoeMaker.getDeckIndex();
		hand.add(shoeMaker.removeCard(deckIndex));
		if (playerName.equalsIgnoreCase("Dealer") && hand.size() == 1) 			//blacks out the dealers first card
		{
			System.out.printf("  %s\n", "????/????");
		}
		else
		{
			System.out.printf("  %s\n", hand.get(hand.size() - 1).getString());
		}
}
	
	/** This method takes the hand of the player or dealer
	 *  and prints all of it cards with the score
	 *  and the player name.
	 *  
	 * @return a String
	 */
	public String printHand()
	{
		String cards = ""; 
		
		for (int i = 0; i < hand.size(); i++)
		{
			if (cards.length() == 0)
			{
				cards = hand.get(i).getString();
			}
			else
			{
				cards = String.format("%s %s", cards, hand.get(i).getString());
			}
		}
		
		cards = String.format("%s: %2s pts, (%s)",playerName, getScore(), cards);
		
		return cards;
	}
	
	/** This method prints the first hand
	 *  of the dealer which has the first
	 *  card hidden from the players view
	 *  
	 * @return the string
	 */
	public String printDealerHand()
	{
		String cards = ""; 
		
		for (int i = 0; i < hand.size(); i++)
		{
			if (cards.length() == 0)
			{
				cards = "????/????";
			}
			else
			{
				cards = String.format("%s %s", cards, hand.get(i).getString());
			}
		}
		
		cards = String.format("%s: %2s pts, (%s)",playerName, "??", cards);
		
		return cards;
	}
	
	/** This method checks if the player 
	 *  has busted.
	 *  
	 * @return boolean
	 */
	public boolean hasBusted()
	{
		boolean busted = false;
		
		if (getScore() > 21)
		{
			busted = true;
		}
		
		return busted;
	}
	
}
