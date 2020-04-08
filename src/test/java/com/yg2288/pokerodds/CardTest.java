package com.yg2288.pokerodds;

import com.yg2288.pokerodds.deck.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void aceNameTest() {
        Card card = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
        Assert.assertTrue(card.toString().equals("ACE of DIAMONDS"));
    }

    @Test
    public void cardNameTest1() {
        Card card = new Card(Card.Suit.CLUBS, Card.Rank.TWO);
        Assert.assertTrue(card.toString().equals("2 of CLUBS"));
    }

    @Test
    public void cardNameTest2() {
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.TEN);
        Assert.assertTrue(card.toString().equals("10 of HEARTS"));
    }

    @Test
    public void cardValueTest1() {
        Assert.assertTrue(Card.Rank.TEN.getValue() == 10);
    }

    @Test
    public void cardValueTest2() {
        Assert.assertTrue(Card.Rank.ACE.getValue() == 14);
    }

    @Test
    public void cardCompareRank1() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.KING);
        Card card2 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Assert.assertTrue(card1.compareTo(card2) < 0);
    }

    @Test
    public void cardCompareRank2() {
        Card card1 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Card card2 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Assert.assertTrue(card1.compareTo(card2) == 0);
    }

    @Test
    public void cardSuitTest() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Assert.assertTrue(card1.getSuit() == Card.Suit.CLUBS);
    }

    @Test
    public void cardComparatorTest1() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Card card2 = new Card(Card.Suit.CLUBS, Card.Rank.TWO);
        Assert.assertTrue(card1.compareTo(card2) == 12);
    }

    @Test
    public void cardComparatorTest2() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
        Card card2 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Assert.assertTrue(card1.compareTo(card2) < 0);
    }

    @Test
    public void cardEqualsTest1() {
        Card card1 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Card card2 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Assert.assertTrue(card1.equals(card2));
    }

    @Test
    public void cardEqualsTest2() {
        Card card1 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Card card2 = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
        Assert.assertTrue(!card1.equals(card2));
    }

    @Test
    public void cardEqualsTest3() {
        Card card1 = new Card(Card.Suit.SPADES, Card.Rank.ACE);
        Card card2 = card1.clone();
        Assert.assertTrue(card1.equals(card2));
    }
}
