/********************************************************************
 * An enumerated type for the ranks in a deck of cards.
 * @author Arlie Moore
 * @version 04/01/14
 ********************************************************************/
/***************************************************************************
* References and Acknowledgements: I received no outside help with this
* programming assignment
*
 ***************************************************************************/
public enum CardRank
{
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING

	//------------------------------------------------------
	// The following methods need not be declared, they are
	// automatically included with all enums.
	//------------------------------------------------------
	//public String toString();	       // CardRank.ACE.toString() -> "ACE"
	//public static CardRank[] values();  // CardRank.values() -> [ ACE, .. KING ]
	//public int ordinal();               // CardRank.ACE.ordinal() -> 0
                                               // CardRank.KING.ordinal() -> 12
}
