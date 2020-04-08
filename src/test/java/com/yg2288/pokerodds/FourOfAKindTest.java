package com.yg2288.pokerodds;

import static org.junit.Assert.*;

import com.yg2288.pokerodds.deck.Card;
import com.yg2288.pokerodds.hand.types.FourOfAKind;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.yg2288.pokerodds.deck.Card.*;

public class FourOfAKindTest {
    protected List<Card> getCards1() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.THREE));
        cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
        cards.add(new Card(Suit.HEARTS, Rank.THREE));
        cards.add(new Card(Suit.SPADES, Rank.THREE));
        cards.add(new Card(Suit.CLUBS, Rank.TWO));
        return cards;
    }

    protected FourOfAKind getHand1() {
        return new FourOfAKind(getCards1());
    }

    protected FourOfAKind getHand2() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.FOUR));
        cards.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        cards.add(new Card(Suit.HEARTS, Rank.FOUR));
        cards.add(new Card(Suit.SPADES, Rank.FOUR));
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        return new FourOfAKind(cards);
    }

    protected FourOfAKind getHand3() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.CLUBS, Rank.FOUR));
        cards.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        cards.add(new Card(Suit.HEARTS, Rank.FOUR));
        cards.add(new Card(Suit.SPADES, Rank.FOUR));
        cards.add(new Card(Suit.CLUBS, Rank.THREE));
        return new FourOfAKind(cards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fourKindTest1() {
        List<Card> cards = getCards1();
        cards.get(0).setRank(Rank.ACE);
        new FourOfAKind(cards);
    }

    @Test
    public void fourKindTest2() {
        FourOfAKind hand1 = getHand1();
        assertEquals(Rank.THREE, hand1.getQuadRank());
        assertEquals(Rank.TWO, hand1.getKickerRank());
    }

    @Test
    public void fourKindTest3() {
        FourOfAKind hand1 = getHand1();
        FourOfAKind hand2 = getHand2();
        assertTrue(hand1.compareTo(hand2) < 0);
        assertTrue(hand2.compareTo(hand1) > 0);
    }

    @Test
    public void fourKindTest4() {
        FourOfAKind hand1 = getHand2();
        FourOfAKind hand2 = getHand3();
        assertTrue(hand1.compareTo(hand2) > 0);
    }

    @Test
    public void fourKindTest5() {
        FourOfAKind hand1 = getHand1();
        FourOfAKind hand2 = getHand1();
        assertEquals(0, hand1.compareTo(hand2));
    }
}
