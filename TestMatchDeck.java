
public class TestMatchDeck
{
    public static void main( String[] args )
    {
        MatchDeck dec = new MatchDeck();
        dec.shuffle();
        for ( int i = 0; i < 3; i++ )
        {
            System.out.println( dec.takeTop() );
        }
    }
}
