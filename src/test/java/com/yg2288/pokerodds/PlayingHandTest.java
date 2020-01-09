package com.yg2288.pokerodds;

import static com.yg2288.pokerodds.Card.Rank.*;
import static com.yg2288.pokerodds.Card.Suit.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
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

    protected List<Card> getCards1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CLUBS, SEVEN));
        cards.add(new Card(CLUBS, SIX));
        cards.add(new Card(CLUBS, FIVE));
        cards.add(new Card(CLUBS, FOUR));
        cards.add(new Card(CLUBS, THREE));
        return cards;
    }

    protected List<Card> getCards2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CLUBS, FOUR));
        cards.add(new Card(DIAMONDS, FOUR));
        cards.add(new Card(HEARTS, FOUR));
        cards.add(new Card(SPADES, FOUR));
        cards.add(new Card(CLUBS, THREE));
        return cards;
    }

    @Test
    public void playingHandTest1() {
        PlayingHand hand = randPlayingHand();
        assertTrue(!hand.addCard(randCard()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void playingHandTest2() {
        Deck deck = new Deck();
        deck.shuffle();
        PlayingHand hand = new PlayingHand(deck.draw(3));
    }

    @Test
    public void profileTest() {
        int[] profile = {8, 5, 0, 0, 0};
        List<Card> cards = getCards1();
        assertArrayEquals(profile, PlayingHand.getProfile(cards));
    }

    @Test
    public void bucketTest() {
        List<Card> cards = getCards2();
        assertEquals(4, PlayingHand.getBuckets(cards).get(FOUR.ordinal()).size());
    }
}
