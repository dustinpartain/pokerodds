package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

public class HandTest {
    @Test
    public void handTest1() {
        Hand hand = new Hand();
        assertEquals(hand.toString(), "Hand is empty.");
    }

    @Test
    public void handTest2() {
        Hand hand = new Hand();
        assertEquals(hand.size(), 0);
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        assertEquals(hand.size(), 1);
    }

    @Test
    public void handTest3() {
        Hand hand = new Hand();
        Card card = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        hand.addCard(card);
        assertEquals(hand.getCard(0), card);
    }
}
