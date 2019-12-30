package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StartingHandTest {
    public Card randCard() {
        Random rand = new Random();
        int randSuit = rand.nextInt(Card.Suit.values().length);
        int randRank = rand.nextInt(Card.Rank.values().length);
        return new Card(Card.Suit.values()[randSuit], Card.Rank.values()[randRank]);
    }

    public StartingHand randStartingHand() {
        Deck deck = new Deck();
        deck.shuffle();
        StartingHand hand = new StartingHand();
        hand.addCard(deck.draw());
        hand.addCard(deck.draw());
        return hand;
    }

    @Test
    public void startingHandTest1() {
        StartingHand hand = new StartingHand();
        assertTrue(hand.addCard(randCard()));
        assertTrue(hand.addCard(randCard()));
        assertTrue(!hand.addCard(randCard()));
    }

    @Test
    public void startingHandTest2() {
        List<Card> card = List.of(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT), new Card(Card.Suit.CLUBS, Card.Rank.FIVE));
        StartingHand hand = new StartingHand(card);
        assertEquals(hand.highCard(), card.get(0));
        assertEquals(hand.lowCard(), card.get(1));
    }

    @Test
    public void startingHandTest3() {
        StartingHand hand = new StartingHand();
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.FIVE));
        assertTrue(!hand.isPocketPair());
    }

    @Test
    public void startingHandTest4() {
        StartingHand hand = new StartingHand();
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));
        assertTrue(hand.isPocketPair());
    }

    @Test
    public void startingHandTest5() {
        StartingHand hand = new StartingHand();
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));
        assertTrue(hand.isOffSuit());
    }

    @Test
    public void startingHandTest6() {
        StartingHand hand = new StartingHand();
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN));
        assertTrue(!hand.isOffSuit());
    }
}
