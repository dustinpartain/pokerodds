package com.yg2288.pokerodds;

import static com.yg2288.pokerodds.Card.Rank.*;
import static com.yg2288.pokerodds.Card.Suit.*;
import static org.junit.Assert.*;
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
}
