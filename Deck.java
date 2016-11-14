/***************************************************************************
* This class creates a deck of card objects in order of how a brand new 
* deck would look and sends that deck back to shoe
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
public class Deck {
	
	private static CardRank[] ranks;
	private static CardSuit[] suits;
	private Card card;
	private Object[] theDeck;

	/** This constructor builds a deck
	 *  from ranks and suits
	 *  
	 * @param ranks
	 * @param suits
	 */
	public Deck(CardRank[] ranks, CardSuit[] suits)
	{
		Deck.ranks = ranks;
		for (int i = 0; i < ranks.length; i++)
		{
			Deck.ranks[i] = ranks[i];
		}
		Deck.suits = suits;
		for (int i = 0; i < suits.length; i++)
		{
			Deck.suits[i] = suits[i];
		}
		
		theDeck = new Object[52];
		
	}
	
	/** This method builds the deck
	 *  as if it was brand new and just being
	 *  opened. The cards are all in order.
	 * @return An array of card objects
	 */
	public Object[] createDeck()
	{	
		int counter = 0;
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				card = new Card(ranks[j], suits[i]);
				theDeck[counter] = card;
				counter++;
			}
			
		}
		
		return theDeck;
	}
	
}
