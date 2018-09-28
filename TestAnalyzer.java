public class TestAnalyzer
{
    public static void main( String[] args )
    {
        MatchDeck deck = new MatchDeck();
        deck.shuffle();
        MatchCard card = (MatchCard)( deck.takeTop() ),
                        card1 = (MatchCard)( deck.takeTop() ),
                        card2 = (MatchCard)( deck.takeTop() );
        System.out.println( card );
        System.out.println( card1 );
        System.out.println( card2 );
        System.out.println( MatchAnalyzer.isMatch( card, card1, card2 ) );

        for ( int i = 0; i < deck.getNumCards(); i += 3 )
        {
            System.out.print( MatchAnalyzer.isMatch( (MatchCard)deck.takeTop(),
                (MatchCard)deck.takeTop(),
                (MatchCard)deck.takeTop() ) + "" );
        }
        System.out.println();

        MatchCard cardd1 = new MatchCard( 1, 1, 1, 3 );
        MatchCard cardd2 = new MatchCard( 1, 2, 2, 3 );
        MatchCard cardd3 = new MatchCard( 1, 3, 3, 3 );
        System.out.print( MatchAnalyzer.isMatch( cardd1, cardd2, cardd3 ) );

        MatchCard card4 = new MatchCard( 1, 2, 1, 2 );
        MatchCard card5 = new MatchCard( 2, 3, 1, 2 );
        MatchCard card6 = new MatchCard( 1, 3, 1, 2 );
        MatchCard[] cards = { card4, card5, card6, cardd1, cardd2, cardd3 };
        int Matches[] = MatchAnalyzer.findMatch( cards );
        System.out.print( Matches );

    }
}