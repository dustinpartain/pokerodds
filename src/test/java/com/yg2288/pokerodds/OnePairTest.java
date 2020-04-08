package com.yg2288.pokerodds;

import static org.junit.Assert.*;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.OnePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OnePairTest {
    public OnePair getHand1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(cards);
    }

    public OnePair getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.TWO));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(cards);
    }

    public OnePair getHand3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
        cards.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.SEVEN));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(cards);
    }

    @Test
    public void onePairTest1() {
        OnePair hand = getHand1();
        assertEquals(Card.Rank.ACE, hand.getPairRank());
    }

    @Test
    public void onePairTest2() {
        OnePair hand1 = getHand1();
        OnePair hand2 = getHand1();
        assertEquals(0, hand1.compareTo(hand2));
    }

    @Test
    public void onePairTest3() {
        OnePair hand1 = getHand1();
        OnePair hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) > 0);
        assertTrue(hand2.compareTo(hand1) < 0);
    }

    @Test
    public void onePairTest4() {
        OnePair hand1 = getHand2();
        OnePair hand2 = getHand3();
        assertTrue(hand1.compareTo(hand2) < 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void onePairTest5() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Suit.SPADES, Card.Rank.SEVEN));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        cards.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        OnePair hand1 = new OnePair(cards);
    }
}
