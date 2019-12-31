package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class OnePairTest {
    public OnePair getHand1() {
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        pair.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        ArrayList<Card> rest = new ArrayList<>();
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(pair, rest);
    }

    public OnePair getHand2() {
        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(Card.Suit.SPADES, Card.Rank.TWO));
        pair.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        ArrayList<Card> rest = new ArrayList<>();
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.TWO));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        rest.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        return new OnePair(pair, rest);
    }

    @Test
    public void onePairTest1() {
        OnePair hand = getHand1();
        assertEquals(hand.getPair().get(0).getRank(), hand.getPair().get(1).getRank());
    }
}
