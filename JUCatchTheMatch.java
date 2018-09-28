import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.Assert;
import org.junit.Test;


/**
 *  J Unit Testing
 *
 *  @author  siriwansereesathien
 *  @version Jun 1, 2016
 *  @author  Period: 5
 *  @author  Assignment: CatchTheMatch
 *
 *  @author  Sources: TODO
 */
public class JUCatchTheMatch
{
    private int id = 12;

    private int capacity = 10;


    @Test
    public void cardConstructor()
    {
        Card card = new Card( id );
        String toStr = card.toString();

        assertTrue( "<< Invalid Card Constructor >> ",
            toStr.contains( id + "" ) );
    }


    @Test
    public void cardGetId()
    {
        Card card = new Card( id );
        assertEquals( "<< Card: " + card.getId() + " should be " + id,
            id,
            card.getId() );
    }


    @Test
    public void cardCompareTo()
    {
        Card card = new Card( id );
        Card card2 = new Card( 12 );
        Card card3 = new Card( 14 );
        Card card4 = new Card( 10 );

        assertEquals( "<< Card: compare(card) should be 0 >>",
            card.compareTo( card2 ),
            0 );
        assertEquals( "<< Card: compare(card) should be -1 >>",
            card.compareTo( card3 ),
            -1 );
        assertEquals( "<< Card: compare(card) should be 1 >>",
            card.compareTo( card4 ),
            1 );
    }


    @Test
    public void cardEquals()
    {
        Card card = new Card( id );
        Object other = new Card( id );
        Object other2 = new Card( 10 );

        assertTrue( "<< Card should be equal >>", card.equals( other ) );
        assertFalse( "<< Card are not equal >>", card.equals( other2 ) );

    }


    @Test
    public void deckConstructor()
    {
        Deck deck = new Deck();
        String toStr = deck.toString();

        assertTrue( "<< Invalid Deck Constructor >> ",
            toStr.contains( deck + "" ) );
    }


    @Test
    public void deckGetNumCards()
    {
        Deck deck = new Deck();
        deck.add( new Card( id ) );
        deck.add( new Card( 10 ) );
        deck.add( new Card( 11 ) );
        assertEquals(
            "<< Deck: " + deck.getNumCards() + " should be " + 3 + " >>",
            3,
            deck.getNumCards() );
    }


    @Test
    public void deckIsEmpty()
    {
        Deck deck = new Deck();
        deck.add( new Card( id ) );
        ArrayList<Card> deck2 = new ArrayList<Card>();
        assertTrue( "<< Deck should be empty >>", deck2.isEmpty() );
        assertFalse( "<< Deck are not empty >>", deck.isEmpty() );
    }


    @Test
    public void deckAdd()
    {
        Deck deck = new Deck();
        Card card = new Card( id );
        deck.add( card );
        assertEquals(
            "<< Deck: " + deck.getNumCards() + " should contains " + 1,
            1,
            deck.getNumCards() );
    }


    @Test
    public void deckShuffle()
    {
        Deck deck = new Deck();
        deck.add( new Card( id ) );
        deck.add( new Card( 11 ) );
        deck.add( new Card( 13 ) );
        deck.add( new Card( 14 ) );

        Deck original = new Deck();
        while ( !deck.isEmpty() )
        {
            original.add( deck.takeTop() );
        }

        deck.add( new Card( id ) );
        deck.add( new Card( 11 ) );
        deck.add( new Card( 13 ) );
        deck.add( new Card( 14 ) );
        deck.shuffle();

        Deck shuffled = new Deck();
        while ( !deck.isEmpty() )
        {
            shuffled.add( deck.takeTop() );
        }
        assertNotEquals(
            "<< Deck: " + original + " shuffled should contain " + shuffled,
            shuffled,
            original );
    }


    @Test
    public void deckSort()
    {
        Deck deck = new Deck();
        deck.add( new Card( 12 ) );
        deck.add( new Card( 11 ) );
        deck.add( new Card( 13 ) );
        deck.add( new Card( 14 ) );

        Deck original = new Deck();
        while ( !deck.isEmpty() )
        {
            original.add( deck.takeTop() );

        }

        deck.add( new Card( 12 ) );
        deck.add( new Card( 11 ) );
        deck.add( new Card( 13 ) );
        deck.add( new Card( 14 ) );
        deck.sort();

        Deck sorted = new Deck();
        sorted.add( new Card( 11 ) );
        sorted.add( new Card( 12 ) );
        sorted.add( new Card( 13 ) );
        sorted.add( new Card( 14 ) );

        assertNotEquals(
            "<< Deck: " + original + " sorted should contain " + sorted,
            sorted,
            original );
    }


