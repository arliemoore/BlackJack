/***************************************************************************
* This class creates a shoe object that stores card objects.
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
public class Shoe {

	private Object[] shoe;
	private static Deck maker;
	private int numOfDecks = 0;
	
	/** This constuctor builds the shoe object
	 *  with the number of decks
	 * @param numOfDecks
	 */
	public Shoe(int numOfDecks)
	{
		shoe = new Object[numOfDecks * 52];
		
		this.numOfDecks = numOfDecks;
		
	}
	
	/** This method creates the shoe out of the 
	 *  number of decks that are being used to
	 *  play the game of blackjack. Once the shoe
	 *  is made it then shuffles the shoe by sending it
	 *  to the Util21 Class
	 * 
	 */
	public void createShoe()
	{
		Object[] temp = new Object[shoe.length];
		
		for (int k = 0; k < numOfDecks; k++)
		{
			maker = new Deck(CardRank.values(), CardSuit.values());
			temp = maker.createDeck();
			
			for (int i = 0; i < temp.length; i++)
			{
				shoe[(k * 52) + i] = temp[i];
			}
			
		}
		Util21.shuffle(shoe);											//shuffles the shoe
	}
	
	/** This method draws a card from the shoe
	 *  and then returns that hard to be placed
	 *  into the hand of the player. It then makes
	 *  that card slot null.
	 *  
	 * @param index
	 * @return card object
	 */
	public Card removeCard(int index)
	{
		Card card;
		card = (Card) shoe[index];
		shoe[index] = null;
		return card;
	}
	
	/** This method gets the index
	 *  that the shoe is currently at
	 *  in the array of card objects
	 * @return int index
	 */
	public int getDeckIndex()
	{
		int index = 0;
		boolean done = false;
		
		for (int i = 0; i < shoe.length && !(done); i++)
		{
			if (shoe[shoe.length - 1] != null)
			{
				index = shoe.length - 1;
				done = true;
			}
			if (shoe[i] == null && !done)
			{
				index = i - 1;
				done = true;
			}
		}
		return index;
	}
		
}
