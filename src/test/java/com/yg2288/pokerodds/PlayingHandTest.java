package com.yg2288.pokerodds;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayingHandTest {
    public Card randCard() {
        Random rand = new Random();
        int randSuit = rand.nextInt(Card.Suit.values().length);
        int randRank = rand.nextInt(Card.Rank.values().length);
        return new Card(Card.Suit.values()[randSuit], Card.Rank.values()[randRank]);
    }

    public PlayingHand randPlayingHand() {
        Deck deck = new Deck();
        deck.shuffle();
        PlayingHand hand = new PlayingHand(deck.draw(5));
        return hand;
    }

    @Test
    public void playingHandTest1() {
        PlayingHand hand = randPlayingHand();
        assertTrue(!hand.addCard(randCard()));
    }

    @Test
    public void playingHandTest2() {
        Deck deck = new Deck();
        deck.shuffle();
        PlayingHand hand = new PlayingHand(deck.draw(3));
        assertTrue(hand.addCard(deck.draw()));
        assertEquals(hand.size(), 4);
    }
}
