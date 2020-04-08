package com.yg2288.pokerodds;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.deck.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckTest {
    @Test
    public void newDeckSizeShouldBe52() {
        Deck deck = new Deck();
        Assert.assertEquals(52, deck.size());
    }

    @Test
    public void excludeCardTest() {
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
    public void clearDeckTest() {
        Deck deck = new Deck();
        deck.clear();
        Assert.assertEquals(0, deck.size());
    }

    @Test
    public void cardInDeckTest() {
        Deck deck = new Deck();
        Card card = deck.draw();
        Assert.assertTrue(!deck.inDeck(card));
    }

    @Test
    public void drawNCardsTest() {
        Deck deck = new Deck();
        List<Card> l = deck.draw(10);
        Assert.assertEquals(10, l.size());
    }

    @Test
    public void overDrawDeckTest() {
        Deck deck = new Deck();
        List<Card> l = deck.draw(100);
        Assert.assertEquals(52, l.size());
    }
}
