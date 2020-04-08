package com.yg2288.pokerodds;

import static org.junit.Assert.*;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.types.Flush;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.yg2288.pokerodds.deck.Card.*;

public class FlushTest {
    protected List<Card> getCards1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.THREE));
        cards.add(new Card(Suit.CLUBS, Rank.FIVE));
        cards.add(new Card(Suit.CLUBS, Rank.SIX));
        cards.add(new Card(Suit.CLUBS, Rank.SEVEN));
        cards.add(new Card(Suit.CLUBS, Rank.EIGHT));
        return cards;
    }

    protected Flush getHand1() {
        return new Flush(getCards1());
    }

    protected Flush getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.TEN));
        cards.add(new Card(Suit.HEARTS, Rank.SIX));
        cards.add(new Card(Suit.HEARTS, Rank.FIVE));
        cards.add(new Card(Suit.HEARTS, Rank.FOUR));
        return new Flush(cards);
    }

    protected Flush getHand3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.TEN));
        cards.add(new Card(Suit.DIAMONDS, Rank.SEVEN));
        cards.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        cards.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        return new Flush(cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void flushTest1() {
        List<Card> cards = getCards1();
        cards.get(0).setSuit(Suit.DIAMONDS);
        Flush hand1 = new Flush(cards);
    }

    @Test
    public void flushTest2() {
        Flush hand1 = getHand1();
        assertEquals(Suit.CLUBS, hand1.getFlushSuit());
    }

    @Test
    public void flushTest3() {
        Flush hand1 = getHand1();
        assertEquals(Rank.EIGHT, hand1.getCard(0).getRank());
    }

    @Test
    public void flushTest4() {
        Flush hand1 = getHand1();
        Flush hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) < 0);
    }

    @Test
    public void flushTest5() {
        Flush hand1 = getHand2();
        Flush hand2 = getHand3();
        assertTrue(hand1.compareTo(hand2) < 0);
    }

    @Test
    public void flushTest6() {
        Flush hand1 = getHand1();
        Flush hand2 = getHand1();
        assertEquals(0, hand1.compareTo(hand2));
    }
}
