/**
 *  Constructs a deck for Catch the Match's use.
 *
 *  @author  daphneliu
 *  @version Jun 1, 2016
 *  @author  Period: 5
 *  @author  Assignment: game
 *
 *  @author  Sources: TODO
 */
public class MatchDeck extends Deck
{
        /**
     * Constructs a deck for Catch the Match.
     */
    public MatchDeck()
    {
        for ( int i = 1; i <= 3; i++ )
        {
            for ( int shape = 1; shape <= 3; shape++ )
            {
                for ( int fill = 1; fill <= 3; fill++ )
                {
                    for ( int color = 1; color <= 3; color++ )
                    {
                        //fill++;
                        add( new MatchCard( i, shape, fill, color ) );
                    }
                }
            }
        }
    }
}