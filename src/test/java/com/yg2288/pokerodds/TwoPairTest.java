package com.yg2288.pokerodds;

import static org.junit.Assert.*;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.TwoPair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.deck.Card.*;

public class TwoPairTest {
    public TwoPair getHand1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.SPADES, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.SEVEN));
        return new TwoPair(cards);
    }

    public TwoPair getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.FOUR));
        cards.add(new Card(Suit.SPADES, Rank.FOUR));
        cards.add(new Card(Suit.CLUBS, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.NINE));
        return new TwoPair(cards);
    }

    public TwoPair getHand3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.SPADES, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.NINE));
        return new TwoPair(cards);
    }

    public TwoPair getHand4() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        cards.add(new Card(Suit.SPADES, Rank.ACE));
        cards.add(new Card(Suit.DIAMONDS, Rank.TWO));
        cards.add(new Card(Suit.SPADES, Rank.TWO));
        cards.add(new Card(Suit.HEARTS, Rank.NINE));
        return new TwoPair(cards);
    }

    @Test
    public void twoPairTest1() {
        TwoPair hand = getHand1();
        assertEquals(Rank.ACE, hand.getHighPairRank());
    }

    @Test
    public void kickerShouldBeSeven() {
        TwoPair hand = getHand1();
        assertEquals(Rank.SEVEN, hand.getKickerRank());
    }

    @Test
    public void twoPairTest2() {
        TwoPair hand = getHand2();
        assertEquals(Rank.TWO, hand.getLowPairRank());
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
        TwoPair hand1 = getHand3();
        TwoPair hand2 = getHand4();
        assertEquals(0, hand1.compareTo(hand2));
    }
}
