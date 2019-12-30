package com.yg2288.pokerodds;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Random;

public class HandTest {
    public Card randCard() {
        Random rand = new Random();
        int randSuit = rand.nextInt(Card.Suit.values().length);
        int randRank = rand.nextInt(Card.Rank.values().length);
        return new Card(Card.Suit.values()[randSuit], Card.Rank.values()[randRank]);
    }

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

    @Test
    public void handTest4() {
        StartingHand hand = new StartingHand();
        Assert.assertTrue(hand.addCard(randCard()));
        Assert.assertTrue(hand.addCard(randCard()));
        Assert.assertTrue(!hand.addCard(randCard()));
    }
}
