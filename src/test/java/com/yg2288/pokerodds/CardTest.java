package com.yg2288.pokerodds;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void cardTest1() {
        Card card = new Card(Suit.DIAMONDS, Rank.ACE);
        Assert.assertTrue(card.toString().equals("ACE of DIAMONDS"));
    }

    @Test
    public void cardTest2() {
        Card card = new Card(Suit.CLUBS, Rank.TWO);
        Assert.assertTrue(card.toString().equals("2 of CLUBS"));
    }

    @Test
    public void cardTest3() {
        Card card = new Card(Suit.HEARTS, Rank.TEN);
        Assert.assertTrue(card.toString().equals("10 of HEARTS"));
    }

    @Test
    public void cardTest4() {
        Assert.assertTrue(Rank.TEN.getRank() == 10);
    }

    @Test
    public void cardTest5() {
        Assert.assertTrue(Rank.ACE.getRank() == 14);
    }

    @Test
    public void cardTest6() {
        Card card1 = new Card(Suit.CLUBS, Rank.KING);
        Card card2 = new Card(Suit.CLUBS, Rank.ACE);
        Assert.assertTrue(card1.compareTo(card2) < 0);
    }

    @Test
    public void cardTest7() {
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.SPADES, Rank.ACE);
        Assert.assertTrue(card1.compareTo(card2) == 0);
    }

    @Test
    public void cardTest11() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Assert.assertTrue(card1.getSuit() == Suit.CLUBS);
    }

    @Test
    public void cardTest12() {
        Card card1 = new Card(Suit.CLUBS, Rank.ACE);
        Card card2 = new Card(Suit.CLUBS, Rank.TWO);
        Assert.assertTrue(card1.compareTo(card2) == 12);
    }
}
