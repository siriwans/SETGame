/**
 * Provides static methods for finding sets.
 *
 * @author daphneliu
 * @version Jun 1, 2016
 * @author Period: 5
 * @author Assignment: game
 *
 * @author Sources: TODO
 */
public class MatchAnalyzer extends Object
{
    /**
     * Finds a correct match from the given array of cards.
     * 
     * @param cards
     *            an array of "matched" cards
     * @return An array that shows the indices of a valid set if found,
     *         otherwise returns null.
     */
    public static int[] findMatch( MatchCard[] cards )
    {
        for ( int i = 0; i < cards.length - 2; i++ )
        {
            if ( cards[i] != null )
                for ( int j = i + 1; j < cards.length - 1; j++ )
                {
                    if ( cards[j] != null )
                        for ( int k = j + 1; k < cards.length; k++ )
                        {
                            if ( cards[k] != null )
                            {
                                if ( isMatch( cards[i], cards[j], cards[k] ) )
                                {
                                    return new int[] { i, j, k };
                                }
                            }
                        }
                }

        }
        return null;
    }


    /**
     * Checks to see if the cards form a match, false otherwise.
     * 
     * @param card1
     *            first card
     * @param card2
     *            second card
     * @param card3
     *            third card
     * @return true if card1, card2 and card3 form a match, false otherwise.
     */
    public static boolean isMatch(
        MatchCard card1,
        MatchCard card2,
        MatchCard card3 )
    {
        if ( card1.equals( card2 ) && card2.equals( card3 )
            && card3.equals( card1 ) )
        {
            return true;
        }
        else if ( !validMatch( card1.getColor(),
            card2.getColor(),
            card3.getColor() )
            && !validMatch( card1.getFill(), card2.getFill(), card3.getFill() )
            && !validMatch( card1.getShape(),
                card2.getShape(),
                card3.getShape() )
            && !validMatch( card1.getNumber(),
                card2.getNumber(),
                card3.getNumber() ) )
        {
            return true;
        }
        else if ( !validMatch( card1.getColor(),
            card2.getColor(),
            card3.getColor() )
            || !validMatch( card1.getFill(), card2.getFill(), card3.getFill() )
                && !validMatch( card1.getShape(),
                    card2.getShape(),
                    card3.getShape() )
                && !validMatch( card1.getNumber(),
                    card2.getNumber(),
                    card3.getNumber() ) )
        {
            return true;
        }
        else if ( !validMatch( card1.getColor(),
            card2.getColor(),
            card3.getColor() )
            && !validMatch( card1.getFill(), card2.getFill(), card3.getFill() )
            || !validMatch( card1.getShape(),
                card2.getShape(),
                card3.getShape() )
                && !validMatch( card1.getNumber(),
                    card2.getNumber(),
                    card3.getNumber() ) )
        {
            return true;
        }
        else if ( !validMatch( card1.getColor(),
            card2.getColor(),
            card3.getColor() )
            && !validMatch( card1.getFill(), card2.getFill(), card3.getFill() )
            && !validMatch( card1.getShape(),
                card2.getShape(),
                card3.getShape() )
            | !validMatch( card1.getNumber(),
                card2.getNumber(),
                card3.getNumber() ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Checks to see if the properties are a valid match. Given the three cards
     * (a, b, c), they are all equal or all different if (a + b + c) % 3 == 0.
     * This property can be used for testing three cards for a set.
     * 
     * @param card1
     *            first card
     * @param card2
     *            second card
     * @param card3
     *            third card
     * @return
     */
    public static boolean validMatch( int card1, int card2, int card3 )
    {
        return !( card1 != card2 && card2 != card3 && card3 != card1 );
    }

}