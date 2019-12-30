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

    @Test
    public void deckTest3() {
        Deck deck = new Deck();
        deck.clear();
        Assert.assertEquals(deck.size(), 0);
    }

    @Test
    public void deckTest4() {
        Deck deck = new Deck();
        Card card = deck.draw();
        Assert.assertTrue(!deck.inDeck(card));
    }

    @Test
    public void deckTest5() {
        Deck deck = new Deck();
        List<Card> l = deck.draw(10);
        Assert.assertEquals(l.size(), 10);
    }

    @Test
    public void deckTest6() {
        Deck deck = new Deck();
        List<Card> l = deck.draw(100);
        Assert.assertEquals(l.size(), 52);
    }
}
