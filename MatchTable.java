/**
 * Represents a card table with a deck and an array of open cards for the game
 * Catch the Match.
 *
 * @author siriwansereesathien
 * @version Jun 1, 2016
 * @author Period: 5
 * @author Assignment: game
 *
 * @author Sources: TODO
 */
public class MatchTable extends Object
{

    private final int dfltOpenCards = 12;

    private final int max = 21;

    int numOpen;

    private MatchDeck dec;

    MatchCard[] opened;


    /**
     * Creates a new deck and opens dfltOpenCards cards.
     */
    public MatchTable()
    {
        dec = new MatchDeck();
        opened = new MatchCard[max];
        dec.shuffle();

        for ( int i = 0; i < dfltOpenCards; i++ )
        {
            opened[i] = ( (MatchCard)dec.takeTop() );
        }
        numOpen = dfltOpenCards;
    }


    /**
     * Returns the number of cards left in the deck.
     * 
     * @return number of cards left in the deck
     */
    public int cardsInDeck()
    {
        return dec.getNumCards();
    }


    /**
     * Returns the open card with a given index. If the index is out of bounds
     * or the card with this index isn't open, returns null.
     * 
     * @param i
     *            given index
     * @return open card with given index, or null if the index is out of
     *         bounds.
     */
    public MatchCard getOpenCard( int i )
    {
        return i < 0 || i >= opened.length || opened[i] == null ? null
            : opened[i];
    }


    /**
     * Indicates whether there is a enough of open cards.
     * 
     * @return true if numOpenCards >= dfltOpenCards; false otherwise.
     */
    public boolean enoughOpen()
    {
        return numOpen >= dfltOpenCards;
    }


    /**
     * Finds a match in the open cards.
     * 
     * @return an array of the indices of the three matched cards, or null if no
     *         matches are found.
     */
    public int[] findMatch()
    {
        return MatchAnalyzer.findMatch( opened );
    }


    /**
     * Opens three cards from the deck if three cards are available in the deck.
     * 
     * @return true if the cards are opened; false otherwise.
     */
    public boolean open3Cards()
    {
        if ( dec.getNumCards() < 3 )
        {
            return false;
        }
        else
        {
            for ( int i = 0; i < 3; i++ )
            {
                for ( int j = 0; j < opened.length; j++ )
                {
                    if ( opened[j] == null )
                    {
                        opened[j] = (MatchCard)dec.takeTop();
                        numOpen++;
                        break;
                    }
                }
            }
        }
        return true;
    }


    /**
     * Removes three cards with given indices from the open cards.
     * 
     * @param indices
     *            the given indices
     */
    public void remove3Cards( int[] indices )
    {
        for ( int i = 0; i < 3; i++ )
        {
            opened[indices[i]] = null;
            numOpen--;
        }

    }


    /**
     * If there are gaps in the first dfltOpenCards and some open cards beyond
     * dfltOpenCards, the open cards beyond dfltOpenCards are moved to fill the
     * gaps.
     */
    public void compactOpenCards()
    {
        for ( int i = 0; i < dfltOpenCards; i++ )
        {
            if ( opened[i] == null )
            {
                for ( int j = opened.length - 1; j > i; j-- )
                {
                    if ( opened[j] != null )
                    {
                        opened[i] = opened[j];
                        opened[j] = null;
                        break;
                    }
                }
            }
        }

    }

    /**
     * Returns a string representation of this match table.
     * 
     * @returns a string that lists all the open cards (including null cards)
     *          followed by an '\n' character, and finally the count of cards
     *          left in the deck.
     */
    public String toString()
    {
        String x = "";
        for ( MatchCard cards : opened )
        {
            x += cards + "\n";
        }
        x += cardsInDeck();
        return x;
    }
}
