/**
 * Represents a card for the game Catch the Match. A card has four attributes:
 * the number: (1, 2, or 3), the shape: (oval, squiggle, or diamond), the fill
 * (outlined, solid, or striped), and the color (red, green, or blue). Each
 * attribute is shown by either 2, 2, or 3.
 *
 * @author daphneliu
 * @version Jun 1, 2016
 * @author Period: 5
 * @author Assignment: game
 *
 * @author Sources: TODO
 */
public class MatchCard extends Card
{
    /**
     * number of symbols on card
     */
    private int number;

    /**
     * shape of card
     */
    private int shape;

    /**
     * fill of card
     */
    private int fill;

    /**
     * color of card
     */
    private int color;


    /**
     * Constructs a Match game card with the four attributes.
     * 
     * @param n
     *            number
     * @param s
     *            shape
     * @param f
     *            fill
     * @param c
     *            color
     */
    public MatchCard( int n, int s, int f, int c )
    {
        super( 81 );
        number = n;
        shape = s;
        fill = f;
        color = c;
    }


    /**
     * Returns the color code of the card: 1 for red, 2 for green, 3 for blue.
     * 
     * @return color code of card
     */
    public int getColor()
    {
        return color;
    }


    /**
     * Returns the fill code of the card: 1 for outlined, 2 for solid, 3 for
     * striped.
     * 
     * @return fill code of card
     */
    public int getFill()
    {
        return fill;
    }


    /**
     * returns the number of symbols on the card.
     * 
     * @return number of symbols on card
     */
    public int getNumber()
    {
        return number;
    }


    /**
     * returns the shape code of the card: for oval, 2 for squiggle, 3 for
     * diamond.
     * 
     * @return shape code of card
     */
    public int getShape()
    {
        return shape;
    }


    /**
     * compares 2 cards' attributes to be exactly the same
     * 
     * @param obj another card
     * @return shape code of card
     */
    public boolean equals( Object obj )
    {
        // System.out.println("comparing");
        if ( !( obj instanceof MatchCard ) )
        {

            return false;
        }
        else
        {
            MatchCard other = (MatchCard)obj;
            return ( other.getShape() == getShape() )
                && ( other.getFill() == getFill() )
                && ( other.getColor() == getColor() )
                && ( other.getNumber() == getNumber() );
        }

    }


    /**
     * Returns a string representation of the card.
     * 
     * @return string representation of card
     */
    public String toString()
    {
        return String.format( "<MatchCard number=%d shape=%d fill=%d color=%d>",
            number,
            shape,
            fill,
            color );
    }

}