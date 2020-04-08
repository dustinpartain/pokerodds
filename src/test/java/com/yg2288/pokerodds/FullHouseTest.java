package com.yg2288.pokerodds;

import static org.junit.Assert.*;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.types.FullHouse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.deck.Card.*;

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

    protected FullHouse getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.FOUR));
        cards.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        cards.add(new Card(Suit.HEARTS, Rank.FOUR));
        cards.add(new Card(Suit.SPADES, Rank.TWO));
        cards.add(new Card(Suit.CLUBS, Rank.TWO));
        return new FullHouse(cards);
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

    @Test
    public void fullHouseTest3() {
        FullHouse hand1 = getHand1();
        FullHouse hand2 = getHand1();
        assertEquals(0, hand1.compareTo(hand2));
    }

    @Test
    public void fullHouseTest4() {
        FullHouse hand1 = getHand1();
        FullHouse hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) < 0);
    }
}
