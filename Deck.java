
import java.util.ArrayList;
import java.util.Collections;


/**
 * Creates a deck for cards.
 *
 * @author siriwansereesathien
 * @version Jun 1, 2016
 * @author Period: 5
 * @author Assignment: game
 *
 * @author Sources: TODO
 */
public class Deck extends Object
{
    private ArrayList<Card> dec;


    /**
     * Constructs an empty deck of cards
     */
    public Deck()
    {
        dec = new ArrayList<Card>();
    }


    /**
     * Constructs a deck of cards with a certain size
     * 
     * @param capacity
     *            size of deck
     */
    public Deck( int capacity )
    {
        dec = new ArrayList<Card>( capacity );
    }


    /**
     * Returns the number of cards in the deck.
     * 
     * @return number of cards in deck
     */
    public int getNumCards()
    {
        return dec.size();
    }


    /**
     * Indicates whether the deck is empty or not.
     * 
     * @return true if deck is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return dec.isEmpty();
    }


    /**
     * Adds a given card at the top of the deck.
     * 
     * @param card
     *            card to be added
     */
    public void add( Card card )
    {
        dec.add( card );

    }


    /**
     * Removes and returns the top card from this deck.
     * 
     * @return top card
     */
    public Card takeTop()
    {
        if ( !dec.isEmpty() )
        {
            return dec.remove( getNumCards() - 1 );
        }
        else
            return null;
        // return isEmpty() ? null : dec.remove( getNumCards() - 1 );
    }


    /**
     * Shuffles the deck
     */
    public void shuffle()
    {
        Collections.shuffle( dec );
    }


    /**
     * Sorts the deck in ascending order of IDs
     */
    public void sort()
    {
        Collections.sort( dec );
    }


    /**
     * Returns the string representation of the deck
     * 
     * @returns String representation of this deck
     */
    public String toString()
    {
        String x = "";
        for ( Card d : dec )
        {
            x += d.toString() + " ";
        }
        return x;
    }

}