package com.yg2288.pokerodds;

import static org.junit.Assert.*;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.HighCard;
import org.junit.Test;

import java.util.ArrayList;

public class HighCardTest {
    public HighCard getHighCard1() {
        ArrayList<Card> cards1 = new ArrayList<>();
        cards1.add(new Card(Card.Suit.CLUBS, Card.Rank.FIVE));
        cards1.add(new Card(Card.Suit.CLUBS, Card.Rank.SIX));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        cards1.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        return new HighCard(cards1);
    }

    public HighCard getHighCard2() {
        ArrayList<Card> cards1 = new ArrayList<>();
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.THREE));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SIX));
        return new HighCard(cards1);
    }

    public HighCard getHighCard3() {
        ArrayList<Card> cards1 = new ArrayList<>();
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SIX));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.THREE));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        return new HighCard(cards1);
    }

    public HighCard getHighCard4() {
        ArrayList<Card> cards1 = new ArrayList<>();
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SIX));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.THREE));
        cards1.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        cards1.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        return new HighCard(cards1);
    }

    @Test
    public void highCardTest1() {
        HighCard hand = getHighCard1();
        assertEquals(hand.highCard(), hand.getCard(0));
    }

    @Test
    public void highCardTest2() {
        HighCard hand1 = getHighCard1();
        HighCard hand2 = getHighCard2();
        assertTrue(hand1.compareTo(hand2) > 0);
    }

    @Test
    public void highCardTest3() {
        HighCard hand1 = getHighCard1();
        HighCard hand2 = getHighCard1();
        assertEquals(hand1.compareTo(hand2), 0);
    }

    @Test
    public void highCardTest4() {
        HighCard hand1 = getHighCard3();
        HighCard hand2 = getHighCard4();
        assertEquals(hand1.compareTo(hand2), 0);
    }
}
