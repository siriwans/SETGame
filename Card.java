
/**
 * This class represents a generic Card with a given int ID.
 *
 * @author siriwansereesathien
 * @version Jun 1, 2016
 * @author Period: 5
 * @author Assignment: game
 *
 * @author Sources: TODO
 */
public class Card extends Object implements Comparable<Card>
{
    private int id;


    /**
     * Constructs a card with a given id.
     * 
     * @param id
     *            the id of the card
     */
    public Card( int id )
    {
        this.id = id;
    }


    /**
     * Returns the id of the card
     * 
     * @return id of the card
     */
    public int getId()
    {
        return id;
    }


    /**
     * Compares this card with the specified object for order.
     * 
     * @param other
     *            the card to be compared
     * @returns a negative integer, zero, or a positive integer as this card is
     *          less than, equal to, or greater than other.
     */
    public int compareTo( Card other )
    {
        if ( getId() - other.getId() == 0 )
        {
            return 0;
        }
        else if ( getId() - other.getId() < 0 )
        {
            return -1;
        }
        else
        {
            return 1;
        }

    }


    /**
     * Shows whether some other object is "equal to" this one.
     * 
     * @param other
     *            the reference object to compare with
     * @returns true if this object is the same as other; false otherwise.
     */
    public boolean equals( Object other )
    {
        if ( compareTo( (Card)other ) == 0 )
        {
            return true;
        }
        else
        {
            return false;
        }

    }


    /**
     * Returns a String representation of this card.
     * 
     * @returns String representation of this card
     */
    public String toString()
    {
        return "" + id;
    }

}
