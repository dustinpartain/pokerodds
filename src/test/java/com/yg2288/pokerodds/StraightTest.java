package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.Card.*;

public class StraightTest {
    protected Straight getHand1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.TWO));
        cards.add(new Card(Suit.HEARTS, Rank.THREE));
        cards.add(new Card(Suit.CLUBS, Rank.FOUR));
        cards.add(new Card(Suit.HEARTS, Rank.FIVE));
        return new Straight(cards);
    }

    protected Straight getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.TEN));
        cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
        cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
        cards.add(new Card(Suit.CLUBS, Rank.KING));
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        return new Straight(cards);
    }

    protected Straight getHand3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.FOUR));
        cards.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        cards.add(new Card(Suit.HEARTS, Rank.SIX));
        cards.add(new Card(Suit.CLUBS, Rank.SEVEN));
        cards.add(new Card(Suit.HEARTS, Rank.EIGHT));
        return new Straight(cards);
    }

    @Test
    public void straightTest1() {
        Straight hand1 = getHand1();
        assertEquals(Rank.FIVE, hand1.getHighCard().getRank());
    }

    @Test
    public void straightTest2() {
        Straight hand1 = getHand2();
        assertEquals(Rank.ACE, hand1.getHighCard().getRank());
    }

    @Test
    public void straightTest3() {
        Straight hand1 = getHand3();
        assertEquals(Rank.EIGHT, hand1.getHighCard().getRank());
    }
}
