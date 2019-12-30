package com.yg2288.pokerodds;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckTest {
    @Test
    public void deckTest1() {
        Deck deck = new Deck();
        Assert.assertTrue(deck.size() == 52);
    }

    @Test
    public void deckTest2() {
        List<Card> excludeCards = new ArrayList<>();
        Card excluded1 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Card excluded2 = new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT);
        excludeCards.add(excluded1);
        excludeCards.add(excluded2);
        Deck deck = new Deck(excludeCards);
        Assert.assertTrue(!deck.inDeck(excluded1));
        Assert.assertTrue(!deck.inDeck(excluded2));
    }
}
