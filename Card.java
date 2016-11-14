/***************************************************************************
* This class creates cards that have a suit and a rank
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
public class Card {

	private CardRank rank;
	private CardSuit suit;
	
	/** This constructor builds the card which
	 *  is defined as its suit and rank
	 * @param rank
	 * @param suit
	 */
	public Card(CardRank rank, CardSuit suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	/** This method returns the rank of the card
	 * @return rank
	 */
	public CardRank getRank()
	{
		return this.rank;
	}
	
	/** this method returns the suit of the card
	 * @return suit
	 */
	public CardSuit getSuit()
	{
		return this.suit;
	}
	
	/** This method finds out the value of
	 *  the rank of the card in a BlackJack game
	 *  
	 * @return int value of the card
	 */
	public int getCardValue()
	{
		int value = 0;
		
		switch (rank)
		{
		case ACE: value = 1;
		  break;
		case TWO: value = 2;
		  break;
		case THREE: value = 3;
		  break;
		case FOUR: value = 4;
		  break;
		case FIVE: value = 5;
		  break;
		case SIX: value = 6;
		  break;
		case SEVEN: value = 7;
		  break;
		case EIGHT: value = 8;
		  break;
		case NINE: value = 9;
		  break;
		case TEN: value = 10;
		  break;
		case JACK: value = 10;
		  break;
		case QUEEN: value = 10;
		  break;
		case KING: value = 10;
		  break;
		}
		
		return value;
	}
	
	/** Creates a string of the card with its rank and suit
	 * 
	 * @return string
	 */
	public String getString()
	{
		String result;
		
		result = String.format("%s/%s", rank.toString(), suit.toString());
		
		return result;
	}
	
}
