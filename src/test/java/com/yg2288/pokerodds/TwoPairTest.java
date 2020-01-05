package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.Card.*;

public class TwoPairTest {
    public TwoPair getHand1() {
        List<Card> pair1 = new ArrayList<>();
        List<Card> pair2 = new ArrayList<>();
        Card kicker = new Card(Suit.SPADES, Rank.SEVEN);
        pair1.add(new Card(Suit.CLUBS, Rank.ACE));
        pair1.add(new Card(Suit.SPADES, Rank.ACE));
        pair2.add(new Card(Suit.CLUBS, Rank.TWO));
        pair2.add(new Card(Suit.SPADES, Rank.TWO));
        return new TwoPair(pair1, pair2, kicker);
    }

    public TwoPair getHand2() {
        List<Card> pair1 = new ArrayList<>();
        List<Card> pair2 = new ArrayList<>();
        Card kicker = new Card(Suit.SPADES, Rank.NINE);
        pair1.add(new Card(Suit.CLUBS, Rank.FOUR));
        pair1.add(new Card(Suit.SPADES, Rank.FOUR));
        pair2.add(new Card(Suit.CLUBS, Rank.TWO));
        pair2.add(new Card(Suit.SPADES, Rank.TWO));
        return new TwoPair(pair1, pair2, kicker);
    }

    public TwoPair getHand3() {
        List<Card> pair1 = new ArrayList<>();
        List<Card> pair2 = new ArrayList<>();
        Card kicker = new Card(Suit.SPADES, Rank.NINE);
        pair1.add(new Card(Suit.CLUBS, Rank.ACE));
        pair1.add(new Card(Suit.SPADES, Rank.ACE));
        pair2.add(new Card(Suit.CLUBS, Rank.TWO));
        pair2.add(new Card(Suit.SPADES, Rank.TWO));
        return new TwoPair(pair1, pair2, kicker);
    }

    public TwoPair getHand4() {
        List<Card> pair1 = new ArrayList<>();
        List<Card> pair2 = new ArrayList<>();
        Card kicker = new Card(Suit.SPADES, Rank.NINE);
        pair1.add(new Card(Suit.DIAMONDS, Rank.ACE));
        pair1.add(new Card(Suit.SPADES, Rank.ACE));
        pair2.add(new Card(Suit.DIAMONDS, Rank.TWO));
        pair2.add(new Card(Suit.SPADES, Rank.TWO));
        return new TwoPair(pair1, pair2, kicker);
    }

    @Test
    public void twoPairTest1() {
        TwoPair hand = getHand1();
        assertEquals(hand.getHighPair().get(0).getRank(), Rank.ACE);
    }

    @Test
    public void twoPairTest2() {
        TwoPair hand = getHand2();
        assertEquals(hand.getLowPair().get(0).getRank(), Rank.TWO);
    }

    @Test
    public void twoPairTest3() {
        TwoPair hand1 = getHand1();
        TwoPair hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) > 0);
    }

    @Test
    public void twoPairTest4() {
        TwoPair hand1 = getHand1();
        TwoPair hand2 = getHand3();
        assertTrue(hand1.compareTo(hand2) < 0);
    }

    @Test
    public void twoPairTest5() {
        TwoPair hand1 = getHand1();
        TwoPair hand2 = getHand1();
        assertEquals(0, hand1.compareTo(hand2));
    }

    @Test
    public void twoPairTest6() {
        TwoPair hand1 = getHand3();
        TwoPair hand2 = getHand4();
        assertEquals(0, hand1.compareTo(hand2));
    }
}
