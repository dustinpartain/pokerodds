package com.yg2288.pokerodds;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void cardTest1() {
        Card card = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
        Assert.assertTrue(card.toString().equals("ACE of DIAMONDS"));
    }

    @Test
    public void cardTest2() {
        Card card = new Card(Card.Suit.CLUBS, Card.Rank.TWO);
        Assert.assertTrue(card.toString().equals("2 of CLUBS"));
    }

    @Test
    public void cardTest3() {
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.TEN);
        Assert.assertTrue(card.toString().equals("10 of HEARTS"));
    }

    @Test
    public void cardTest4() {
        Assert.assertTrue(Card.Rank.TEN.getValue() == 10);
    }

    @Test
    public void cardTest5() {
        Assert.assertTrue(Card.Rank.ACE.getValue() == 14);
    }

    @Test
    public void cardTest6() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.KING);
        Card card2 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Assert.assertTrue(card1.compareTo(card2) < 0);
    }

    @Test
    public void cardTest7() {
        Card card1 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Card card2 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Assert.assertTrue(card1.compareTo(card2) == 0);
    }

    @Test
    public void cardTest11() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Assert.assertTrue(card1.getSuit() == Card.Suit.CLUBS);
    }

    @Test
    public void cardTest12() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Card card2 = new Card(Card.Suit.CLUBS, Card.Rank.TWO);
        Assert.assertTrue(card1.compareTo(card2) == 12);
    }
}
