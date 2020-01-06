package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.Card.*;

public class FullHouseTest {
    protected List<Card> getCards1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.THREE));
        cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
        cards.add(new Card(Suit.HEARTS, Rank.THREE));
        cards.add(new Card(Suit.SPADES, Rank.TWO));
        cards.add(new Card(Suit.CLUBS, Rank.TWO));
        return cards;
    }

    public FullHouse getHand1() {
        return new FullHouse(getCards1());
    }

    @Test(expected = IllegalArgumentException.class)
    public void fullHouseTest1() {
        List<Card> cards = getCards1();
        cards.get(0).setRank(Rank.ACE);
        FullHouse hand1 = new FullHouse(cards);
    }

    @Test
    public void fullHouseTest2() {
        FullHouse hand1 = getHand1();
        assertEquals(Rank.THREE, hand1.getTripletRank());
        assertEquals(Rank.TWO, hand1.getPairRank());
    }
}
