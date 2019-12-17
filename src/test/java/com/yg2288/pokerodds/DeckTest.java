package com.yg2288.pokerodds;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    @Test
    public void deckTest1() {
        Deck deck = new Deck();
        Assert.assertTrue(deck.size() == 52);
    }
}