    @Test
    public void deckToString()
    {
        Deck deck = new Deck();

        deck.add( new Card( 12 ) );
        deck.add( new Card( 11 ) );
        deck.add( new Card( 13 ) );
        deck.add( new Card( 14 ) );

        assertNotNull( deck.toString() );
    }


    @Test
    public void MatchDeckCostructor()
    {
        MatchDeck mDeck = new MatchDeck();
        String x = mDeck.toString();
        assertTrue( "<< MatchDeck Constructor >>", x.contains( "MatchCard" ) );
    }


    @Test
    public void MatchCardConstructor()
    {
        MatchCard mCard = new MatchCard( 1, 2, 3, 4 );
        String x = mCard.toString();

        assertTrue( "<< MatchCard Constructor >>",
            x.contains( "MatchCard number=" + 1 ) && x.contains( "shape=" + 2 )
                && x.contains( "fill=" + 3 ) && x.contains( "color=" + 4 ) );

    }


    @Test
    public void MatchCardGetColor()
    {
        MatchCard mCard = new MatchCard( 1, 2, 3, 4 );

        assertEquals( "<< MatchCard: " + mCard.getColor() + " should be " + 4,
            4,
            mCard.getColor() );

    }


    @Test
    public void MatchCardGetFill()
    {
        MatchCard mCard = new MatchCard( 1, 2, 3, 4 );

        assertEquals( "<< MatchCard: " + mCard.getFill() + " should be " + 3,
            3,
            mCard.getFill() );

    }


    @Test
    public void MatchCardGetShape()
    {
        MatchCard mCard = new MatchCard( 1, 2, 3, 4 );

        assertEquals( "<< MatchCard: " + mCard.getShape() + " should be " + 2,
            2,
            mCard.getShape() );

    }


    @Test
    public void MatchCardGetNumber()
    {
        MatchCard mCard = new MatchCard( 1, 2, 3, 4 );

        assertEquals( "<< MatchCard: " + mCard.getNumber() + " should be " + 1,
            1,
            mCard.getNumber() );

    }


    @Test
    public void MatchCardToString()
    {
        MatchCard mCard = new MatchCard( 1, 2, 3, 4 );
        String x = mCard.toString();

        assertTrue( "<< MatchCard Constructor >>",
            x.contains( "MatchCard number=" + 1 ) && x.contains( "shape=" + 2 )
                && x.contains( "fill=" + 3 ) && x.contains( "color=" + 4 ) );

    }


    @Test
    public void MatchTableConstructor()
    {
        MatchTable mTable = new MatchTable();
        String x = mTable.toString();
        assertTrue( "<< MatchCard Constructor >>",
            x.contains( "MatchCard number=" ) && x.contains( "shape=" )
                && x.contains( "fill=" ) && x.contains( "color=" ) );
    }


    @Test
    public void MatchTableCardsInDeck()
    {
        MatchTable mTable = new MatchTable();
        assertEquals(
            "<< MatchTable: " + mTable.cardsInDeck() + " should be " + 69,
            69,
            mTable.cardsInDeck() );
    }


    @Test
    public void MatchTableGetOpenCard()
    {
        MatchTable mTable = new MatchTable();
        String x = mTable.getOpenCard( 1 ).toString();
        assertTrue( "<< MatchTable >> ",
            x.contains( "MatchCard number=" ) && x.contains( "shape=" )
                && x.contains( "fill=" ) && x.contains( "color=" ) );
    }


    @Test
    public void MatchTableToString()
    {
        MatchTable mTable = new MatchTable();
        String x = mTable.getOpenCard( 1 ).toString();
        assertTrue( "<< MatchTable >> ",
            x.contains( "MatchCard number=" ) && x.contains( "shape=" )
                && x.contains( "fill=" ) && x.contains( "color=" ) );
    }

}
