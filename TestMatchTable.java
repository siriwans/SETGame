
public class TestMatchTable
{
    public static void main( String[] args )
    {
        System.out.println( "Simulating one-sided game" );
        playGame();
        System.out.println( "Game over" );
    }


    private static void playGame()
    {
        MatchTable tab = new MatchTable();
        int[] set;
        while ( true )
        {
            while ( null == ( set = tab.findMatch() ) )
            {
                if ( !tab.open3Cards() )
                {
                    return;
                }
            }
            for ( int i : set )
            {
                System.out.println( tab.getOpenCard( i ) + " " );
            }
            System.out.println();

            tab.remove3Cards( set );
            if ( !tab.enoughOpen() )
            {
                if ( !tab.open3Cards() )
                {
                    return;
                }
            }
        }
    }
}
