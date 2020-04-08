package com.yg2288.pokerodds;

import static com.yg2288.pokerodds.deck.Card.Rank.*;
import static com.yg2288.pokerodds.deck.Card.Suit.*;
import static org.junit.Assert.*;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.types.StraightFlush;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StraightFlushTest {
    protected List<Card> getCards1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CLUBS, SEVEN));
        cards.add(new Card(CLUBS, SIX));
        cards.add(new Card(CLUBS, FIVE));
        cards.add(new Card(CLUBS, FOUR));
        cards.add(new Card(CLUBS, THREE));
        return cards;
    }

    protected StraightFlush getHand1() {
        return new StraightFlush(getCards1());
    }

    protected StraightFlush getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(DIAMONDS, NINE));
        cards.add(new Card(DIAMONDS, EIGHT));
        cards.add(new Card(DIAMONDS, SEVEN));
        cards.add(new Card(DIAMONDS, SIX));
        cards.add(new Card(DIAMONDS, FIVE));
        return new StraightFlush(cards);
    }

    protected StraightFlush getHand3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(DIAMONDS, ACE));
        cards.add(new Card(DIAMONDS, TWO));
        cards.add(new Card(DIAMONDS, THREE));
        cards.add(new Card(DIAMONDS, FOUR));
        cards.add(new Card(DIAMONDS, FIVE));
        return new StraightFlush(cards);
    }

    protected StraightFlush getHand4() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(DIAMONDS, ACE));
        cards.add(new Card(DIAMONDS, KING));
        cards.add(new Card(DIAMONDS, QUEEN));
        cards.add(new Card(DIAMONDS, JACK));
        cards.add(new Card(DIAMONDS, TEN));
        return new StraightFlush(cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void straightFlushTest1() {
        List<Card> cards = getCards1();
        cards.get(0).setRank(NINE);
        new StraightFlush(cards);
    }

    @Test
    public void straightFlushTest2() {
        StraightFlush hand1 = getHand1();
        assertEquals(SEVEN, hand1.getStraightFlushRank());
    }

    @Test
    public void straightFlushTest3() {
        StraightFlush hand1 = getHand1();
        StraightFlush hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) < 0);
        assertTrue(hand2.compareTo(hand1) > 0);
    }

    @Test
    public void straightFlushTest4() {
        StraightFlush hand1 = getHand1();
        assertEquals(0, hand1.compareTo(hand1));
    }

    @Test
    public void highCardShouldBeFive() {
        StraightFlush hand1 = getHand3();
        assertEquals(FIVE, hand1.getStraightFlushRank());
    }

    @Test
    public void highCardShouldBeAce() {
        StraightFlush hand1 = getHand4();
        assertEquals(ACE, hand1.getStraightFlushRank());
    }
}
