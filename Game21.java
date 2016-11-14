import java.util.Scanner;
import java.io.InputStream;

/******************************************************************
 * This class implements a Blackjack game
 * 
 *  author: Arlie Moore
 ********************************************************************/
/***************************************************************************
* References and Acknowledgements: I received no outside help with this
* programming assignment
*
 ***************************************************************************/
public class Game21
{
	public final static String HIT_PROMPT = "Hit?(y/n)\n";
	public final static String SHOW_CARD = "  %s\n";
	public final static String SHOW_HAND = "%s: %s\n";
	public final static String BUSTED = "%s Busted!\n";
	public final static String DEALER_CARD = "  Total is %d, dealer takes a card.\n";
	public final static String WINNER = "%s wins.\n";
	
	private static Shoe shoeMaker;					//a shoe object that points at the cards
	private static int numOfDecks = 0;				//amount of decks used in the game
	private static Scanner keyboard;				// Input scanners
	private Player[] players;						// an array of Player Objects

    /************************************************************
     * Method purpose: This constructor instantiates a blackjack 
     * game.
     * 
     * @param stream The input stream game input will be read from.
     * @param decks  Number of decks in the shoe
     ************************************************************/
    public Game21(Scanner stream, int decks)
    {
    	numOfDecks = decks;
    	
    	players = new Player[2];					//makes two players
    	
        shoeMaker = new Shoe(numOfDecks);			//makes a shoe with the number of decks
        
        keyboard = new Scanner(System.in);
    }

    /************************************************************
         * Method purpose: this method plays a single blackjack game
         * in this blackjack session.
     ************************************************************/
    public void playGame()
    {
    	 shoeMaker.createShoe();								//makes and shuffles shoe
    	 
    	 players[0] = new Player("Player", shoeMaker);			//creates the player
    	 players[1] = new Player("Dealer", shoeMaker);			//creates the dealer
    	 
    	 for (int i = 0; i < 2; i++)
    	 {
    		 players[0].takeHit();								//takes the first two hits for each player
    		 players[1].takeHit();
    	 } 
    	 System.out.println(players[0].printHand());			//prints their hands
    	 System.out.println(players[1].printDealerHand());
    	 
    	 if (players[0].playerTurn(keyboard, HIT_PROMPT))		//plays the player hand
    	 {
    		 if (players[1].getScore() < 17)					
    		 {
    		 System.out.println(players[0].printHand());
        	 System.out.println(players[1].printHand());
    		 }
    		 players[1].dealerTurn();							//plays the dealer hand
    	 }
    	 System.out.println(players[0].printHand());
    	 System.out.println(players[1].printHand());
    	 
    	 if (players[0].getScore() > players[1].getScore() && !(players[0].hasBusted()) || players[1].hasBusted())
    	 {
    		 System.out.printf(WINNER, "Player");
    	 }
    	 else if ((players[0].getScore() < players[1].getScore() && !(players[1].hasBusted()) || players[0].hasBusted()))
    	 {
    		 System.out.printf(WINNER, "Dealer");
    	 }
    	 else 
    	 {
    		 System.out.printf(WINNER, "Nobody");
    	 }
     }

    /************************************************************
         * Method purpose: creates a shuffled shoe, then outputs
         * the string representation of each card in the shoe, one per line.
         * in this blackjack session.
     ************************************************************/
    public void outputShoe()
    {
        shoeMaker.createShoe();

        
        for (int i = 0; i < 52 * numOfDecks; i++)
        {
        	System.out.println((shoeMaker.removeCard(shoeMaker.getDeckIndex())).getString());
        }
    }

}
