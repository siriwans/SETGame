public class TestDeck
{
    public static void main( String[] args )
    {
        Deck dec = new Deck();
        prnt( dec, "Fresh deck" );

        for ( int i = 0; i < 6; i++ )
        {
            dec.add( new Card( i ) );
        }
        prnt( dec, "After adding cards" );
        dec.shuffle();
        prnt( dec, "After shuffle" );

        dec.sort();
        prnt( dec, "After sort" );

        prntHead( "Cards remaining in order" );
        while ( !dec.isEmpty() )
        {
            System.out.println( dec.takeTop().toString() );
        }
        prntHead( "Cards from empty deck" );
        try
        {
            System.out.println( dec.takeTop().toString() );
        }
        catch ( NullPointerException e )
        {
            System.out.println( "Caught null pointer exception" );
        }
    }


    private static void prnt( Deck dec, String str )
    {
        if ( str != null )
        {
            prntHead( str );
        }
        System.out.println( dec.toString() );
        System.out.println( "size: " + dec.getNumCards() );
        System.out.println( "empty: )" + dec.isEmpty() );
    }


    private static void prntHead( String str )
    {
        System.out.println( str );
    }
}
